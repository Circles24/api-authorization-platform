package com.circles.apiauthorizationplatform.userservice.daos;

import com.circles.apiauthorizationplatform.userservice.models.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface UserDao {
    @SqlQuery("SELECT * FROM users WHERE id = :id")
    @RegisterBeanMapper(User.class)
    User getById(@Bind("id") String id);

    @SqlUpdate("INSERT INTO users (id, first_name, last_name, gender, date_of_birth, status, created_by, updated_by) VALUES (:user.id, :user.firstName, :user.lastName, :user.gender, :user.dateOfBirth, :user.status, :user.createdBy, :user.updatedBy)")
    int insert(@Bind("user") User user);

    @SqlUpdate("UPDATE users SET first_name = :user.firstName, last_name = :user.lastName, gender = :user.gender, date_of_birth = :user.date_of_birth, status = :user.status, created_by = :user.createdBy, updated_by = :user.updatedBy WHERE id = :user.id")
    int update(@BindBean User user);
}
