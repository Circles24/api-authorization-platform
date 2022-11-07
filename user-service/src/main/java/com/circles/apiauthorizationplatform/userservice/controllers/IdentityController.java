package com.circles.apiauthorizationplatform.userservice.controllers;

import com.circles.apiauthorizationplatform.userservice.models.Identity;
import com.circles.apiauthorizationplatform.userservice.services.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/identities")
public class IdentityController {
    @Autowired
    private IdentityService identityService;

    @GetMapping("/{id}")
    public Identity getById(@PathVariable("id") String id) {
        return identityService.getById(id);
    }

    @PostMapping
    public Identity save(@RequestBody Identity identity) {
        return identityService.save(identity);
    }
}
