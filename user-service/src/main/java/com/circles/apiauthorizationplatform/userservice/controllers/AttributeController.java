package com.circles.apiauthorizationplatform.userservice.controllers;

import com.circles.apiauthorizationplatform.userservice.models.Attribute;
import com.circles.apiauthorizationplatform.userservice.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/attributes")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    @GetMapping("/{id}")
    public Attribute getById(@PathVariable("id") String id) {
        return attributeService.getById(id);
    }

    @PostMapping
    public Attribute save(@RequestBody Attribute attribute) {
        return attributeService.save(attribute);
    }
}
