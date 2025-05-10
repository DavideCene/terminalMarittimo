package com.example.terminalMarittimo.classiEntita;

public class camion {
    private String targa;
    private String modello;

    public camion(String modello, String targa) {
        this.modello = modello;
        this.targa = targa;
    }
    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
}
