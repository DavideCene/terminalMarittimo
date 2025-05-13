package com.example.terminalMarittimo.controller;

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

    naveDAO nave = new naveDAO();
    @GetMapping("/elimina")
    public String eliminaNave(@RequestParam int ID) {
        nave.cancella(ID);
        return "Nave con ID " + ID + " eliminata!";
    }

    portoDAO porto = new portoDAO();
    @GetMapping("/elimina")
    public String eliminaPorto(@RequestParam int ID) {
        porto.cancella(ID);
        return "Porto con ID " + ID + " eliminato!";
    }

    utenteDAO utenteDAO = new utenteDAO();
    @GetMapping("/elimina")
    public String eliminaUtente(@RequestParam int ID) {
        utenteDAO.cancella(ID);
        return "Utente con ID " + ID + " eliminato!";
    }

    ritiroDAO ritiro = new ritiroDAO();
    @GetMapping("/elimina")
    public String eliminaRitiro(@RequestParam int ID) {
        ritiro.cancella(ID);
        return "Ritiro con ID " + ID + " eliminato!";
    }

    viaggioDAO viaggio = new viaggioDAO();
    @GetMapping("/elimina")
    public String eliminaViaggio(@RequestParam int ID) {
        viaggio.cancella(ID);
        return "Viaggio con ID " + ID + " eliminato!";
    }

    polizzaDAO polizza = new polizzaDAO();
    @GetMapping("/elimina")
    public String eliminaPolizza(@RequestParam int ID) {
        polizza.cancella(ID);
        return "Polizza con ID " + ID + " eliminata!";
    }

    buonoDAO buono = new buonoDAO();
    @GetMapping("/elimina")
    public String eliminaBuono(@RequestParam int ID) {
        buono.cancella(ID);
        return "Buono con ID " + ID + " eliminato!";
    }
}