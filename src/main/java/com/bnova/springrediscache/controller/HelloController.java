package com.bnova.springrediscache.controller;

import com.bnova.springrediscache.service.KeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private KeyValueService keyValueService;

    @GetMapping("getvalue")
    public String getValue(@RequestParam String key){
        return keyValueService.getValue(key);
    }
}
