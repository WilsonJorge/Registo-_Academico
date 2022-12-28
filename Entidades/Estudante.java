package Entidades;

public class Estudante {

    private String codigo, apelido, nome, genero, estado_civi, data_nasc, num_bi,
            num_nuit, bairro, quarteirao, cod_prov_morada, cod_prov_naturalidade, nome_curso,cod_curso;
    private byte num_casa;
    private static int total;

    public Estudante() {
        total++;

    }

    public static int getTotal() {
        return total;
    }

    public String getCodCurso() {
        return cod_curso;
    }

    public void setCodCurso(String cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado_civi() {
        return estado_civi;
    }

    public void setEstado_civi(String estado_civi) {
        this.estado_civi = estado_civi;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getNum_bi() {
        return num_bi;
    }

    public void setNum_bi(String num_bi) {
        this.num_bi = num_bi;
    }

    public String getNum_nuit() {
        return num_nuit;
    }

    public void setNum_nuit(String num_nuit) {
        this.num_nuit = num_nuit;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(String quarteirao) {
        this.quarteirao = quarteirao;
    }

    public String getCod_prov_morada() {
        return cod_prov_morada;
    }

    public void setCod_prov_morada(String cod_prov_morada) {
        this.cod_prov_morada = cod_prov_morada;
    }

    public String getCod_prov_naturalidade() {
        return cod_prov_naturalidade;
    }

    public void setCod_prov_naturalidade(String cod_prov_naturalidade) {
        this.cod_prov_naturalidade = cod_prov_naturalidade;
    }

    public byte getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(byte num_casa) {
        this.num_casa = num_casa;
    }

    public String getNomeCurso() {
        return nome_curso;
    }

    public void setNomeCurso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

}
