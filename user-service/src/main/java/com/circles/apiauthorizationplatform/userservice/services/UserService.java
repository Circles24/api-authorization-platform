package com.circles.apiauthorizationplatform.userservice.services;

import com.circles.apiauthorizationplatform.userservice.errors.ErrorBuilder;
import com.circles.apiauthorizationplatform.userservice.models.User;
import com.circles.apiauthorizationplatform.userservice.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw ErrorBuilder.user_not_found.build();
        }

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw ErrorBuilder.user_not_found.build();
        }

        return user.get();
    }

    public User save(User user) {
        if (StringUtils.isNotBlank(user.getId())) {
            Optional<User> persistedUser = userRepository.findById(user.getId());
            if (persistedUser.isPresent()) {
                persistedUser.get().merge(user);
                return update(persistedUser.get());
            }
        }

        return create(user);
    }

    public User create(User user) {
        return userRepository.create(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }
}
