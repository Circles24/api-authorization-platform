package com.circles.apiauthorizationplatform.userservice.services;

import com.circles.apiauthorizationplatform.userservice.errors.ErrorBuilder;
import com.circles.apiauthorizationplatform.userservice.models.MetaAttribute;
import com.circles.apiauthorizationplatform.userservice.repositories.MetaAttributeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MetaAttributeService {
    @Autowired
    private MetaAttributeRepository metaAttributeRepository;

    public MetaAttribute getById(String id) {
        return metaAttributeRepository.getById(id).orElseThrow(ErrorBuilder.meta_attribute_not_found::build);
    }

    public MetaAttribute create(MetaAttribute metaAttribute) {
        return metaAttributeRepository.create(metaAttribute);
    }

    public MetaAttribute update(MetaAttribute metaAttribute) {
        return metaAttributeRepository.update(metaAttribute);
    }

    public MetaAttribute save(MetaAttribute metaAttribute) {
        if (StringUtils.isNotBlank(metaAttribute.getId())) {
            Optional<MetaAttribute> persistedMetaAttribute = metaAttributeRepository.getById(metaAttribute.getId());
            if (persistedMetaAttribute.isPresent()) {
                persistedMetaAttribute.get().merge(metaAttribute);
                return update(persistedMetaAttribute.get());
            }
        }

        return create(metaAttribute);
    }
}
