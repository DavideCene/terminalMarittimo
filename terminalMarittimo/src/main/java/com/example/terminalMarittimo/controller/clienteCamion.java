package com.example.terminalMarittimo.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.camion;
import com.example.terminalMarittimo.modelli.camionDAO;

@RestController
@RequestMapping("/gestioneCamion")
public class clienteCamion 
{

    camionDAO dao = new camionDAO();

    @GetMapping("/inserisci")
    public String inserisciCamion(@RequestParam String targa, @RequestParam String marca, @RequestParam String modello, @RequestParam String colore) {
        dao.inserisci(targa, modello);
        return "OK";
    }

    @GetMapping("/tutti")
    public ArrayList<camion> tuttiICamion() {
        return dao.visualizza();
    }

    @GetMapping("/elimina")
    public String eliminaCamion(@RequestParam String targa) {
        dao.cancella(targa);
        return "OK";
    }
}