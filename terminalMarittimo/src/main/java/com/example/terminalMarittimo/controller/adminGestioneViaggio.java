package com.example.terminalMarittimo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.nave;
import com.example.terminalMarittimo.classiEntita.porto;
import com.example.terminalMarittimo.classiEntita.viaggio;
import com.example.terminalMarittimo.modelli.naveDAO;
import com.example.terminalMarittimo.modelli.portoDAO;
import com.example.terminalMarittimo.modelli.viaggioDAO;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/gestioneViaggio")
public class adminGestioneViaggio {

    private final naveDAO nave = new naveDAO();
    private final portoDAO porto = new portoDAO();
     private final viaggioDAO viaggio = new viaggioDAO();

    @GetMapping("/listaNavi")
    public List<nave> trovaNavi() 
    {
        return nave.visualizza();
    }

    @GetMapping("/listaPorti")
    public List<porto> trovaPorti() 
    {
        return porto.visualizza();
    }

    @GetMapping("/inserisciViaggio")
    public String inserisciViaggio(@RequestParam int idNave, @RequestParam int idPortoP,@RequestParam int idPortoA, @RequestParam String dtPartenza,@RequestParam String dtArrivo) {
        viaggio.inserisci(dtArrivo,dtPartenza,idNave,idPortoA,idPortoP);
        return "OK";
    }

    @GetMapping("/listaViaggi")
    public ArrayList<viaggio> trovaTuttiViaggi() {
        return viaggio.visualizza();
    }

    @GetMapping("/eliminaViaggio")
    public String eliminaViaggio(@RequestParam int id) {
        viaggio.cancella(id);
        return "OK";
    }

}
