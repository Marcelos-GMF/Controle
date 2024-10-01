package com.mycompany.controleequipamentos;
public class Equipamento {
    private String modelo;
    private int patrimonio;
    private boolean status;
    
    
    //Método para Salvar
    public void salvar(){
   
    }
    //Método para deletar
    public void deletar(){
       
        
    }
    //Método para atualizar
    public void atualizar(){
        
    }
    
    
    //Construtor   

    public Equipamento(String modelo, int patrimonio, boolean status) {
        this.modelo = modelo;
        this.patrimonio = patrimonio;
        this.status = status;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
