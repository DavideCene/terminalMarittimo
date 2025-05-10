package com.example.terminalMarittimo.classiEntita;

public class cliente {
    private int ID;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private String password;
    private String indirizzo;

    public cliente(int ID, String cognome, String email, String indirizzo, String nome, String password, String telefono) {
        this.ID = ID;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;
        this.nome = nome;
        this.password = password;
        this.telefono = telefono;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


}
