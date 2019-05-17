/**
 * projectName: spring-boot-in-action
 * fileName: UserAuthRepository.java
 * packageName: com.sikiapp.springbootinaction.mapper
 * date: 2019-05-07 下午11:15
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.repository;

import com.sikiapp.springbootinaction.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @className: UserAuthRepository
 * @packageName: com.sikiapp.springbootinaction.mapper
 * @description: 仓库接口 jpa
 * @author: Robert
 * @data: 2019-05-07 下午11:15
 * @version: V1.0
 **/
@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

    // 自定义查询
    @Transactional(timeout = 10)
    @Query("from UserAuth u where u.identifier = :mobile")
    UserAuth findByIdentifier(@Param("mobile") String mobile);

    // 通过解析方法名创建查询(Spring-data-jpa 提供)
    UserAuth findByIdentifierAndCertificate(String Identifier, String Certificate);
}