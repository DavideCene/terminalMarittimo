package com.example.terminalMarittimo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.autista;
import com.example.terminalMarittimo.modelli.autistaDAO;

@RestController
@RequestMapping("/visualizza")

public class visualizza {

    autistaDAO DAO = new autistaDAO();

    @GetMapping("/autista")
    public List<autista> visualizzaAutisti() {
        //lista autisti in json
        return DAO.visualizza();  
    }
}
