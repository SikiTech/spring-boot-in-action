package com.sikiapp.springbootinaction.mapper.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @title: sikiMapper
 * @package com.sikiapp.springbootinaction.mapper.common
 * @description: 通用Mapper
 * @author: Robert
 * @date: 2019/5/24 上午10:32
 * @version: V1.0
*/
public interface sikiMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
