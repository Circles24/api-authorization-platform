package com.circles.apiauthorizationplatform.userservice.models;

import com.circles.apiauthorizationplatform.userservice.constants.Gender;
import com.circles.apiauthorizationplatform.userservice.constants.UserStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.util.Objects;

@Data
public class User extends BaseEntity<User> {
    String id;
    String firstName;
    String lastName;
    Gender gender;
    Timestamp dateOfBirth;
    UserStatus status;

    public void merge(User user) {
        if (StringUtils.isNotBlank(user.firstName)) {
            this.firstName = user.firstName;
        }

        if (StringUtils.isNotBlank(user.lastName)) {
            this.lastName = user.lastName;
        }

        if (Objects.nonNull(user.gender)) {
            this.gender = user.gender;
        }

        if (Objects.nonNull(user.dateOfBirth)) {
            this.dateOfBirth = user.dateOfBirth;
        }

        if (Objects.nonNull(user.status)) {
            this.status = user.status;
        }
    }
}
