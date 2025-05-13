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
@RequestMapping("/elimina")
public class elimina {

    autistaDAO autista = new autistaDAO();
    @GetMapping("/autista")
    public String eliminaAutista(@RequestParam int id) {
        autista.cancella(id);
        return "Autista ID " + id + " eliminato!";
    }

    camionDAO camion = new camionDAO();
    @GetMapping("/camion")
    public String eliminaCamion(@RequestParam String targa) {
        camion.cancella(targa);
        return "Camion con targa " + targa + " eliminato!";
    }

    clienteDAO cliente = new clienteDAO();
    @GetMapping("/elimina")
    public String eliminaCliente(@RequestParam int ID) {
        cliente.cancella(ID);
        return "Cliente con ID " + ID + " eliminato!";
    }

    fornitoreDAO fornitore = new fornitoreDAO();
    @GetMapping("/elimina")
    public String eliminaFornitore(@RequestParam int ID) {
        fornitore.cancella(ID);
        return "Fornitore con ID " + ID + " eliminato!";
    }
}