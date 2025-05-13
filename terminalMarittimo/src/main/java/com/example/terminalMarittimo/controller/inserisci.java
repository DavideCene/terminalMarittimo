package com.example.terminalMarittimo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String inserisciFornitore(@RequestParam int ID, @RequestParam String nome, @RequestParam String cognome,@RequestParam String email, @RequestParam String telefono, @RequestParam String password) {
        fornitore.inserisci(ID, nome, cognome, email, telefono, password);
        return "Fornitore con ID " + ID + " inserito!";
    }

    naveDAO nave = new naveDAO();
    @GetMapping("/inserisci")
    public String inserisciNave(@RequestParam int ID, @RequestParam String tipologia, @RequestParam String nome) {
        nave.inserisci(ID, tipologia, nome);
        return "Nave con ID " + ID + " inserita!";
    }

    portoDAO porto = new portoDAO();
   @GetMapping("/inserisci")
    public String inserisciPorto(@RequestParam int ID, @RequestParam String nome,@RequestParam String rotta, @RequestParam String nazione) {
        porto.inserisci(ID, nome, rotta, nazione);
        return "Porto con ID " + ID + " inserito!";
    }

    utenteDAO utenteDAO = new utenteDAO();
    @GetMapping("/inserisci")
    public String inserisciUtente(@RequestParam int ID,@RequestParam String username,@RequestParam String password) {
        utenteDAO.inserisci(ID, username, password);
        return "Utente con ID " + ID + " inserito!";
    }

    ritiroDAO ritiro = new ritiroDAO();
    @GetMapping("/inserisci")
    public String inserisciRitiro(@RequestParam int ID,@RequestParam String targa,@RequestParam int autistaID,@RequestParam double peso,@RequestParam String data) {
        ritiro.inserisci(ID, targa, autistaID, peso, data);
        return "Ritiro con ID " + ID + " inserito!";
    }

    viaggioDAO viaggio = new viaggioDAO();
    @GetMapping("/inserisci")
    public String inserisciViaggio(@RequestParam int ID,@RequestParam String dataArrivo,@RequestParam String dataPartenza,@RequestParam int fornitoreID,@RequestParam int naveID,@RequestParam int portoArrivoID,@RequestParam int portoPartenzaID) {
        viaggio.inserisci(ID, dataArrivo, dataPartenza, fornitoreID, naveID, portoArrivoID, portoPartenzaID);
        return "Viaggio con ID " + ID + " inserito!";
    }
}
