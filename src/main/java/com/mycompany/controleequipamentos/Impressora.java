package com.mycompany.controleequipamentos;
public class Impressora extends Equipamento{
    private int serial;

    public Impressora(String modelo, int patrimonio, boolean status) {
        super(modelo, patrimonio, status);
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
    
    
}
