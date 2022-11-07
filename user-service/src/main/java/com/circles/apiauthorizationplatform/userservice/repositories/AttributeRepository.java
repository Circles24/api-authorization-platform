package com.circles.apiauthorizationplatform.userservice.repositories;

import com.circles.apiauthorizationplatform.userservice.daos.AttributeDao;
import com.circles.apiauthorizationplatform.userservice.models.Attribute;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class AttributeRepository {
    @Autowired
    private Jdbi jdbi;

    public Optional<Attribute> getById(String id) {
        return Optional.ofNullable(jdbi.withExtension(AttributeDao.class, dao -> dao.getById(id)));
    }

    public Attribute create(Attribute attribute) {
        if (StringUtils.isBlank(attribute.getId())) {
            attribute.setId(UUID.randomUUID().toString());
        }

        jdbi.withExtension(AttributeDao.class, dao -> dao.create(attribute));
        return attribute;
    }

    public Attribute update(Attribute attribute) {
        jdbi.withExtension(AttributeDao.class, dao -> dao.update(attribute));
        return attribute;
    }
}
