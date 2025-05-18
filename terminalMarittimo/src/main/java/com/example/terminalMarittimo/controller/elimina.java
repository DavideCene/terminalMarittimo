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
    @GetMapping("/cliente")
    public String eliminaCliente(@RequestParam int id) {
        cliente.cancella(id);
        return "Cliente con ID " + id + " eliminato!";
    }

    fornitoreDAO fornitore = new fornitoreDAO();
    @GetMapping("/fornitore")
    public String eliminaFornitore(@RequestParam int id) {
        fornitore.cancella(id);
        return "Fornitore con ID " + id + " eliminato!";
    }

    naveDAO nave = new naveDAO();
    @GetMapping("/nave")
    public String eliminaNave(@RequestParam int id) {
        nave.cancella(id);
        return "Nave con ID " + id + " eliminata!";
    }

    portoDAO porto = new portoDAO();
    @GetMapping("/porto")
    public String eliminaPorto(@RequestParam int id) {
        porto.cancella(id);
        return "Porto con ID " + id + " eliminato!";
    }

    utenteDAO utenteDAO = new utenteDAO();
    @GetMapping("/utente")
    public String eliminaUtente(@RequestParam int ID) {
        utenteDAO.cancella(ID);
        return "Utente con ID " + ID + " eliminato!";
    }

    ritiroDAO ritiro = new ritiroDAO();
    @GetMapping("/ritiro")
    public String eliminaRitiro(@RequestParam int id) {
        ritiro.cancella(id);
        return "Ritiro con ID " + id + " eliminato!";
    }

    viaggioDAO viaggio = new viaggioDAO();
    @GetMapping("/viaggio")
    public String eliminaViaggio(@RequestParam int ID) {
        viaggio.cancella(ID);
        return "Viaggio con ID " + ID + " eliminato!";
    }

    polizzaDAO polizza = new polizzaDAO();
    @GetMapping("/polizza")
    public String eliminaPolizza(@RequestParam int ID) {
        polizza.cancella(ID);
        return "Polizza con ID " + ID + " eliminata!";
    }

    buonoDAO buono = new buonoDAO();
    @GetMapping("/buono")
    public String eliminaBuono(@RequestParam int ID) {
        buono.cancella(ID);
        return "Buono con ID " + ID + " eliminato!";
    }
}