package com.alura.forohub.forohub.controller;

import com.alura.forohub.forohub.dto.AuthRequestDTO;
import com.alura.forohub.forohub.dto.AuthResponseDTO;
import com.alura.forohub.forohub.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid AuthRequestDTO authRequestDTO) {
        AuthResponseDTO response = authService.authenticate(authRequestDTO);
        return ResponseEntity.ok(response);
    }
}
