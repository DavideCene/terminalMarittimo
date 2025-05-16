package com.example.terminalMarittimo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminalMarittimo.classiEntita.utente;
import com.example.terminalMarittimo.modelli.autistaDAO;
import com.example.terminalMarittimo.modelli.clienteDAO;
import com.example.terminalMarittimo.modelli.fornitoreDAO;
@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/login")
public class login 
{
    private final autistaDAO autista = new autistaDAO();
    private final clienteDAO cliente = new clienteDAO();
    private final fornitoreDAO fornitore = new fornitoreDAO();

    @GetMapping
    public utente doLogin(@RequestParam String username, @RequestParam String password) {
        int id = autista.getIDLogin(username, password);
        if (id != -1) {
            return new utente(id, username, "Autista");
        }
        id = cliente.getIDLogin(username, password);
        if (id != -1) {
            return new utente(id,  username, "Cliente");
        }
        id = fornitore.getIDLogin(username, password);
        if (id != -1) {
            return new utente(id,  username, "Fornitore");
        }

        return new utente(-1,"null","null");
    }
}