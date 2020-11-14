package com.design.demo.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class StrateFactory {

    public static Map<String, Strategy> map = new HashMap<String, Strategy>();

    public static void setStrate(String key, Strategy strategy) {
        if (strategy == null || StringUtils.isEmpty(key)) {
            log.warn(key + " register is fail");
        }
        map.put(key, strategy);
    }

    public static Strategy getStrate(String key) {
        return map.get(key);
    }
}