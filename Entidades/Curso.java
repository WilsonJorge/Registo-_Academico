
package Entidades;

import java.util.Objects;

public class Curso {
    
    private String codigo, nome, observacao;

    public Curso() {
    }

    public Curso(String codigo, String nome, String observacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.observacao = observacao;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso curso = (Curso) obj;
        if (!Objects.equals(this.codigo, curso.codigo)) {
            return false;
        }
        return Objects.equals(this.nome, curso.nome);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
