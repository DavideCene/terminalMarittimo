package com.example.terminalMarittimo.classiEntita;

public class utente {
    private int ID;
    private String username;
    private String ruolo;

    public int getID() {
        return this.ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public utente(int ID,String username,String ruolo) {
        this.ID = ID;
        this.ruolo = ruolo;
        this.username = username;
    }
}
