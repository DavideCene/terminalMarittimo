package com.example.terminalMarittimo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.modelli.autistaDAO;
import com.example.terminalMarittimo.modelli.camionDAO;
import com.example.terminalMarittimo.modelli.clienteDAO;
import com.example.terminalMarittimo.modelli.fornitoreDAO;

@RestController
@RequestMapping("/inserisci")

public class inserisci {

    autistaDAO autista = new autistaDAO(); 
    @GetMapping("/autista")
    public String inserisciAutista(@RequestParam String nome,@RequestParam String username,@RequestParam String password) {

        autista.inserisci(nome, username, password);
        return "Autista inserito!";
    }

    camionDAO camion = new camionDAO();
    @GetMapping("/camion")
    public String inserisciCamion(@RequestParam String targa, @RequestParam String modello) {
        camion.inserisci(targa, modello);
        return "Camion inserito!";
    }


    clienteDAO cliente = new clienteDAO();
    @GetMapping("/inserisci")
    public String inserisciCliente(@RequestParam int ID, @RequestParam String nome, @RequestParam String cognome,@RequestParam String email, @RequestParam String telefono,@RequestParam String password, @RequestParam String indirizzo) {
        cliente.inserisci(ID, nome, cognome, email, telefono, password, indirizzo);
        return "Cliente con ID " + ID + " inserito!";
    }

    fornitoreDAO fornitore = new fornitoreDAO();
    @GetMapping("/inserisci")
    public String inserisciFornitore(@RequestParam int ID, @RequestParam String nome, @RequestParam String cognome,
                                     @RequestParam String email, @RequestParam String telefono, @RequestParam String password) {
        fornitore.inserisci(ID, nome, cognome, email, telefono, password);
        return "Fornitore con ID " + ID + " inserito!";
    }
}
