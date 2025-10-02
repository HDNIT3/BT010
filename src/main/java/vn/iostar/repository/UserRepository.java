package vn.iostar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iostar.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}