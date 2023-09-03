package com.github.moxut0.msocial.repository;

import com.github.moxut0.msocial.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
