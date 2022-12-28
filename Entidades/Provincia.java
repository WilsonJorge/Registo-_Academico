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
public class Provincia {
    
    private String codigo, nome, regioa;

    public Provincia(String codigo, String nome, String regioa) {
        this.codigo = codigo;
        this.nome = nome;
        this.regioa = regioa;
    }

    public Provincia() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegioa() {
        return regioa;
    }

    public void setRegioa(String regioa) {
        this.regioa = regioa;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
