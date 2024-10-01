package com.mycompany.controleequipamentos;
public class Smartphone extends Equipamento{
    private int imei;
    private float valor;

    public Smartphone(String modelo, int patrimonio, boolean status) {
        super(modelo, patrimonio, status);
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
    
}
