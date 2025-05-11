package com.example.terminalMarittimo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.modelli.autistaDAO;

@RestController
@RequestMapping("/inserisci")

public class inserisci {
    autistaDAO DAO = new autistaDAO(); 

    @GetMapping("/autista")
    public String inserisciAutista(@RequestParam String nome,@RequestParam String username,@RequestParam String password) {

        DAO.inserisci(nome, username, password);
        return "Autista inserito!";
    }
}
