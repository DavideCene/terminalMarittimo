package com.example.terminalMarittimo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.modelli.autistaDAO;

@RestController
@RequestMapping("/elimina")
public class elimina {

    autistaDAO DAO = new autistaDAO();

    @GetMapping("/autista")
    public String eliminaAutista(@RequestParam int id) {
        DAO.cancella(id);
        return "Autista ID " + id + " eliminato!";
    }
}