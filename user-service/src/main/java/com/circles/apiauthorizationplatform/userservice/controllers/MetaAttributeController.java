package com.circles.apiauthorizationplatform.userservice.controllers;

import com.circles.apiauthorizationplatform.userservice.models.MetaAttribute;
import com.circles.apiauthorizationplatform.userservice.services.MetaAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/meta-attributes")
public class MetaAttributeController {
    @Autowired
    private MetaAttributeService metaAttributeService;

    @GetMapping("/{id}")
    public MetaAttribute getById(@PathVariable("id") String id) {
        return metaAttributeService.getById(id);
    }

    @PostMapping
    public MetaAttribute save(@RequestBody MetaAttribute metaAttribute) {
        return metaAttributeService.save(metaAttribute);
    }
}
