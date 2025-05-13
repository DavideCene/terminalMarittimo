package com.example.terminalMarittimo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.autista;
import com.example.terminalMarittimo.classiEntita.camion;
import com.example.terminalMarittimo.classiEntita.cliente;
import com.example.terminalMarittimo.classiEntita.fornitore;
import com.example.terminalMarittimo.modelli.autistaDAO;
import com.example.terminalMarittimo.modelli.camionDAO;
import com.example.terminalMarittimo.modelli.clienteDAO;
import com.example.terminalMarittimo.modelli.fornitoreDAO;

@RestController
@RequestMapping("/visualizza")

public class visualizza {

    autistaDAO autista = new autistaDAO();
    @GetMapping("/autista")
    public List<autista> visualizzaAutisti() {
        //lista autisti in json
        return autista.visualizza();  
    }

    camionDAO camion = new camionDAO();
    @GetMapping("/camion")
    public List<camion> visualizzaCamion()
    {
        return camion.visualizza();
    }

    clienteDAO cliente = new clienteDAO();
    @GetMapping("/visualizza")
    public List<cliente> visualizzaClienti() {
        return cliente.visualizza();
    }

    fornitoreDAO fornitore = new fornitoreDAO();
    @GetMapping("/visualizza")
    public List<fornitore> visualizzaFornitori() {
        return fornitore.visualizza();
    }
}
