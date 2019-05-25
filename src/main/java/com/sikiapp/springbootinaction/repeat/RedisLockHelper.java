/**
 * projectName: spring-boot-in-action
 * fileName: RedisLockHelper.java
 * packageName: com.sikiapp.springbootinaction.repeat
 * date: 2019-05-25 下午10:23
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.repeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.util.StringUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @className: RedisLockHelper
 * @packageName: com.sikiapp.springbootinaction.repeat
 * @description: Redis 锁工具类
 * @author: Robert
 * @data: 2019-05-25 下午10:23
 * @version: V1.0
 **/
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisLockHelper {

    private static final String DELIMITER = "|";
    private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newScheduledThreadPool(10);

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisLockHelper(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     *@description: 获取锁（存在死锁风险）
     *@param: [lockKey, value, time, unit]
     */
    public boolean tryLock(final String lockKey, final String value, final long time, final TimeUnit unit) {
        return stringRedisTemplate.execute((RedisCallback<Boolean>) connection ->
            connection.set(lockKey.getBytes(), value.getBytes(), Expiration.from(time, unit), RedisStringCommands.SetOption.SET_IF_ABSENT)
        );
    }

    /**
     *@description: 获取锁
     *@param: [lockKey, uuid, timeout, unit]
     */
    public boolean lock(final String lockKey, final String uuid, long timeout, final TimeUnit unit) {
        long milliseconds = Expiration.from(timeout, unit).getExpirationTimeInMilliseconds();
        String value = (System.currentTimeMillis() + milliseconds) + DELIMITER + uuid;
        boolean success = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, value);
        if (success) {
            stringRedisTemplate.expire(lockKey, timeout, unit);
        } else {
            String old = stringRedisTemplate.opsForValue().getAndSet(lockKey, value);
            final String[] olds = old.split(Pattern.quote(DELIMITER));
            if (Long.parseLong(olds[0]) + timeout <= System.currentTimeMillis()) {
                return true;
            }
        }

        return success;
    }

    /**
     *@description: unlock
     *@param: [lockKey, value]
     */
    public void unlock(String lockKey, String value) {
        unlock(lockKey, value, 0, TimeUnit.MILLISECONDS);
    }

    /**
     *@description: 延迟uolock
     *@param: [lockKey, uuid, delayTime 延迟时间, unit]
     */
    public void unlock(final String lockKey, final String uuid, long delayTime, TimeUnit unit) {
        if (StringUtils.isEmpty(lockKey)) {
            return;
        }
        if (delayTime <= 0) {
            doUnlock(lockKey, uuid);
        } else {
            EXECUTOR_SERVICE.schedule(() -> doUnlock(lockKey, uuid), delayTime, unit);
        }
    }

    private void doUnlock(final String localKey, final String uuid) {
        String val = stringRedisTemplate.opsForValue().get(localKey);
        if (StringUtils.isEmpty(val)) {
            return;
        }
        final String[] values = val.split(Pattern.quote(DELIMITER));
        if (uuid.equals(values[1])) {
            stringRedisTemplate.delete(localKey);
        }
    }










}