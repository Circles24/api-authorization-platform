package com.circles.apiauthorizationplatform.userservice.models;

import com.circles.apiauthorizationplatform.userservice.constants.AttributeStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Data
public class Attribute extends BaseEntity<Attribute> {
    String id;
    String userId;
    String metaAttributeId;
    String value;
    AttributeStatus status;

    @Override
    public void merge(Attribute entity) {
        if (StringUtils.isNotBlank(entity.value)) {
            this.value = entity.value;
        }

        if (Objects.nonNull(entity.status)) {
            this.status = entity.status;
        }
    }
}
