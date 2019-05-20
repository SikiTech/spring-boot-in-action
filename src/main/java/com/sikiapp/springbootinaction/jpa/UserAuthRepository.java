/**
 * projectName: spring-boot-in-action
 * fileName: UserAuthRepository.java
 * packageName: com.sikiapp.springbootinaction.jpa
 * date: 2019-05-20 上午9:15
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.jpa;

import com.sikiapp.springbootinaction.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: UserAuthRepository
 * @packageName: com.sikiapp.springbootinaction.jpa
 * @description: JPA 操作
 * @author: Robert
 * @data: 2019-05-20 上午9:15
 * @version: V1.0
 **/
@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

}