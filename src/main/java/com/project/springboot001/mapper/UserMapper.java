package com.project.springboot001.mapper;

import com.project.springboot001.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Qing
 * @since 2023-11-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
