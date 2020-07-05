package za.co.sfh.features.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class SampleRequestController {

     @GetMapping("/test-get/{id}")
     public ResponseEntity<?> testGetMethod(@PathVariable("id") String id) {
          log.info("Received get request with id : {}", id);
          return new ResponseEntity<>("Success reading pathparam : " + id, HttpStatus.OK);
     }


}
