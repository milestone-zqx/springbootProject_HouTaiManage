package com.project.springboot001.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.springboot001.common.Constants;
import com.project.springboot001.entity.User;
import com.project.springboot001.entity.dto.UserDTO;
import com.project.springboot001.exception.ServiceException;
import com.project.springboot001.mapper.UserMapper;
import com.project.springboot001.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.springboot001.utils.TokenUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Qing
 * @since 2023-11-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one = getOne(queryWrapper);   //从数据库查讯用户信息
        if (one != null) {
            BeanUtil.copyProperties(one, userDTO, true);
            //设置token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误！");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        User one = getOne(queryWrapper);   //从数据库查讯用户信息
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
            save(one);//把复制完的用户对象储存到数据库
        } else {
            throw new ServiceException(Constants.CODE_600,"该用户名已存在，请重新取名！");
        }
        return one;
    }


}
