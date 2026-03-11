package com.example.demo.controller;

import com.example.demo.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public String sendNotification() {

        notificationService.sendNotification("Book updated!");

        return "Notification triggered";
    }
}