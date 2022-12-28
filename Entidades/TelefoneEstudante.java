/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Salomao Valoi
 */
public class TelefoneEstudante {
    private String codigo,telefone,tipo;

    public TelefoneEstudante(String codigo, String telefone, String tipo) {
        this.codigo = codigo;
        this.telefone = telefone;
        this.tipo = tipo;
    }
    public TelefoneEstudante(String telefone, String tipo) {
   
        this.telefone = telefone;
        this.tipo = tipo;
    }
    public TelefoneEstudante() {
   
    }

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  telefone;
    }
    
}
