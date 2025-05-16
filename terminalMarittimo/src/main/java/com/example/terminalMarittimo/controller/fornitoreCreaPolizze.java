package com.example.terminalMarittimo.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.polizza;
import com.example.terminalMarittimo.modelli.polizzaDAO;

@RestController
@RequestMapping("/gestionePolizze")
public class fornitoreCreaPolizze 
{
    private final polizzaDAO dao = new polizzaDAO();
    private String merce;

    @GetMapping("/inserisci")
    public String inserisci(@RequestParam int idViaggio, @RequestParam String data, @RequestParam int idCliente, @RequestParam float peso) {
        dao.inserisci(idCliente, data, merce, peso, idViaggio);
        return "OK";
    }

    @GetMapping("/tutte")
    public ArrayList<polizza> trovaTutte() {
        return dao.visualizza();
    }

    @GetMapping("/elimina")
    public String elimina(@RequestParam int id) {
        dao.cancella(id);
        return "OK";
    }
}