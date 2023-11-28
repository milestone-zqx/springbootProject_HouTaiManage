package com.project.springboot001.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    int insert(User user);

    int update(User user);
    int save(User user);
    int delete(Integer id);
    Map<String, Object> selectPage(Integer pageNum, Integer pageSize, String username);
}
