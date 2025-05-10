package com.example.terminalMarittimo.classiEntita;

public class nave {
    private int ID;
    private String tipologia;
    private String nome;

    public nave(int ID, String nome, String tipologia) {
        this.ID = ID;
        this.nome = nome;
        this.tipologia = tipologia;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getTipologia() {
        return tipologia;
    }
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
