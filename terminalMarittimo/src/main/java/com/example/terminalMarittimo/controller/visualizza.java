package com.example.terminalMarittimo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.autista;
import com.example.terminalMarittimo.classiEntita.camion;
import com.example.terminalMarittimo.classiEntita.cliente;
import com.example.terminalMarittimo.classiEntita.fornitore;
import com.example.terminalMarittimo.classiEntita.nave;
import com.example.terminalMarittimo.classiEntita.porto;
import com.example.terminalMarittimo.classiEntita.ritiro;
import com.example.terminalMarittimo.classiEntita.utente;
import com.example.terminalMarittimo.classiEntita.viaggio;
import com.example.terminalMarittimo.modelli.autistaDAO;
import com.example.terminalMarittimo.modelli.camionDAO;
import com.example.terminalMarittimo.modelli.clienteDAO;
import com.example.terminalMarittimo.modelli.fornitoreDAO;
import com.example.terminalMarittimo.modelli.naveDAO;
import com.example.terminalMarittimo.modelli.portoDAO;
import com.example.terminalMarittimo.modelli.ritiroDAO;
import com.example.terminalMarittimo.modelli.utenteDAO;
import com.example.terminalMarittimo.modelli.viaggioDAO;

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

    naveDAO nave = new naveDAO();
    @GetMapping("/visualizza")
    public List<nave> visualizzaNavi() {
        return nave.visualizza();
    }

    portoDAO porto = new portoDAO();
    @GetMapping("/visualizza")
    public List<porto> visualizzaPorti() {
        return porto.visualizza();
    }

    utenteDAO utenteDAO = new utenteDAO();
    @GetMapping("/visualizza")
    public List<utente> visualizzaUtenti() {
        return utenteDAO.visualizza();
    }

    ritiroDAO ritiro = new ritiroDAO();
    @GetMapping("/visualizza")
    public List<ritiro> visualizzaRitiri() {
        return ritiro.visualizza();
    }

    viaggioDAO viaggio = new viaggioDAO();
    @GetMapping("/visualizza")
    public List<viaggio> visualizzaViaggi() {
        return viaggio.visualizza();
    }
}
