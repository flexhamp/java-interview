package com.flexhamp.testcontainers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("permit-all")
    public ResponseEntity<?> permitAll() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping("denny-all")
    public ResponseEntity<?> denyAll() {
        return getOkResult();
    }

    @RequestMapping("anonymous")
    public ResponseEntity<?> anonymous() {
        return getOkResult();
    }

    @RequestMapping("authenticated")
    public ResponseEntity<?> authenticated() {
        return getOkResult();
    }

    @RequestMapping("rememberMe")
    public ResponseEntity<?> rememberMe() {
        return getOkResult();
    }

    @RequestMapping("fullyAuthenticated")
    public ResponseEntity<?> fullyAuthenticated() {
        return getOkResult();
    }

    @RequestMapping("has-view-authority")
    public ResponseEntity<?> hasViewAuthority() {
        return getOkResult();
    }

    @RequestMapping("has-update-or-delete-authority")
    public ResponseEntity<?> hasUpdateOrDeleteAuthority() {
        return getOkResult();
    }

    @RequestMapping("has-admin-role")
    public ResponseEntity<?> hasAdminRole() {
        return getOkResult();
    }

    @RequestMapping("has-customer-or-manager-role")
    public ResponseEntity<?> hasCustomerOrManagerRole() {
        return getOkResult();
    }

    @RequestMapping("has-access")
    public ResponseEntity<?> hasAccess() {
        return getOkResult();
    }

    private ResponseEntity<?> getOkResult() {
        return ResponseEntity.ok().build();
    }
}
