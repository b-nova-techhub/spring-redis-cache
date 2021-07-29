package com.bnova.springrediscache.dao;

import com.bnova.springrediscache.service.KeyValueService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Repository
public class KeyValueDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(KeyValueDao.class);

    @SneakyThrows
    @Cacheable(value = "keyValueCache")
    public String getValue(String key){
        LOGGER.info("I am in " + this.getClass().getSimpleName());

        final Optional<String> first = Files.readAllLines(Path.of(this.getClass().getResource("/keyvalue.txt").toURI())).stream().filter(x -> StringUtils.startsWithIgnoreCase(x, key)).findFirst();
        return first.orElse("key " + key + " not found");
    }

    public String getValue2(String key){
        return getValue(key);
    }
    }
