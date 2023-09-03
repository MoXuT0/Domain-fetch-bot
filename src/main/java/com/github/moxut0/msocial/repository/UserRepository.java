package com.github.moxut0.msocial.repository;

import com.github.moxut0.msocial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
