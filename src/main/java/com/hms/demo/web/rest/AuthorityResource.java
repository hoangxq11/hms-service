package com.hms.demo.web.rest;

import com.hms.demo.service.AuthorityService;
import com.hms.demo.web.dto.request.AuthorityReq;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthorityResource {
    private final AuthorityService authorityService;

    @GetMapping
    public ResponseEntity<?> getRoles() {
        return ResponseUtils.ok(authorityService.getAuthorities());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody AuthorityReq authorityReq) {
        authorityService.createAuthority(authorityReq);
        return ResponseUtils.created();
    }

    @PutMapping("/update/{authorityId}")
    public ResponseEntity<?> updateRole(@RequestBody AuthorityReq authorityReq, @PathVariable Integer authorityId) {
        authorityService.updateAuthority(authorityId, authorityReq);
        return ResponseUtils.ok("Updated");
    }

    @DeleteMapping("/remove/{authorityId}")
    public ResponseEntity<?> removeRole(@PathVariable Integer authorityId) {
        authorityService.deleteAuthority(authorityId);
        return ResponseUtils.ok("Removed");
    }
}
