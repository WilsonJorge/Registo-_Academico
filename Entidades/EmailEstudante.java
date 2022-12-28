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
public class EmailEstudante {
    private String codigo, email, tipo;

    public EmailEstudante(String codigo, String email, String tipo) {
        this.codigo = codigo;
        this.email = email;
        this.tipo = tipo;
    }
    public EmailEstudante( String email, String tipo) {
       
        this.email = email;
        this.tipo = tipo;
    }

    public EmailEstudante() {
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  email ;
    }
    
    
    
    
}
