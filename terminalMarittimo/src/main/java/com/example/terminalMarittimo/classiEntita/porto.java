package com.example.terminalMarittimo.classiEntita;

public class porto {
    private int ID;
    private String nome;
    private String rotta;
    private String nazione;

    public porto(int ID, String nazione, String nome, String rotta) {
        this.ID = ID;
        this.nazione = nazione;
        this.nome = nome;
        this.rotta = rotta;
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
    public String getRotta() {
        return rotta;
    }
    public void setRotta(String rotta) {
        this.rotta = rotta;
    }
    public String getNazione() {
        return nazione;
    }
    public void setNazione(String nazione) {
        this.nazione = nazione;
    }
    
}
