package com.example.terminalMarittimo.classiEntita;

public class polizza {
    private int ID;
    private viaggio viaggio;
    private double peso;
    private String data;
    private String merce;
    private cliente cliente;
    private fornitore fornitore;

    public fornitore getFornitore() {
        return fornitore;
    }
    public void setFornitore(fornitore fornitore) {
        this.fornitore = fornitore;
    }
    public polizza(int ID, cliente cliente, String data, String merce, double peso, viaggio viaggio, fornitore fornitore)
    {
        this.ID = ID;
        this.cliente = cliente;
        this.data = data;
        this.merce = merce;
        this.peso = peso;
        this.viaggio = viaggio;
        this.fornitore = fornitore;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public viaggio getViaggio() {
        return viaggio;
    }
    public void setViaggio(viaggio viaggio) {
        this.viaggio = viaggio;
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
    public String getMerce() {
        return merce;
    }
    public void setMerce(String merce) {
        this.merce = merce;
    }
    public cliente getCliente() {
        return cliente;
    }
    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }
}
