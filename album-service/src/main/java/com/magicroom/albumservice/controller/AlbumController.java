package com.magicroom.albumservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {
    @GetMapping("/")
    private String test() {
        return "OK";
    }
}
