package com.project.springboot001.service;

import com.project.springboot001.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.springboot001.entity.dto.UserDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Qing
 * @since 2023-11-28
 */
public interface IUserService extends IService<User> {
    UserDTO login(UserDTO userDTO);
    User register(UserDTO userDTO);
}
