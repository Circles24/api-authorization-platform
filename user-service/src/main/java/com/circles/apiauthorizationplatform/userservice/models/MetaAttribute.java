package com.circles.apiauthorizationplatform.userservice.models;

import com.circles.apiauthorizationplatform.userservice.constants.MetaAttributeStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Data
public class MetaAttribute extends BaseEntity<MetaAttribute> {
    String id;
    String name;
    String description;
    String schema;
    MetaAttributeStatus status;

    @Override
    public void merge(MetaAttribute entity) {
        if (StringUtils.isNotBlank(entity.name)) {
            this.name = entity.name;
        }

        if (StringUtils.isNotBlank(entity.description)) {
            this.description = entity.description;
        }

        if (StringUtils.isNotBlank(entity.schema)) {
            this.name = entity.name;
        }

        if (Objects.nonNull(entity.status)) {
            this.status = entity.status;
        }
    }
}
