package com.example.springboot1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    ArrayList<String> al = new ArrayList<>();
    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Attributes[] employee){
        for(Attributes i:employee){
            al.add(i.id);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Accepted");
    }
    @GetMapping("/employee/id")
    public ResponseEntity<Object> readEmployee(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(al);
    }
    @DeleteMapping("/employee/{i}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Object i){
        if(al.contains(i)){
            al.remove(i);
            return ResponseEntity.status(HttpStatus.FOUND).body(al);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(al);
    }
    @PutMapping("/employee/{update}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Object update){
        if(al.contains(update)){
            al.set(al.indexOf(update),"100abcd");
            return ResponseEntity.status(HttpStatus.FOUND).body(al);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(al);
    }
}
