package com.example.terminalMarittimo.classiEntita;

public class buono {
    private int ID;
    private String data;
    private polizza polizza;
    private double peso;

    public buono(int ID, String data, double peso, polizza polizza) {
        this.ID = ID;
        this.data = data;
        this.peso = peso;
        this.polizza = polizza;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public polizza getPolizza() {
        return polizza;
    }
    public void setPolizza(polizza polizza) {
        this.polizza = polizza;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
