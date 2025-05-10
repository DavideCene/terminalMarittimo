package com.example.terminalMarittimo.classiEntita;

public class ritiro {
    private int ID;
    private camion targa;
    private autista autista;
    private double peso;
    private String data;

    public ritiro(int ID, autista autista, String data, double peso, camion targa) {
        this.ID = ID;
        this.autista = autista;
        this.data = data;
        this.peso = peso;
        this.targa = targa;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public camion getTarga() {
        return targa;
    }
    public void setTarga(camion targa) {
        this.targa = targa;
    }
    public autista getAutista() {
        return autista;
    }
    public void setAutista(autista autista) {
        this.autista = autista;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

}
