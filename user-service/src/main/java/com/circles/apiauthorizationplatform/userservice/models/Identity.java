package com.circles.apiauthorizationplatform.userservice.models;

import com.circles.apiauthorizationplatform.userservice.constants.IdentityStatus;
import com.circles.apiauthorizationplatform.userservice.constants.IdentityType;
import lombok.Data;

import java.util.Objects;

@Data
public class Identity extends BaseEntity<Identity> {
    String id;
    IdentityType type;
    String value;
    String userId;
    IdentityStatus status;

    @Override
    public void merge(Identity entity) {
        if (Objects.nonNull(entity.status)) {
            this.status = entity.status;
        }
    }
}
