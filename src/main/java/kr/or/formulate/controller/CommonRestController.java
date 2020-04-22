package kr.or.formulate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonRestController {

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/bad")
    public ResponseEntity<String> bad() {
        return new ResponseEntity<>("bad", HttpStatus.NOT_FOUND);
    }
}
