package dev.tttm.veterinerapp.api.controller;

import dev.tttm.veterinerapp.api.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class InfoRestController {

    @Autowired
    private Info info;

    @GetMapping(path = {"/", ""})
    public ResponseEntity<Info> getInfo(){
        return ResponseEntity.ok(info);
    }
}
