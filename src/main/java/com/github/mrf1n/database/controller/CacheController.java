package com.github.mrf1n.database.controller;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class CacheController {

    @Resource(name="redisTemplate")
    private ListOperations<String, Object> listOps;

    @GetMapping("/{key}")
    public Object getValue(@PathVariable String key) {
        return listOps.getOperations().opsForValue().get(key);
    }

    @PostMapping("/{key}")
    public void setValue(@PathVariable String key, @RequestBody Object value) {
        listOps.getOperations().opsForValue().set(key, value);
    }
}
