package com.bnova.springrediscache.service;

import com.bnova.springrediscache.dao.KeyValueDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyValueService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KeyValueService.class);

    @Autowired
    private KeyValueDao keyValueDao;

    public String getValue(String key){
        LOGGER.info("I am in " + this.getClass().getSimpleName());
        return keyValueDao.getValue(key);
    }
}
