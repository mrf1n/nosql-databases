package com.github.mrf1n.database.service;

public interface RedisService {

    Object get(String key);

    void set(String key, Object value);
}
