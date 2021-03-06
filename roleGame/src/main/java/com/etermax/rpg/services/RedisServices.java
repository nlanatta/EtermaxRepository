package com.etermax.rpg.services;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServices {
	@Autowired
    private RedisTemplate< String, Object > template;

    public Object getValue(final String key) {
        return template.opsForValue().get(key);
    }

    public void setValue(final String key, final String value) {
        template.opsForValue().set(key, value);

        // set a expire for a message
        template.expire(key, 10000, TimeUnit.SECONDS);
    }
}
