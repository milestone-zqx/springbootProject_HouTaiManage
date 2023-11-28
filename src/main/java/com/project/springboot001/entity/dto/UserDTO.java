package com.project.springboot001.entity.dto;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
* 接受前端登录请求的参数
* */
@Data
@Getter
@Setter
public class UserDTO {
    @Alias("用户名")
    private String username;
    @Alias("密码")
    private String password;
    @Alias("昵称")
    private String nickname;
    @Alias("头像")
    private String avatarUrl;
    @Alias("邮箱")
    private String email;
    @Alias("电话")
    private String phone;
    private String token;
}
