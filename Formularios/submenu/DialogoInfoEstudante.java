/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.submenu;

import ConexaoBD.EmailEstudanteDAO;
import ConexaoBD.ProvinciaDAO;
import ConexaoBD.TelefoneEstudanteDAO;
import Entidades.*;
import ModeloTabelas.TabelaEmailEstudante;
import ModeloTabelas.TabelaTelefoneEstudante;
import componentes.Botao;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class DialogoInfoEstudante extends JDialog {

    
    public DialogoInfoEstudante( Estudante est) {
        inicializacao();
        this.setLocationRelativeTo(null);
        estudante=est;
        preencher();
    }
   
    private void preencher(){
       
        pnaturalidade=ProvinciaDAO.listaProvincias("2", estudante.getCod_prov_naturalidade()).get(0);
        pmorada=ProvinciaDAO.listaProvincias("2", estudante.getCod_prov_morada()).get(0);
        listatelefones=TelefoneEstudanteDAO.listaTelefones("3", estudante.getCodigo());
        listaemails=EmailEstudanteDAO.listaEmails("3", estudante.getCodigo());
        
        txt_apelido.setText(estudante.getApelido());
        txt_bairro.setText(estudante.getBairro());
        txt_bi.setText(estudante.getNum_bi());
        txt_codigo.setText(estudante.getCodigo());
        txt_curso.setText(estudante.getNomeCurso());
        txt_data_nasc.setText(estudante.getData_nasc());
        txt_estado_civil.setText(estudante.getEstado_civi());
        txt_genero.setText(estudante.getGenero());
        txt_naturalidade.setText(pnaturalidade.getNome());
        txt_nome.setText(estudante.getNome());
        txt_nuit.setText(estudante.getNum_nuit());
        txt_num_casa.setText(String.valueOf(estudante.getNum_casa()));
        txt_prov_morada.setText(pmorada.getNome());
        preencherTabelas();
        
    }
    
    
    private void preencherTabelas(){
        TabelaEmailEstudante model1=new TabelaEmailEstudante(listaemails) ;
        tbl_email.setModel(model1);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < model1.getColumnCount(); i++) {
            tbl_email.getColumnModel().getColumn(i).setCellRenderer(render);
        }
        
        TabelaTelefoneEstudante model2= new TabelaTelefoneEstudante(listatelefones);
        tbl_telefone.setModel(model2);
        for (int i = 0; i < model2.getColumnCount(); i++) {
            tbl_telefone.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }
    private void inicializacao() {
        this.setLayout(null);
        this.setSize(850, 610);
        this.setModalityType(ModalityType.APPLICATION_MODAL);

        font_lb = new Font("Century Gothic", Font.BOLD, 15);
        font_txt = new Font("Century Gothic", 1, 14);

        lb_cor_fon = new Color(29, 36, 98);
        txt_cor_font = new Color(29, 36, 98);

        pane_titulo = new JPanel(null);
        pane_titulo.setBackground(new Color(29, 36, 98));
        pane_titulo.setBounds(10, 10, 810, 40);
        this.add(pane_titulo);

        lb_titulo = new JLabel("Informacao do Estudante");
        lb_titulo.setBackground(new Color(255, 255, 255));
        lb_titulo.setFont(new Font("Century", Font.BOLD, 24));
        lb_titulo.setForeground(new Color(255, 255, 255));
        lb_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        lb_titulo.setBounds(7, 5, 800, 30);
        pane_titulo.add(lb_titulo);

        pane_conteudo = new JPanel(null);
        pane_conteudo.setBackground(new Color(255, 255, 255));
        pane_conteudo.setBorder(new LineBorder(new Color(29, 36, 98)));
        pane_conteudo.setBounds(10, 60, 810, 460);
        this.add(pane_conteudo);

        lb_codigo = new JLabel("Codigo");
        lb_codigo.setFont(font_lb);
        lb_codigo.setForeground(lb_cor_fon);
        lb_codigo.setBounds(10, 20, 60, 20);
        pane_conteudo.add(lb_codigo);

        txt_codigo = new JLabel();
        txt_codigo.setFont(font_txt);
        txt_codigo.setForeground(txt_cor_font);
        txt_codigo.setOpaque(true);
        txt_codigo.setBounds(90, 20, 300, 20);
        pane_conteudo.add(txt_codigo);

        lb_apelido = new JLabel();
        lb_apelido = new JLabel("Apelido");
        lb_apelido.setFont(font_lb);
        lb_apelido.setForeground(lb_cor_fon);
        lb_apelido.setBounds(10, 60, 60, 20);
        pane_conteudo.add(lb_apelido);

        txt_apelido = new JLabel();
        txt_apelido.setFont(font_txt);
        txt_apelido.setForeground(txt_cor_font);
        txt_apelido.setOpaque(true);
        txt_apelido.setBounds(90, 60, 300, 20);
        pane_conteudo.add(txt_apelido);

        lb_nome = new JLabel("Nome");
        lb_nome.setFont(font_lb);
        lb_nome.setForeground(new java.awt.Color(29, 36, 98));
        lb_nome.setBounds(10, 100, 60, 20);
        pane_conteudo.add(lb_nome);

        txt_nome = new JLabel();
        txt_nome.setFont(font_txt);
        txt_nome.setForeground(txt_cor_font);
        txt_nome.setOpaque(true);
        txt_nome.setBounds(90, 100, 300, 20);
        pane_conteudo.add(txt_nome);

        lb_data_nasc = new JLabel("Data de Nascimento");
        lb_data_nasc.setFont(font_lb);
        lb_data_nasc.setForeground(lb_cor_fon);
        lb_data_nasc.setBounds(10, 140, 170, 20);
        pane_conteudo.add(lb_data_nasc);

        txt_data_nasc = new JLabel();
        txt_data_nasc.setFont(font_txt);
        txt_data_nasc.setForeground(txt_cor_font);
        txt_data_nasc.setOpaque(true);
        txt_data_nasc.setBounds(180, 140, 210, 20);
        pane_conteudo.add(txt_data_nasc);

        lb_genero = new JLabel("Genero");
        lb_genero.setFont(font_txt);
        lb_genero.setForeground(lb_cor_fon);
        pane_conteudo.add(lb_genero);
        lb_genero.setBounds(10, 180, 70, 20);

        txt_genero = new JLabel();
        txt_genero.setFont(font_txt);
        txt_genero.setForeground(txt_cor_font);
        txt_genero.setOpaque(true);
        txt_genero.setBounds(90, 180, 300, 20);
        pane_conteudo.add(txt_genero);

        lb_estado_civil = new JLabel("Estado Civil");
        lb_estado_civil.setFont(font_lb);
        lb_estado_civil.setForeground(lb_cor_fon);
        lb_estado_civil.setBounds(10, 220, 100, 20);
        pane_conteudo.add(lb_estado_civil);

        txt_estado_civil = new JLabel();
        txt_estado_civil.setFont(font_txt);
        txt_estado_civil.setForeground(lb_cor_fon);
        txt_estado_civil.setOpaque(true);
        txt_estado_civil.setBounds(110, 220, 280, 20);
        pane_conteudo.add(txt_estado_civil);

        lb_bi = new JLabel("Numero do BI");
        lb_bi.setFont(font_lb);
        lb_bi.setForeground(lb_cor_fon);
        lb_bi.setBounds(10, 260, 100, 20);
        pane_conteudo.add(lb_bi);

        txt_bi = new JLabel();
        txt_bi.setFont(font_lb);
        txt_bi.setForeground(lb_cor_fon);
        txt_bi.setOpaque(true);
        txt_bi.setBounds(130, 260, 260, 20);
        pane_conteudo.add(txt_bi);

        txt_nuit = new JLabel();
        txt_nuit.setFont(font_lb);
        txt_nuit.setForeground(lb_cor_fon);
        txt_nuit.setOpaque(true);
        txt_nuit.setBounds(90, 300, 300, 20);
        pane_conteudo.add(txt_nuit);

        pane_contactos = new JPanel(null);
        pane_contactos.setBackground(new Color(255, 255, 255));
        pane_contactos.setBorder(new LineBorder(new Color(29, 36, 98)));
        pane_contactos.setBounds(400, 20, 400, 310);
        pane_conteudo.add(pane_contactos);

        lb_titulo_contactos = new JLabel("Contactos");
        lb_titulo_contactos.setBackground(new Color(253, 131, 0));
        lb_titulo_contactos.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lb_titulo_contactos.setForeground(new java.awt.Color(255, 255, 255));
        lb_titulo_contactos.setHorizontalAlignment(SwingConstants.CENTER);
        lb_titulo_contactos.setOpaque(true);
        lb_titulo_contactos.setBounds(4, 4, 390, 20);
        pane_contactos.add(lb_titulo_contactos);

        tbl_email = new JTable();
        tbl_email.setFont(new Font("Century Gothic", 1, 13));
        tbl_email.setForeground(new Color(29, 36, 98));
        tbl_email.setGridColor(new Color(0, 122, 204));

        
        lb_telefone= new JLabel("Telefones");
        lb_telefone.setFont(font_lb);
        lb_telefone.setForeground(lb_cor_fon);
        lb_telefone.setBounds(10, 30, 80, 20);
        pane_contactos.add(lb_telefone);
        
        pane_tbl_cell = new JScrollPane();
        pane_tbl_cell.setViewportView(tbl_email);
        pane_tbl_cell.setBounds(10, 50, 380, 110);
        pane_contactos.add(pane_tbl_cell);

        tbl_telefone = new JTable();
        tbl_telefone.setFont(new Font("Century Gothic", 1, 13));
        tbl_telefone.setForeground(new Color(29, 36, 98));
        tbl_telefone.setGridColor(new Color(75, 130, 181));
        tbl_telefone.getTableHeader().setFont(new Font("Centuary Gothic", Font.BOLD, 15));
        tbl_telefone.getTableHeader().setBackground(new Color(160, 196, 229));
        tbl_telefone.getTableHeader().setForeground(new Color(29, 36, 98));
        tbl_telefone.setRowHeight(25);
        pane_tbl_cell.setViewportView(tbl_telefone);

        lb_email = new JLabel("Email");
        lb_email.setFont(font_lb);
        lb_email.setForeground(lb_cor_fon);
        lb_email.setBounds(10, 170, 80, 20);
        pane_contactos.add(lb_email);
        
        pane_tbl_email= new JScrollPane();
        pane_tbl_email.setBackground(new Color(255,255,255));
        pane_tbl_email.setBounds(10, 190, 380, 110);
        pane_contactos.add(pane_tbl_email);
        
        tbl_email= new JTable();
        tbl_email.setFont(new Font("Century Gothic", Font.BOLD, 13));
        tbl_email.setGridColor(new Color(0, 122, 204));
        tbl_email.getTableHeader().setFont(new Font("Centuary Gothic", Font.BOLD, 15));
        tbl_email.getTableHeader().setBackground(new Color(160, 196, 229));
        tbl_email.getTableHeader().setForeground(new Color(29, 36, 98));
        tbl_email.setRowHeight(25);
        pane_tbl_email.setViewportView(tbl_email);
        
        lb_nuit = new JLabel("NUIT");
        lb_nuit.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lb_nuit.setForeground(new Color(29, 36, 98));
        lb_nuit.setBounds(10, 300, 60, 20);
        pane_conteudo.add(lb_nuit);

        txt_nuit = new JLabel();
        txt_nuit.setFont(font_txt);
        txt_nuit.setForeground(txt_cor_font);
        txt_nuit.setOpaque(true);
        txt_nuit.setBounds(90, 300, 300, 20);
        pane_conteudo.add(txt_nuit);

        lb_naturalidade = new JLabel("Naturalidade");
        lb_naturalidade.setFont(font_lb);
        lb_naturalidade.setForeground(new Color(29, 36, 98));
        lb_naturalidade.setBounds(10, 340, 110, 20);
        pane_conteudo.add(lb_naturalidade);

        txt_naturalidade = new JLabel();
        txt_naturalidade.setFont(font_txt);
        txt_naturalidade.setForeground(txt_cor_font);
        txt_naturalidade.setOpaque(true);
        txt_naturalidade.setBounds(130, 340, 260, 20);
        pane_conteudo.add(txt_naturalidade);

        lb_curso = new JLabel("Curso");
        lb_curso.setFont(font_lb);
        lb_curso.setForeground(lb_cor_fon);
        lb_curso.setBounds(10, 380, 50, 20);
        pane_conteudo.add(lb_curso);

        txt_curso = new JLabel();
        txt_curso.setFont(font_txt);
        txt_curso.setForeground(txt_cor_font);
        txt_curso.setOpaque(true);
        txt_curso.setBounds(70, 380, 320, 20);
        pane_conteudo.add(txt_curso);

        lb_cidade = new JLabel("Provincia Morada");
        lb_cidade.setFont(font_lb);
        lb_cidade.setForeground(lb_cor_fon);
        lb_cidade.setBounds(400, 340, 140, 20);
        pane_conteudo.add(lb_cidade);

        txt_prov_morada = new JLabel();
        txt_prov_morada.setFont(font_txt);
        txt_prov_morada.setForeground(txt_cor_font);
        txt_prov_morada.setOpaque(true);
        txt_prov_morada.setBounds(550, 340, 230, 20);
        pane_conteudo.add(txt_prov_morada);

        lb_bairro = new JLabel("Bairro");
        lb_bairro.setFont(font_lb);
        lb_bairro.setForeground(lb_cor_fon);
        pane_conteudo.add(lb_bairro);
        lb_bairro.setBounds(400, 380, 60, 20);

        txt_bairro = new JLabel();
        txt_bairro.setFont(font_txt);
        txt_bairro.setForeground(txt_cor_font);
        txt_bairro.setOpaque(true);
        txt_bairro.setBounds(450, 380, 330, 20);
        pane_conteudo.add(txt_bairro);

        lb_quarteirao = new JLabel("Quarteirao");
        lb_quarteirao.setFont(font_lb);
        lb_quarteirao.setForeground(lb_cor_fon);
        lb_quarteirao.setBounds(400, 420, 90, 20);
        pane_conteudo.add(lb_quarteirao);

        txt_quarteirao = new JLabel();
        txt_quarteirao.setFont(font_txt);
        txt_quarteirao.setForeground(txt_cor_font);
        txt_quarteirao.setOpaque(true);
        txt_quarteirao.setBounds(490, 420, 90, 20);
        pane_conteudo.add(txt_quarteirao);

        lb_num_casa = new JLabel("Num. Casa");
        lb_num_casa.setFont(font_lb);
        lb_num_casa.setForeground(lb_cor_fon);
        lb_num_casa.setBounds(600, 420, 90, 20);
        pane_conteudo.add(lb_num_casa);

        txt_num_casa = new JLabel();
        txt_num_casa.setFont(font_txt);
        txt_num_casa.setForeground(txt_cor_font);
        txt_num_casa.setOpaque(true);
        txt_num_casa.setBounds(690, 420, 90, 20);
        pane_conteudo.add(txt_num_casa);

        lb_turma = new JLabel("Turma");
        lb_turma.setFont(font_lb);
        lb_turma.setForeground(lb_cor_fon);
        lb_turma.setBounds(10, 420, 60, 20);
        pane_conteudo.add(lb_turma);

        txt_turma = new JLabel();
        txt_turma.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txt_turma.setForeground(new java.awt.Color(29, 36, 98));
        txt_turma.setOpaque(true);
        pane_conteudo.add(txt_turma);
        txt_turma.setBounds(90, 420, 300, 20);

        btn_imprimir = new Botao("Imprimir");
        btn_imprimir.setBackground(new Color(0, 128, 0));
        btn_imprimir.setForeground(new Color(255, 255, 255));
        btn_imprimir.setFont(new Font("Ebrima", 1, 14));
        btn_imprimir.setBounds(490, 530, 160, 30);
        this.add(btn_imprimir);

        btn_fechar = new Botao("Fechar");
        btn_fechar.setBackground(new Color(255, 0, 0));
        btn_fechar.setForeground(new Color(255, 255, 255));
        btn_fechar.setBackgroundMouseEntered(new Color(255, 24, 24));
        btn_fechar.setFont(new java.awt.Font("Ebrima", 1, 14));
        btn_fechar.setBounds(660, 530, 160, 30);
        this.add(btn_fechar);

    }

    private JPanel pane_titulo, pane_conteudo, pane_contactos;

    private JLabel lb_titulo, lb_nome, lb_apelido, lb_data_nasc, lb_bairro, lb_num_casa, lb_quarteirao,
            lb_email, lb_genero, lb_estado_civil, lb_bi, lb_nuit, lb_naturalidade, lb_codigo,
            lb_turma,  lb_curso,  lb_cidade, lb_telefone, lb_titulo_contactos;

    private JLabel txt_nome, txt_apelido, txt_bairro, txt_data_nasc, txt_codigo, txt_estado_civil, txt_turma,
            txt_num_casa, txt_nuit,  txt_quarteirao, txt_naturalidade,
            txt_prov_morada, txt_curso, txt_bi, txt_genero;

    private Font font_lb, font_txt;
    private Color lb_cor_fon, txt_cor_font;
    private Botao btn_imprimir, btn_fechar;
    private JScrollPane pane_tbl_cell, pane_tbl_email;
    private JTable tbl_telefone, tbl_email;
    private Estudante estudante;
    private List<Provincia> provincias;
    private List<TelefoneEstudante> listatelefones;
    private List<EmailEstudante> listaemails;
    private Provincia pmorada,pnaturalidade;
}
