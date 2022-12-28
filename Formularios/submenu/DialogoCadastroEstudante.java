/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.submenu;

import ConexaoBD.CursoDAO;
import ConexaoBD.EstudanteDAO;
import ConexaoBD.ProvinciaDAO;
import Entidades.*;
import componentes.Botao;
import componentes.CampoTexto;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Salomao Valoi
 */
public class DialogoCadastroEstudante extends JDialog {

    public DialogoCadastroEstudante() {
        inicializacao();
        this.setLocationRelativeTo(null);
        provincias = ProvinciaDAO.listaProvincias("1", "0");
        cursos = CursoDAO.listaCursos("1", "");
        preencherComboBox();

    }
    public DialogoCadastroEstudante(TelaEstudante p) {
        inicializacao();
        this.setLocationRelativeTo(null);
        provincias = ProvinciaDAO.listaProvincias("1", "0");
        cursos = CursoDAO.listaCursos("1", "");
        preencherComboBox();
        pane=p;

    }

    public void preencherComboBox() {
        cb_provincias.removeAllItems();
        cb_provincias_morrada.removeAllItems();
        cb_cursos.removeAllItems();
        for (Provincia p : provincias) {
            cb_provincias.addItem(p);
            cb_provincias_morrada.addItem(p);
        }
        for (Curso c : cursos) {
            cb_cursos.addItem(c);
        }

    }

    public void cadastrar() {
        try{
        if (valido()) {
            
            estudante = new Estudante();
            estudante.setApelido(txt_apelido.getText().trim());
            estudante.setNome(txt_nome.getText().trim());
            estudante.setBairro(txt_bairro.getText().trim());
            provincia=(Provincia)cb_provincias_morrada.getSelectedItem();
            estudante.setCod_prov_morada(provincia.getCodigo());
            provincia=(Provincia)cb_provincias.getSelectedItem();
            estudante.setCod_prov_naturalidade(provincia.getCodigo());
            estudante.setData_nasc(txt_data_nasc.getText().trim());
            estudante.setEstado_civi(cb_estado_civil.getSelectedItem().toString());
            estudante.setGenero(btn_grupo.getSelection().getActionCommand());
            curso=(Curso)cb_cursos.getSelectedItem();
            estudante.setNomeCurso(curso.getNome());
            estudante.setCodCurso(curso.getCodigo());
            estudante.setNum_bi(txt_num_bi.getText().trim());
            estudante.setNum_casa(Byte.parseByte(txt_num_casa.getText().trim()));
            estudante.setNum_nuit(txt_num_nuit.getText().trim());
            estudante.setQuarteirao(txt_quarteirao.getText().trim());
            estudante.setCodigo(curso.getCodigo()+gerar+(Estudante.getTotal()+1));
            if(EstudanteDAO.inserirOuActualizar(estudante, "1", "")){
                JOptionPane.showMessageDialog(this, "Estudante cadastrado com sucesso");
                pane.modelo().actualizar(estudante);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this, "ERRO!!!\nPreencha correctamente os campos obrigatorios");
        }
        }
        catch(NumberFormatException x){
            JOptionPane.showMessageDialog(this, "ERRO!!!\nPreencha correctamente o camo numero da casa");
            
        }
        catch(ClassCastException x){
            JOptionPane.showMessageDialog(this, x);
        }
        catch(NullPointerException x){
          JOptionPane.showMessageDialog(this, x);  
        }
        catch(Exception x){
            JOptionPane.showMessageDialog(this, x);
            
        }
    }

    private boolean valido() {
        return !txt_apelido.getText().equals("") & !txt_nome.getText().equals("") & !txt_data_nasc.getText().equals("")
                & !txt_num_bi.getText().equals("") & !txt_num_nuit.getText().equals("")
                & cb_estado_civil.getSelectedIndex() > 0;
    }
    
