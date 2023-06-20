package com.github.mrf1n.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisTemplateService implements RedisService {

    private final RedisTemplate<String, Object> redisDefaultTemplate;
    @Override
    public Object get(String key) {
        return redisDefaultTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisDefaultTemplate.opsForValue().set(key, value);
    }

}
