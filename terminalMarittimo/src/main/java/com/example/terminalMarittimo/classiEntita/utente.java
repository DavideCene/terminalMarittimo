package com.example.terminalMarittimo.classiEntita;

public class utente {
    private int ID;
    private String username;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public utente(int ID, String password, String username) {
        this.ID = ID;
        this.password = password;
        this.username = username;
    }
}
