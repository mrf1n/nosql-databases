package com.github.mrf1n.database.controller;

import com.github.mrf1n.database.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cache/value")
public class RedisValueController {

    private final RedisService service;

    @GetMapping
    public Object getValue(@RequestParam("key") String key) {
        return service.get(key);
    }

    @PostMapping
    public void setValue(@RequestParam("key") String key, @RequestBody Object value) {
        service.set(key, value);
    }
}
