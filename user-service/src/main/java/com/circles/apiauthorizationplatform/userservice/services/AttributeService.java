package com.circles.apiauthorizationplatform.userservice.services;

import com.circles.apiauthorizationplatform.userservice.errors.ErrorBuilder;
import com.circles.apiauthorizationplatform.userservice.models.Attribute;
import com.circles.apiauthorizationplatform.userservice.repositories.AttributeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttributeService {
    @Autowired
    private AttributeRepository attributeRepository;

    public Attribute getById(String id) {
        return attributeRepository.getById(id).orElseThrow(ErrorBuilder.attribute_not_found::build);
    }

    public Attribute create(Attribute attribute) {
        return attributeRepository.create(attribute);
    }

    public Attribute update(Attribute attribute) {
        return attributeRepository.update(attribute);
    }

    public Attribute save(Attribute attribute) {
        if (StringUtils.isNotBlank(attribute.getId())) {
            Optional<Attribute> persistedAttribute = attributeRepository.getById(attribute.getId());
            if (persistedAttribute.isPresent()) {
                persistedAttribute.get().merge(attribute);
                return attributeRepository.update(persistedAttribute.get());
            }
        }

        return attributeRepository.create(attribute);
    }
}
