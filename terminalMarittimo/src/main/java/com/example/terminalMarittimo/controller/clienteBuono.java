package com.example.terminalMarittimo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.buono;
import com.example.terminalMarittimo.modelli.buonoDAO;

@RestController
@RequestMapping("/gestioneBuoni")
public class clienteBuono {

    private final buonoDAO dao = new buonoDAO();

    @GetMapping("/inserisci")
    public String inserisci(
            @RequestParam int idPolizza,
            @RequestParam String data,
            @RequestParam float peso) 
    {
        dao.inserisci(data, peso, idPolizza);
        return "OK";
    }

    @GetMapping("/tutti")
    public List<buono> trovaTutti() {
        return dao.visualizza();
    }

    @GetMapping("/elimina")
    public String elimina(@RequestParam int id) {
        dao.cancella(id);
        return "OK";
    }
}