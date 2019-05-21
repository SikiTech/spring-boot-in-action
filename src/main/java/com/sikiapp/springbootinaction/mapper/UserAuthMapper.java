/**
 * projectName: spring-boot-in-action
 * fileName: UserAuthMapper.java
 * packageName: com.sikiapp.springbootinaction.mapper
 * date: 2019-05-15 下午3:44
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.mapper;

import com.sikiapp.springbootinaction.model.UserAuth;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @className: UserAuthMapper
 * @packageName: com.sikiapp.springbootinaction.mapper
 * @description: Mapper Mybatis Demo
 * @author: Robert
 * @data: 2019-05-15 下午3:44
 * @version: V1.0
 **/
@Mapper
public interface UserAuthMapper extends BaseMapper<UserAuth> {

    // 注解方式
    @Select("select * from user_auth where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "identifier", column = "identifier")
    })
    UserAuth getOne(Integer id);

    // xml方式
    List<UserAuth> selectByUserBaseId(Integer userBaseId);
    UserAuth selectByIdentifier(@Param("identifier") String identifier, @Param("certificate") String certificate, @Param("identityType") Byte identityType);
    int updatePasswordByPhone(@Param("identifier") String identifier, @Param("certificate") String certificate);
}