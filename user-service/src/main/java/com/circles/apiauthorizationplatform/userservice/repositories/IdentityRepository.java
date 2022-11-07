package com.circles.apiauthorizationplatform.userservice.repositories;

import com.circles.apiauthorizationplatform.userservice.daos.IdentityDao;
import com.circles.apiauthorizationplatform.userservice.models.Identity;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class IdentityRepository {
    @Autowired
    private Jdbi jdbi;

    public Optional<Identity> getById(String id) {
        return Optional.ofNullable(jdbi.withExtension(IdentityDao.class, dao -> dao.getById(id)));
    }

    public Identity create(Identity identity) {
        if (StringUtils.isBlank(identity.getId())) {
            identity.setId(UUID.randomUUID().toString());
        }

        jdbi.withExtension(IdentityDao.class, dao -> dao.create(identity));
        return identity;
    }

    public Identity update(Identity identity) {
        jdbi.withExtension(IdentityDao.class, dao -> dao.update(identity));
        return identity;
    }
}
