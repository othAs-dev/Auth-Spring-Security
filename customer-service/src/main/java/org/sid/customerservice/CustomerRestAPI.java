package org.sid.customerservice;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;

@RestController
public class CustomerRestAPI {

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String, Object> customer(Authentication authentication) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", authentication.getName());
        map.put("email", "john@doe.fr");
        map.put("tel", "123456789");
        map.put("authorities", authentication.getAuthorities());

        return map;
    }
}
