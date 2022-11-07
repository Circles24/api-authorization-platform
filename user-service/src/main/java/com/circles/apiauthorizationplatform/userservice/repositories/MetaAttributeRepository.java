package com.circles.apiauthorizationplatform.userservice.repositories;

import com.circles.apiauthorizationplatform.userservice.daos.MetaAttributeDao;
import com.circles.apiauthorizationplatform.userservice.models.MetaAttribute;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MetaAttributeRepository {
    @Autowired
    private Jdbi jdbi;

    public Optional<MetaAttribute> getById(String id) {
        return Optional.ofNullable(jdbi.withExtension(MetaAttributeDao.class, dao -> dao.getById(id)));
    }

    public MetaAttribute create(MetaAttribute metaAttribute) {
        if (StringUtils.isBlank(metaAttribute.getId())) {
            metaAttribute.setId(UUID.randomUUID().toString());
        }

        jdbi.withExtension(MetaAttributeDao.class, dao -> dao.create(metaAttribute));
        return metaAttribute;
    }

    public MetaAttribute update(MetaAttribute metaAttribute) {
        jdbi.withExtension(MetaAttributeDao.class, dao -> dao.update(metaAttribute));
        return metaAttribute;
    }
}
