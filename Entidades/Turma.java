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
public class Turma {
    
    private String codigo, designcao, cod_curso, nome_curso,ano;

    public Turma(String codigo, String designcao,String ano, String cod_curso) {
        this.codigo = codigo;
        this.designcao = designcao;
        this.cod_curso = cod_curso;
        this.ano=ano;
    }

    public Turma() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesigncao() {
        return designcao;
    }

    public void setDesigncao(String designcao) {
        this.designcao = designcao;
    }

    public String getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    

    @Override
    public String toString() {
        return codigo ;
    }
    
    
    
}
