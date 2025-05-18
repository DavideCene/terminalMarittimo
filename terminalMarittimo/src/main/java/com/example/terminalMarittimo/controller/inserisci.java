package com.example.terminalMarittimo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.modelli.autistaDAO;
import com.example.terminalMarittimo.modelli.buonoDAO;
import com.example.terminalMarittimo.modelli.camionDAO;
import com.example.terminalMarittimo.modelli.clienteDAO;
import com.example.terminalMarittimo.modelli.fornitoreDAO;
import com.example.terminalMarittimo.modelli.naveDAO;
import com.example.terminalMarittimo.modelli.polizzaDAO;
import com.example.terminalMarittimo.modelli.portoDAO;
import com.example.terminalMarittimo.modelli.ritiroDAO;
import com.example.terminalMarittimo.modelli.utenteDAO;
import com.example.terminalMarittimo.modelli.viaggioDAO;
@CrossOrigin(origins = "http://localhost")
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
    @GetMapping("/cliente")
    public String inserisciCliente(@RequestParam String nome, @RequestParam String cognome,@RequestParam String mail, @RequestParam String tel,@RequestParam String password, @RequestParam String indirizzo) {
        cliente.inserisci(nome, cognome, mail, tel, password, indirizzo);
        return "Cliente inserito!";
    }

    fornitoreDAO fornitore = new fornitoreDAO();
    @GetMapping("/fornitore")
    public String inserisciFornitore(@RequestParam String nome, @RequestParam String cognome,@RequestParam String mail, @RequestParam String tel, @RequestParam String password) {
        fornitore.inserisci(nome, cognome, mail, tel, password);
        return "Fornitore inserito!";
    }

    naveDAO nave = new naveDAO();
    @GetMapping("/nave")
    public String inserisciNave(@RequestParam String tipo, @RequestParam String nome) {
        nave.inserisci(tipo, nome);
        return "Nave inserita!";
    }

    portoDAO porto = new portoDAO();
   @GetMapping("/porto")
    public String inserisciPorto(@RequestParam String nome,@RequestParam String rotta, @RequestParam String nazione) {
        porto.inserisci(nome, rotta, nazione);
        return "Porto inserito!";
    }

    utenteDAO utenteDAO = new utenteDAO();
    @GetMapping("/utente")
    public String inserisciUtente(@RequestParam String username,@RequestParam String password) {
        utenteDAO.inserisci(username, password);
        return "Utente con inserito!";
    }

    ritiroDAO ritiro = new ritiroDAO();
    @GetMapping("/ritiro")
    public String inserisciRitiro(@RequestParam String targa,@RequestParam int autista,@RequestParam double peso,@RequestParam String data) {
        ritiro.inserisci(targa, autista, peso, data);
        return "Ritiro inserito!";
    }

    viaggioDAO viaggio = new viaggioDAO();
    @GetMapping("/viaggio")
    public String inserisciViaggio(@RequestParam String dataArrivo,@RequestParam String dataPartenza,@RequestParam int naveID,@RequestParam int portoArrivoID,@RequestParam int portoPartenzaID) {
        viaggio.inserisci(dataArrivo, dataPartenza, naveID, portoArrivoID, portoPartenzaID);
        return "Viaggio inserito!";
    }

    polizzaDAO polizza = new polizzaDAO();
    @GetMapping("/polizza")
    public String inserisciPolizza(@RequestParam int clienteID,@RequestParam String data,@RequestParam String merce,@RequestParam double peso,@RequestParam int viaggioID,@RequestParam int fornitoreID) {
        polizza.inserisci(clienteID, data, merce, peso, viaggioID,fornitoreID);
        return "Polizza inserita!";
    }

    buonoDAO buono = new buonoDAO();
    @GetMapping("/buono")
    public String inserisciBuono(@RequestParam String data,@RequestParam double peso,@RequestParam int polizzaID) {
        buono.inserisci(data, peso, polizzaID);
        return "Buono con inserito!";
    }
}
