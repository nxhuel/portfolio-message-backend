package com.nxhu.portfolio_message_backend.controller;

import com.nxhu.portfolio_message_backend.dto.MessageRequest;
import com.nxhu.portfolio_message_backend.persistence.entity.MessageEntity;
import com.nxhu.portfolio_message_backend.service.MessageService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class MessageController
{
    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public ResponseEntity<?> saveMessage(@RequestBody MessageRequest messageRequest) {
        try {
            MessageEntity savedMessage = messageService.saveMessage(messageRequest.getMessage());
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        } catch (MessagingException e) {
            return ResponseEntity.internalServerError().body("Error al enviar el correo: " + e.getMessage());
        }
    }

    @GetMapping("/messages")
    public ResponseEntity<List<MessageEntity>> getMessages()
    {
        return new ResponseEntity<>(messageService.getMessages(), HttpStatus.OK);
    }
}
