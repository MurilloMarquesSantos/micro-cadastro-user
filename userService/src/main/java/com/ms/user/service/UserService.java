package com.ms.user.service;

import com.ms.user.domain.User;
import com.ms.user.producer.UserProducer;
import com.ms.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserProducer userProducer;

    public User save(User user) {
        User savedUser = userRepository.save(user);
        userProducer.publishMessage(user);
        return savedUser;
    }
}
