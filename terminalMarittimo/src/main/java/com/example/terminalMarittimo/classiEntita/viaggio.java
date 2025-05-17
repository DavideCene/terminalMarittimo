package com.example.terminalMarittimo.classiEntita;

public class viaggio {
    private int ID;
    private porto portoPartenza;
    private porto portoArrivo;
    private String dataPartenza;
    private String dataArrivo;
    private nave nave;

    public viaggio(int ID, String dataArrivo, String dataPartenza, nave nave, porto portoArrivo, porto portoPartenza) {
        this.ID = ID;
        this.dataArrivo = dataArrivo;
        this.dataPartenza = dataPartenza;
        this.nave = nave;
        this.portoArrivo = portoArrivo;
        this.portoPartenza = portoPartenza;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public porto getPortoPartenza() {
        return portoPartenza;
    }
    public void setPortoPartenza(porto portoPartenza) {
        this.portoPartenza = portoPartenza;
    }
    public porto getPortoArrivo() {
        return portoArrivo;
    }
    public void setPortoArrivo(porto portoArrivo) {
        this.portoArrivo = portoArrivo;
    }
    public String getDataPartenza() {
        return dataPartenza;
    }
    public void setDataPartenza(String dataPartenza) {
        this.dataPartenza = dataPartenza;
    }
    public String getDataArrivo() {
        return dataArrivo;
    }
    public void setDataArrivo(String dataArrivo) {
        this.dataArrivo = dataArrivo;
    }
    public nave getNave() {
        return nave;
    }
    public void setNave(nave nave) {
        this.nave = nave;
    }
}
