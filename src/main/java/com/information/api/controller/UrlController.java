package com.information.api.controller;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "/images")
public class UrlController {

    @PostMapping(value = "/upload")
    @Order
    public Callable<ResponseEntity> upload(@RequestParam("pic") MultipartFile pic) {
        return () -> {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            Thread.yield();
            String originalFilename = pic.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

            if (!pic.isEmpty()) {
                if (pic.getContentType().startsWith("image/")) {

                    File file = new File(UUID.randomUUID().toString() + extension);

                    try {
                        pic.transferTo(file);
                        return new ResponseEntity<>(file.getName(), HttpStatus.CREATED);

                    } catch (IOException e) {
                        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
                    }

                } else {
                    return new ResponseEntity<>("Images expected, but not "
                            + pic.getContentType(), HttpStatus.RESET_CONTENT);
                }

            } else {
                return new ResponseEntity<>("Empty file", HttpStatus.NO_CONTENT);
            }
        };
    }
}
