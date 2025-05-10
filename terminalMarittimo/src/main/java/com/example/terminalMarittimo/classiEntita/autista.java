package com.example.terminalMarittimo.classiEntita;

public class autista {
    private int ID;
    private String nome;
    private String username;
    private String password;

    public autista(int ID, String nome, String password, String username) {
        this.ID = ID;
        this.nome = nome;
        this.password = password;
        this.username = username;
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
}