    private void eventosbotoes(){
        btn_cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            cadastrar();
            }
        });
    }

    public void inicializacao() {
        this.setLayout(null);
        this.setSize(845, 620);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        
        calendario =GregorianCalendar.getInstance();
        int mes=calendario.get(Calendar.MONTH)+1;
        String mess=mes>9?String.valueOf(mes):"0"+mes;
        gerar=String.valueOf(calendario.get(Calendar.YEAR))+mess;
        System.out.println(mess);
        font_lbs = new Font("Century Gothic", Font.BOLD, 13);
        font_lb_titulos = new Font("Century Gothic", Font.BOLD, 18);
        cor_font_lbs = new Color(29, 36, 98);

        pane_titulo = new JPanel(null);
        pane_titulo.setBounds(5, 5, 820, 35);
        pane_titulo.setBackground(new Color(29, 36, 98));

        lb_titulo = new JLabel("Cadastro de Estudantes");
        lb_titulo.setForeground(new Color(255, 255, 255));
        lb_titulo.setFont(new Font("Century Schoolbook", Font.BOLD, 25));
        lb_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        lb_titulo.setBounds(5, 5, 815, 25);
        pane_titulo.add(lb_titulo);
        this.add(pane_titulo);

        pane_dados = new JPanel(null);
        pane_dados.setBounds(10, 45, 810, 530);
        pane_dados.setBackground(new Color(255, 255, 255));
        pane_dados.setBorder(new LineBorder(new Color(29, 36, 98), 1));
        this.add(pane_dados);

        pane_dados_pessoais = new JPanel(null);
        pane_dados_pessoais.setBackground(new Color(255, 255, 255));
        pane_dados_pessoais.setBounds(10, 10, 390, 470);
        pane_dados_pessoais.setBorder(new LineBorder(cor_font_lbs, 1));
        pane_dados.add(pane_dados_pessoais);

        lb_dados_pessoasis = new JLabel("Dados Pessoais");
        lb_dados_pessoasis.setOpaque(true);
        lb_dados_pessoasis.setBounds(5, 5, pane_dados_pessoais.getWidth() - 10, 30);
        lb_dados_pessoasis.setBackground(new Color(253, 131, 0));
        lb_dados_pessoasis.setHorizontalAlignment(SwingConstants.CENTER);
        lb_dados_pessoasis.setForeground(new Color(255, 255, 255));
        lb_dados_pessoasis.setFont(font_lb_titulos);
        pane_dados_pessoais.add(lb_dados_pessoasis);

        lb_apelido = new JLabel("Apelido");
        lb_apelido.setFont(font_lbs);
        lb_apelido.setForeground(cor_font_lbs);
        lb_apelido.setBounds(30, 40, 300, 25);
        pane_dados_pessoais.add(lb_apelido);

        txt_apelido = new CampoTexto();
        txt_apelido.setTextoFundo("Digite o apelido");
        txt_apelido.setFont(font_lbs);
        txt_apelido.setForeground(cor_font_lbs);
        txt_apelido.setBounds(20, 65, 350, 25);
        pane_dados_pessoais.add(txt_apelido);

        lb_nome = new JLabel("Nome");
        lb_nome.setFont(font_lbs);
        lb_nome.setForeground(cor_font_lbs);
        lb_nome.setBounds(30, 90, 300, 25);
        pane_dados_pessoais.add(lb_nome);

        txt_nome = new CampoTexto();
        txt_nome.setTextoFundo("Digite o nome aqui (sem incluir o apelido)");
        txt_nome.setFont(font_lbs);
        txt_nome.setForeground(cor_font_lbs);
        txt_nome.setBounds(20, 115, 350, 25);
        pane_dados_pessoais.add(txt_nome);

        lb_data_nasc = new JLabel("Data de Nascimento");
        lb_data_nasc.setFont(font_lbs);
        lb_data_nasc.setForeground(cor_font_lbs);
        lb_data_nasc.setBounds(30, 140, 300, 25);
        pane_dados_pessoais.add(lb_data_nasc);

        txt_data_nasc = new CampoTexto();
        txt_data_nasc.setTextoFundo("Digite a data no formato DD/MM/AAAA");
        txt_data_nasc.setFont(font_lbs);
        txt_data_nasc.setForeground(cor_font_lbs);
        txt_data_nasc.setBounds(20, 165, 350, 25);
        pane_dados_pessoais.add(txt_data_nasc);

        lb_sexo = new JLabel("Genero");
        lb_sexo.setFont(font_lbs);
        lb_sexo.setForeground(cor_font_lbs);
        lb_sexo.setBounds(30, 190, 300, 25);
        pane_dados_pessoais.add(lb_sexo);

        pane_genero = new JPanel(null);
        pane_genero.setBackground(new Color(255, 255, 255));
        pane_genero.setBounds(20, 215, 350, 30);
        pane_genero.setBorder(new LineBorder(cor_font_lbs, 1));
        pane_dados_pessoais.add(pane_genero);

        btn_masc = new JRadioButton("Masculino");
        btn_masc.setBackground(new Color(255, 255, 255));
        btn_masc.setActionCommand("M");
        btn_masc.setForeground(cor_font_lbs);
        btn_masc.setFont(font_lbs);
        btn_masc.setBounds(10, (pane_genero.getHeight() - 20) / 2, 150, 20);
        btn_masc.setFocusPainted(false);
        btn_masc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pane_genero.add(btn_masc);

        btn_fem = new JRadioButton("Femenino");
        btn_fem.setBackground(new Color(255, 255, 255));
        btn_fem.setActionCommand("M");
        btn_fem.setForeground(cor_font_lbs);
        btn_fem.setFont(font_lbs);
        btn_fem.setBounds(160, (pane_genero.getHeight() - 20) / 2, 150, 20);
        btn_fem.setFocusPainted(false);
        btn_fem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pane_genero.add(btn_fem);

        lb_estado = new JLabel("Estado Civil");
        lb_estado.setFont(font_lbs);
        lb_estado.setForeground(cor_font_lbs);
        lb_estado.setBounds(30, 245, 300, 25);
        pane_dados_pessoais.add(lb_estado);

        cb_estado_civil = new JComboBox<>();
        cb_estado_civil.setBackground(new Color(255, 255, 255));
        cb_estado_civil.setFont(font_lbs);
        cb_estado_civil.setForeground(cor_font_lbs);
        cb_estado_civil.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        cb_estado_civil.setBounds(20, 270, 350, 25);
        cb_estado_civil.setModel(new DefaultComboBoxModel<>(new String[]{"Selecione", "Solteiro(a)", "Casado(a)", "Viuvo(a)"}));
        pane_dados_pessoais.add(cb_estado_civil);

        lb_bi = new JLabel("Numero do BI");
        lb_bi.setFont(font_lbs);
        lb_bi.setForeground(cor_font_lbs);
        lb_bi.setBounds(30, 295, 300, 25);
        pane_dados_pessoais.add(lb_bi);

        txt_num_bi = new CampoTexto();
        txt_num_bi.setTextoFundo("Digite o numero do BI");
        txt_num_bi.setFont(font_lbs);
        txt_num_bi.setForeground(cor_font_lbs);
        txt_num_bi.setBounds(20, 320, 350, 25);
        pane_dados_pessoais.add(txt_num_bi);

        lb_nuit = new JLabel("NUI");
        lb_nuit.setFont(font_lbs);
        lb_nuit.setForeground(cor_font_lbs);
        lb_nuit.setBounds(30, 345, 300, 25);
        pane_dados_pessoais.add(lb_nuit);

        txt_num_nuit = new CampoTexto();
        txt_num_nuit.setTextoFundo("Digite o NUI");
        txt_num_nuit.setFont(font_lbs);
        txt_num_nuit.setForeground(cor_font_lbs);
        txt_num_nuit.setBounds(20, 370, 350, 25);
        pane_dados_pessoais.add(txt_num_nuit);

        lb_naturalidade = new JLabel("Naturalidade");
        lb_naturalidade.setFont(font_lbs);
        lb_naturalidade.setForeground(cor_font_lbs);
        lb_naturalidade.setBounds(30, 395, 300, 25);
        pane_dados_pessoais.add(lb_naturalidade);

        cb_provincias = new JComboBox<>();
        cb_provincias.setBackground(new Color(255, 255, 255));
        cb_provincias.setFont(font_lbs);
        cb_provincias.setForeground(cor_font_lbs);
        cb_provincias.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        cb_provincias.setBounds(20, 420, 350, 25);
        pane_dados_pessoais.add(cb_provincias);

        pane_morada = new JPanel(null);
        pane_morada.setBackground(new Color(255, 255, 255));
        pane_morada.setBounds(410, 10, 390, 200);
        pane_morada.setBorder(new LineBorder(cor_font_lbs, 1));
        pane_dados.add(pane_morada);

        lb_titulo_morada = new JLabel("Morada");
        lb_titulo_morada.setOpaque(true);
        lb_titulo_morada.setBounds(5, 5, pane_morada.getWidth() - 10, 30);
        lb_titulo_morada.setBackground(new Color(253, 131, 0));
        lb_titulo_morada.setHorizontalAlignment(SwingConstants.CENTER);
        lb_titulo_morada.setForeground(new Color(255, 255, 255));
        lb_titulo_morada.setFont(font_lb_titulos);
        pane_morada.add(lb_titulo_morada);

        lb_morada = new JLabel("Provincia");
        lb_morada.setFont(font_lbs);
        lb_morada.setForeground(cor_font_lbs);
        lb_morada.setBounds(30, 40, 300, 25);
        pane_morada.add(lb_morada);

        cb_provincias_morrada = new JComboBox<>();
        cb_provincias_morrada.setBackground(new Color(255, 255, 255));
        cb_provincias_morrada.setFont(font_lbs);
        cb_provincias_morrada.setForeground(cor_font_lbs);
        cb_provincias_morrada.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        cb_provincias_morrada.setBounds(20, 65, 350, 25);
        pane_morada.add(cb_provincias_morrada);

        lb_bairro = new JLabel("Bairro");
        lb_bairro.setFont(font_lbs);
        lb_bairro.setForeground(cor_font_lbs);
        lb_bairro.setBounds(30, 90, 300, 25);
        pane_morada.add(lb_bairro);

        txt_bairro = new CampoTexto();
        txt_bairro.setTextoFundo("Digite o nome do bairro");
        txt_bairro.setFont(font_lbs);
        txt_bairro.setForeground(cor_font_lbs);
        txt_bairro.setBounds(20, 115, 350, 25);
        pane_morada.add(txt_bairro);

        lb_quarteirao = new JLabel("Quarteirao");
        lb_quarteirao.setFont(font_lbs);
        lb_quarteirao.setForeground(cor_font_lbs);
        lb_quarteirao.setBounds(50, 140, 150, 25);
        pane_morada.add(lb_quarteirao);

        txt_quarteirao = new CampoTexto();
        txt_quarteirao.setTextoFundo("nr do quaiteirao");
        txt_quarteirao.setFont(font_lbs);
        txt_quarteirao.setForeground(cor_font_lbs);
        txt_quarteirao.setBounds(20, 165, 170, 25);
        pane_morada.add(txt_quarteirao);

        lb_casa = new JLabel("Casa");
        lb_casa.setFont(font_lbs);
        lb_casa.setForeground(cor_font_lbs);
        lb_casa.setBounds(230, 135, 150, 25);
        pane_morada.add(lb_casa);

        txt_num_casa = new CampoTexto();
        txt_num_casa.setTextoFundo("nr da casa");
        txt_num_casa.setFont(font_lbs);
        txt_num_casa.setForeground(cor_font_lbs);
        txt_num_casa.setBounds(200, 165, 170, 25);
        pane_morada.add(txt_num_casa);

        pane_contactos = new JPanel(null);
        pane_contactos.setBackground(new Color(255, 255, 255));
        pane_contactos.setBounds(410, 220, 390, 150);
        pane_contactos.setBorder(new LineBorder(cor_font_lbs, 1));
        pane_dados.add(pane_contactos);

        lb_contactos = new JLabel("Contactos");
        lb_contactos.setOpaque(true);
        lb_contactos.setBounds(5, 5, pane_morada.getWidth() - 10, 30);
        lb_contactos.setBackground(new Color(253, 131, 0));
        lb_contactos.setHorizontalAlignment(SwingConstants.CENTER);
        lb_contactos.setForeground(new Color(255, 255, 255));
        lb_contactos.setFont(font_lb_titulos);
        pane_contactos.add(lb_contactos);

        lb_cell = new JLabel("Telefone");
        lb_cell.setFont(font_lbs);
        lb_cell.setForeground(cor_font_lbs);
        lb_cell.setBounds(30, 40, 300, 25);
        pane_contactos.add(lb_cell);

        cb_cell = new JComboBox<>();
        cb_cell.setBackground(new Color(255, 255, 255));
        cb_cell.setFont(font_lbs);
        cb_cell.setForeground(cor_font_lbs);
        cb_cell.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        cb_cell.setBounds(20, 65, 300, 25);
        pane_contactos.add(cb_cell);

        btn_novo_cell = new Botao();
        btn_novo_cell.setBackground(new Color(0, 128, 0));
        btn_novo_cell.setBackgroundMouseEntered(new Color(38, 180, 45));
        btn_novo_cell.setBounds(323, 65, 25, 25);
        btn_novo_cell.setForeground(new Color(255, 255, 255));
        btn_novo_cell.setIcon(new ImageIcon(getClass().getResource("/icons/plus-16.png")));
        pane_contactos.add(btn_novo_cell);

        btn_rem_cell = new Botao();
        btn_rem_cell.setBackground(new Color(255, 0, 0));
        btn_rem_cell.setBackgroundMouseEntered(new Color(255, 24, 24));
        btn_rem_cell.setBounds(350, 65, 25, 25);
        btn_rem_cell.setForeground(new Color(255, 255, 255));
        btn_rem_cell.setIcon(new ImageIcon(getClass().getResource("/icons/delete-16.png")));
        pane_contactos.add(btn_rem_cell);

        lb_email = new JLabel("Email");
        lb_email.setFont(font_lbs);
        lb_email.setForeground(cor_font_lbs);
        lb_email.setBounds(30, 90, 300, 25);
        pane_contactos.add(lb_email);

        cb_email = new JComboBox<>();
        cb_email.setBackground(new Color(255, 255, 255));
        cb_email.setFont(font_lbs);
        cb_email.setForeground(cor_font_lbs);
        cb_email.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        cb_email.setBounds(20, 115, 300, 25);
        pane_contactos.add(cb_email);

        btn_novo_em = new Botao();
        btn_novo_em.setBackground(new Color(0, 128, 0));
        btn_novo_em.setBackgroundMouseEntered(new Color(38, 180, 45));
        btn_novo_em.setBounds(323, 115, 25, 25);
        btn_novo_em.setForeground(new Color(255, 255, 255));
        btn_novo_em.setIcon(new ImageIcon(getClass().getResource("/icons/plus-16.png")));
        pane_contactos.add(btn_novo_em);

        btn_rem_em = new Botao();
        btn_rem_em.setBackground(new Color(255, 0, 0));
        btn_rem_em.setBackgroundMouseEntered(new Color(255, 24, 24));
        btn_rem_em.setBounds(350, 115, 25, 25);
        btn_rem_em.setForeground(new Color(255, 255, 255));
        btn_rem_em.setIcon(new ImageIcon(getClass().getResource("/icons/delete-16.png")));
        pane_contactos.add(btn_rem_em);

        pane_dados_acade = new JPanel(null);
        pane_dados_acade.setBackground(new Color(255, 255, 255));
        pane_dados_acade.setBounds(410, 380, 390, 100);
        pane_dados_acade.setBorder(new LineBorder(cor_font_lbs, 1));
        pane_dados.add(pane_dados_acade);

        lb_dados_acad = new JLabel("Dados Academicos");
        lb_dados_acad.setOpaque(true);
        lb_dados_acad.setBounds(5, 5, pane_morada.getWidth() - 10, 30);
        lb_dados_acad.setBackground(new Color(253, 131, 0));
        lb_dados_acad.setHorizontalAlignment(SwingConstants.CENTER);
        lb_dados_acad.setForeground(new Color(255, 255, 255));
        lb_dados_acad.setFont(font_lb_titulos);
        pane_dados_acade.add(lb_dados_acad);

        lb_curso = new JLabel("Selecione o Curso");
        lb_curso.setFont(font_lbs);
        lb_curso.setForeground(cor_font_lbs);
        lb_curso.setBounds(30, 40, 300, 25);
        pane_dados_acade.add(lb_curso);

        cb_cursos = new JComboBox<>();
        cb_cursos.setBackground(new Color(255, 255, 255));
        cb_cursos.setFont(font_lbs);
        cb_cursos.setForeground(cor_font_lbs);
        cb_cursos.setCursor(new Cursor((Cursor.HAND_CURSOR)));
        cb_cursos.setBounds(20, 65, 350, 25);
        pane_dados_acade.add(cb_cursos);

        btn_cadastrar = new Botao("Cadastrar");
        btn_cadastrar.setBackground(new Color(0, 128, 0));
        btn_cadastrar.setBackgroundMouseEntered(new Color(85, 170, 85));
        btn_cadastrar.setForeground(new Color(255, 255, 255));
        btn_cadastrar.setBounds(410, 490, 190, 30);
        pane_dados.add(btn_cadastrar);

        btn_cancelar = new Botao("Cancelar");
        btn_cancelar.setBackground(new Color(255, 0, 0));
        btn_cancelar.setBackgroundMouseEntered(new Color(255, 24, 24));
        btn_cancelar.setForeground(new Color(255, 255, 255));
        btn_cancelar.setBounds(610, 490, 190, 30);
        pane_dados.add(btn_cancelar);

        btn_grupo = new ButtonGroup();
        btn_grupo.add(btn_masc);
        btn_grupo.add(btn_fem);
        btn_masc.setSelected(true);
        
        eventosbotoes();
    }

    private JPanel pane_principal, pane_titulo, pane_dados, pane_morada,
            pane_genero, pane_dados_pessoais, pane_dados_acade, pane_contactos;

    private JLabel lb_titulo, lb_nome, lb_apelido, lb_data_nasc, lb_bairro, lb_casa, lb_quarteirao,
            lb_email, lb_sexo, lb_estado, lb_bi, lb_nuit, lb_naturalidade, lb_titulo_morada,
            lb_dados_pessoasis, lb_morada, lb_dados_acad, lb_curso, lb_contactos, lb_cell;

    private CampoTexto txt_nome, txt_apelido, txt_bairro, txt_data_nasc,
            txt_num_casa, txt_num_bi, txt_num_nuit, txt_email, txt_quarteirao;

    private JComboBox<Curso> cb_cursos;
    private JComboBox<String> cb_estado_civil;
    private JComboBox<Provincia> cb_provincias;
    private JComboBox<Provincia> cb_provincias_morrada;
    private JComboBox<TelefoneEstudante> cb_cell;
    private JComboBox<EmailEstudante> cb_email;
    private Font font_lbs, font_lb_titulos;
    private Color cor_font_lbs;
    private JRadioButton btn_masc, btn_fem;
    private List<Provincia> provincias;
    private List<Curso> cursos;
    private Botao btn_cancelar, btn_cadastrar, btn_novo_cell, btn_rem_cell, btn_novo_em, btn_rem_em;
    private ButtonGroup btn_grupo;
    private Estudante estudante;
    private Provincia provincia;
    private Curso curso;
    private Calendar calendario;
    private String gerar;
    private TelaEstudante pane;

}
