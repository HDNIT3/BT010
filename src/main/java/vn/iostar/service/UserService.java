package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<User> findAll();
}
