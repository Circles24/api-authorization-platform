package com.circles.apiauthorizationplatform.userservice.services;

import com.circles.apiauthorizationplatform.userservice.errors.ErrorBuilder;
import com.circles.apiauthorizationplatform.userservice.models.Identity;
import com.circles.apiauthorizationplatform.userservice.repositories.IdentityRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityService {
    @Autowired
    private IdentityRepository repository;

    public Identity getById(String id) {
        return repository.getById(id).orElseThrow(ErrorBuilder.identity_not_found::build);
    }

    public Identity create(Identity identity) {
        return repository.create(identity);
    }

    public Identity update(Identity identity) {
        return repository.update(identity);
    }

    public Identity save(Identity identity) {
        if (StringUtils.isNotBlank(identity.getId())) {
            Optional<Identity> persistedIdentity = repository.getById(identity.getId());
            if (persistedIdentity.isPresent()) {
                persistedIdentity.get().merge(identity);
                return update(persistedIdentity.get());
            }
        }

        return create(identity);
    }
}
