package com.project.deepak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;


@Controller
public class EmailControllers {
    @Autowired
    emailService emailss;

    @GetMapping("/home")
    public String returnHome(){
        return "redirect:/index.html";
    }
    @PostMapping("/book-ticket")
    public ResponseEntity<?> bookTicket(@RequestBody BookingRequest request) {

        emailss.sendEmail("rockatulmohit@gmail.com", "New Booking Request", "Booking Details: " + request.toString());
        return ResponseEntity.ok(Collections.singletonMap("success", true));
    }
}
