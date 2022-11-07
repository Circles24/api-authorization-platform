package com.circles.apiauthorizationplatform.userservice.repositories;

import com.circles.apiauthorizationplatform.userservice.daos.UserDao;
import com.circles.apiauthorizationplatform.userservice.models.User;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    @Autowired
    private Jdbi jdbi;

    public Optional<User> findById(String id) {
        return Optional.ofNullable(jdbi.withExtension(UserDao.class, dao -> dao.getById(id)));
    }

    public User create(User user) {
        if (StringUtils.isBlank(user.getId())) {
            user.setId(UUID.randomUUID().toString());
        }

        jdbi.withExtension(UserDao.class, dao -> dao.insert(user));
        return user;
    }

    public User update(User user) {
        jdbi.withExtension(UserDao.class, dao -> dao.update(user));
        return user;
    }
}
