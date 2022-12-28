/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.submenu;

import ConexaoBD.CursoDAO;
import Entidades.Curso;
import Formularios.TelaMenu;
import ModeloTabelas.TabelaCurso;
import componentes.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TelaCurso extends JFrame {

    public TelaCurso() {

        inicializacao();
        lista = CursoDAO.listaCursos("1", "");
        eventosButoes();
        preencherTabela();
        btn_info.setEnabled(false);
        btn_cancelar.requestFocus();
    }

    private void control(String m) {

        switch (m) {

            case "home":
                TelaMenu t = new TelaMenu();
                this.dispose();
                t.show();
                break;
        }

    }

    public void setTitulo(String titulo) {
        lb_titulo.setText(titulo);
    }

    public void preencherTabela() {

        model = new TabelaCurso(lista);
        tbl_curso.setModel(model);

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < model.getColumnCount(); i++) {
            tbl_curso.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

    public void pesquisarEstudante() {
        int opcao = cb_opcoes_pesquisa.getSelectedIndex() + 2;
        if (opcao > 1) {
            lista = CursoDAO.listaCursos("" + opcao, txt_pesquisa.getText().trim());
            model.actualizar(lista);
        }
    }

    private void inicializacao() {
        font_botao = new Font("Century", Font.BOLD, 16);
        cor_font_botao = new Color(255, 255, 255);

        font_titulo = new Font("Century Gothic", Font.BOLD, 20);
        font_menu = new Font("Century", Font.BOLD, 20);

        lb_titulo = new JLabel("Sistema de Registo Academico");
        lb_titulo.setForeground(new Color(255, 255, 255));
        lb_titulo.setOpaque(false);
        lb_titulo.setSize(400, 40);
        lb_titulo.setFont(font_titulo);
        lb_titulo.setHorizontalAlignment(SwingConstants.CENTER);

        pane_titulo = new JPanel();
        pane_titulo.setLayout(null);
        pane_titulo.setBackground(new Color(29, 36, 98));
        pane_titulo.add(lb_titulo);

        pane_menu_lateral = new JPanel();
        pane_menu_lateral.setLayout(null);
        pane_menu_lateral.setBackground(new Color(29, 36, 98));

        btn_home = new Botao("Home");
        btn_home.setBounds(10, 10, 280, 40);
        btn_home.setFont(font_menu);
        btn_home.setForeground(new Color(255, 255, 255));
        btn_home.setBackground(new Color(29, 36, 98));
        btn_home.setBackgroundMouseEntered(new Color(38, 180, 45));
        pane_menu_lateral.add(btn_home);

        btn_cursos = new Botao("Cursos");
        btn_cursos.setBounds(10, 60, 280, 40);
        btn_cursos.setFont(font_menu);
        btn_cursos.setForeground(new Color(255, 255, 255));
        btn_cursos.setBackground(new Color(29, 36, 98));
        btn_cursos.setBackgroundMouseEntered(new Color(38, 180, 45));
        pane_menu_lateral.add(btn_cursos);

        btn_turmas = new Botao("Turmas");
        btn_turmas.setBounds(10, 110, 280, 40);
        btn_turmas.setFont(font_menu);
        btn_turmas.setForeground(new Color(255, 255, 255));
        btn_turmas.setBackground(new Color(29, 36, 98));
        btn_turmas.setBackgroundMouseEntered(new Color(38, 180, 45));
        pane_menu_lateral.add(btn_turmas);

        btn_estudantes = new Botao("Estudantes");
        btn_estudantes.setBounds(10, 160, 280, 40);
        btn_estudantes.setFont(font_menu);
        btn_estudantes.setForeground(new Color(255, 255, 255));
        btn_estudantes.setBackground(new Color(29, 36, 98));
        btn_estudantes.setBackgroundMouseEntered(new Color(38, 180, 45));
        pane_menu_lateral.add(btn_estudantes);

        pane_conteudo = new JPanel();
        pane_conteudo.setBackground(new Color(255, 255, 255));
        pane_conteudo.setSize(800, 500);
        pane_conteudo.setBorder(new LineBorder(new Color(0, 0, 0), 2));

        pane_butoes = new JPanel();
        pane_butoes.setLayout(null);
        pane_butoes.setBackground(cor_font_botao);
        pane_butoes.setBorder(new LineBorder(new Color(29, 36, 98), 1, true));
        pane_conteudo.add(pane_butoes);

        btn_editar = new Botao("Editar");
        btn_editar.setFont(font_botao);
        btn_editar.setFocusPainted(false);
        btn_editar.setBackground(new Color(253, 131, 0));
        btn_editar.setBackgroundMouseEntered(new Color(253, 172, 85));
        btn_editar.setForeground(cor_font_botao);
        pane_butoes.add(btn_editar);

        btn_info = new Botao("Ver Infor.");
        btn_info.setFont(font_botao);
        btn_info.setFocusPainted(false);
        btn_info.setBackground(new Color(17, 137, 255));
        btn_info.setBackgroundMouseEntered(new Color(96, 176, 255));
        btn_info.setForeground(cor_font_botao);
        pane_butoes.add(btn_info);

        btn_remover = new Botao("Remover");
        btn_remover.setFont(font_botao);
        btn_remover.setFocusPainted(false);
        btn_remover.setBackground(new Color(255, 0, 0));
        btn_remover.setBackgroundMouseEntered(new Color(255, 56, 56));
        btn_remover.setForeground(cor_font_botao);
        pane_butoes.add(btn_remover);

        txt_pesquisa = new CampoTexto();
        txt_pesquisa.setFont(new Font("Century Gothic", Font.BOLD, 13));
        txt_pesquisa.setForeground(new Color(29, 36, 98));
        txt_pesquisa.setTextoFundo("Digite aqui para pesquisar");
        pane_conteudo.add(txt_pesquisa);

        String opcoes[] = new String[]{"Pesquisa pelo Codigo", "Pesquisa pelo Nome"};
        cb_opcoes_pesquisa = new JComboBox<>();
        cb_opcoes_pesquisa.setModel(new DefaultComboBoxModel<>(opcoes));
        cb_opcoes_pesquisa.setFont(new Font("Times new Roman", Font.BOLD, 14));
        cb_opcoes_pesquisa.setBackground(new Color(255, 255, 255));
        cb_opcoes_pesquisa.setForeground(new Color(29, 36, 98));
        cb_opcoes_pesquisa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pane_conteudo.add(cb_opcoes_pesquisa);

        //inicio da codificacao do cadastro de curso
        Font f = new Font("Centruy Gothic", Font.BOLD, 14);
        Color cor = new Color(27, 37, 98);
        pane_cadastro = new JPanel(null);
        pane_cadastro.setBorder(new LineBorder(new Color(41, 85, 152)));
        pane_cadastro.setBackground(new Color(255, 255, 255));
        pane_conteudo.add(pane_cadastro);

        lb_titulo_cadastro = new JLabel("Novo Curso");
        lb_titulo_cadastro.setBackground(new Color(244, 119, 32));
        lb_titulo_cadastro.setFont(new Font("Centruy Schoolbook", Font.BOLD, 18));
        lb_titulo_cadastro.setOpaque(true);
        lb_titulo_cadastro.setHorizontalAlignment(SwingConstants.CENTER);
        lb_titulo_cadastro.setForeground(new Color(255, 255, 255));
        pane_cadastro.add(lb_titulo_cadastro);

        lb_codigo = new JLabel("Codigo");
        lb_codigo.setFont(f);
        lb_codigo.setForeground(cor);
        lb_codigo.setBounds(20, 20, 200, 25);
        pane_cadastro.add(lb_codigo);

        txt_codigo = new CampoTexto();
        txt_codigo.setTextoFundo("Digite o Codigo");
        txt_codigo.setFont(f);
        txt_codigo.setForeground(cor);
        txt_codigo.setBounds(15, 45, 300, 30);
        pane_cadastro.add(txt_codigo);

        lb_nome = new JLabel("Nome");
        lb_nome.setFont(f);
        lb_nome.setForeground(cor);
        lb_nome.setBounds(330, 20, 250, 25);
        pane_cadastro.add(lb_nome);

        txt_nome = new CampoTexto();
        txt_nome.setTextoFundo("Digite o Nome");
        txt_nome.setFont(f);
        txt_nome.setForeground(cor);
        txt_nome.setBounds(325, 45, 520, 30);
        pane_cadastro.add(txt_nome);

        lb_descricao = new JLabel("Observacoes");
        lb_descricao.setFont(f);
        lb_descricao.setForeground(cor);
        lb_descricao.setBounds(20, 75, 250, 25);
        pane_cadastro.add(lb_descricao);

        txt_descricao = new CampoTexto();
        txt_descricao.setTextoFundo("Digite aqui as observacoes ou detalhes do curso");
        txt_descricao.setFont(f);
        txt_descricao.setForeground(cor);
        txt_descricao.setBounds(15, 100, 520, 30);
        pane_cadastro.add(txt_descricao);

        btn_cadastrar = new Botao("Adicionar");
        btn_cadastrar.setFont(f);
        btn_cadastrar.setForeground(Color.WHITE);
        btn_cadastrar.setBackground(new Color(39, 81, 10));
        btn_cadastrar.setBackgroundMouseEntered(new Color(59, 122, 16));
        pane_cadastro.add(btn_cadastrar);

        btn_cancelar = new Botao("Cancelar");
        btn_cancelar.setFont(f);
        btn_cancelar.setForeground(Color.WHITE);
        btn_cancelar.setBackground(new Color(255, 0, 0));
        btn_cancelar.setBackgroundMouseEntered(new Color(255, 25, 25));
        pane_cadastro.add(btn_cancelar);

        //fimm
        pane_tabela = new JScrollPane();
        pane_tabela.setBackground(cor_font_botao);

        tbl_curso = new JTable();
        tbl_curso.setBackground(new Color(255, 255, 255));
        tbl_curso.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        tbl_curso.setGridColor(new Color(75, 130, 181));
        tbl_curso.getTableHeader().setFont(new Font("Centuary Gothic", Font.BOLD, 15));
        tbl_curso.getTableHeader().setBackground(new Color(160, 196, 229));
        tbl_curso.getTableHeader().setForeground(new Color(29, 36, 98));
        tbl_curso.setRowHeight(25);
        pane_tabela.setViewportView(tbl_curso);
        pane_conteudo.add(pane_tabela);

        pane_conteiner = new JPanel();
        pane_conteiner.setBackground(new Color(255, 255, 255));
        pane_conteiner.add(pane_titulo);
        pane_conteiner.add(pane_menu_lateral);
        pane_conteiner.add(pane_conteudo);

        this.setSize(1200, 700);
        this.getContentPane().add(pane_conteiner);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(700, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventos();

    }

    public void layouts() {
        int x, y, w, h;
        x = (pane_conteiner.getWidth() - pane_titulo.getWidth()) / 2;
        w = pane_conteiner.getWidth() - 8;

        pane_titulo.setBounds(5, 5, w, 50);

        w = pane_titulo.getWidth() - 10;

        lb_titulo.setBounds(5, 5, w, 40);

        y = pane_titulo.getHeight() + 10;
        h = pane_conteiner.getHeight() - 65;
        pane_menu_lateral.setBounds(2, y, 300, h);

        h = pane_menu_lateral.getHeight() - 5;
        w = pane_conteiner.getWidth() - pane_menu_lateral.getWidth() - 15;

        pane_conteudo.setBounds(310, pane_titulo.getHeight() + 10, w, h);

        w = pane_conteudo.getWidth() / 2;
        y = pane_butoes.getHeight() + pane_butoes.getY() + 15;
        txt_pesquisa.setBounds(15, 15, w + 120, 30);

        x = txt_pesquisa.getX() + txt_pesquisa.getWidth() + 20;
        cb_opcoes_pesquisa.setBounds(x, txt_pesquisa.getY(), w - 160, 30);

        w = pane_conteudo.getWidth() - 15;
        h = pane_conteudo.getHeight() - pane_butoes.getHeight() - txt_pesquisa.getHeight() - 250;
        y = txt_pesquisa.getY() + txt_pesquisa.getHeight() + 20;

        pane_tabela.setBounds(10, y, w, h);
        tbl_curso.setBounds(0, 0, w, h);

        y = pane_tabela.getHeight() + pane_tabela.getY() + 10;
        //posicionamento de painel de botoes
        w = pane_conteudo.getWidth() - 10;
        pane_butoes.setBounds(5, y, w, 50);

        int aux = pane_conteudo.getHeight() - pane_butoes.getHeight() - txt_pesquisa.getHeight() - 250;
        y = pane_butoes.getY() + pane_butoes.getHeight() + 10;
        h = pane_conteudo.getHeight() - aux - 190;

        /**
         * @posicionamento dos componentes que fazem parte do cadastro de curso
         */
        pane_cadastro.setBounds(5, y, w, h);
        lb_titulo_cadastro.setBounds(2, 2, pane_cadastro.getWidth() - 2, 20);
        txt_nome.setSize(pane_cadastro.getWidth() - txt_nome.getX() - 10, 30);
        txt_descricao.setSize(pane_cadastro.getWidth() - txt_descricao.getX() - 300, 30);
        x = txt_descricao.getX() + txt_descricao.getWidth() + 10;
        w = pane_cadastro.getWidth() - x - 155;
        y = txt_descricao.getY();
        btn_cadastrar.setBounds(x, y, w, 30);
        btn_cancelar.setBounds(btn_cadastrar.getX() + btn_cadastrar.getWidth() + 10, y, w, 30);
        /**
         * @ Fim do posicionamento dos componentes que fazem parte do cadastro
         * de curso
         */
        x = (pane_butoes.getWidth() / 3) - 12;

        y = (pane_butoes.getHeight() - 30) / 2;
        btn_editar.setSize(x, 30);
        btn_editar.setLocation(10, y);

        btn_info.setSize(x, 30);
        btn_info.setLocation(btn_editar.getX() + btn_editar.getWidth() + 10, y);

        btn_remover.setSize(x, 30);
        btn_remover.setLocation(btn_info.getX() + btn_info.getWidth() + 10, y);

    }

    public void eventos() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                layouts();
            }

        });

    }

    public void eventosButoes() {

        txt_pesquisa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                pesquisarEstudante();
                btn_info.setEnabled(false);
            }

        });

        cb_opcoes_pesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt_pesquisa.setTextoFundo(cb_opcoes_pesquisa.getSelectedItem().toString());
                txt_pesquisa.setBackgroundText();
            }
        });

        btn_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        tbl_curso.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                indice = tbl_curso.getSelectedRow();
                if (indice >= 0) {
                    curso = model.retornarCurso(indice);
                    btn_info.setEnabled(true);
                } else {
                    btn_info.setEnabled(false);
                }
            }

        });

        btn_home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control("home");
            }

        });
        btn_cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }

        });

        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }

        });

    }
    private JTable tbl_curso;
    private CampoTexto txt_pesquisa, txt_codigo, txt_descricao, txt_nome;
    private JPanel pane_butoes, pane_conteudo, pane_conteiner, pane_menu_lateral, pane_titulo, pane_cadastro;
    private JLabel lb_titulo, lb_codigo, lb_nome, lb_descricao, lb_titulo_cadastro;
    private Botao btn_novo, btn_editar, btn_remover, btn_info;
    private Font font_botao, font_titulo, font_menu;
    private Color cor_font_botao;
    private JComboBox<String> cb_opcoes_pesquisa;
    private JScrollPane pane_tabela;
    private TabelaCurso model;
    private TelaEstudante pane;
    private List<Curso> lista;
    private Curso curso;
    private Botao btn_cursos, btn_sair, btn_estudantes, btn_turmas, btn_home, btn_cadastrar, btn_cancelar;
    private int indice;

}
