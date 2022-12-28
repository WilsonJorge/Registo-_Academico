package Formularios.submenu;

import ConexaoBD.EstudanteDAO;
import ConexaoBD.TurmaDAO;
import Entidades.Estudante;
import Entidades.Turma;
import Formularios.TelaMenu;
import ModeloTabelas.TabelaEstudante;
import ModeloTabelas.TabelaTurma;
import componentes.Botao;
import componentes.CampoTexto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class TelaEstudante extends JFrame {

    public TelaEstudante() {

        inicializacao();
        lista = EstudanteDAO.listaEstudantes("1", "");
        lista_turmas = TurmaDAO.listaTurmas("1", "");
        preencherTabela();
        preencherTabelaTurma();
        eventosButoes();
        btn_info.setEnabled(false);
    }

    private void control(String m) {

        switch (m) {

            case "home":
                TelaMenu t = new TelaMenu();
                this.dispose();
                t.show();
                break;
                
            case "listar":
                
                lista = EstudanteDAO.listaEstudantes("5", turma.getCodigo());
                model.actualizarLista(lista);
                
                break;
        }

    }

    public void setTitulo(String titulo) {
        lb_titulo.setText(titulo);
    }

    public void preencherTabela() {
        model = new TabelaEstudante(lista);
        tbl_alunos.setModel(model);

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < model.getColumnCount(); i++) {
            tbl_alunos.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }
    public void preencherTabelaTurma() {
        model_turma = new TabelaTurma(lista_turmas);
        tbl_turmas.setModel(model_turma);

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < model_turma.getColumnCount(); i++) {
            tbl_turmas.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

    public TabelaEstudante modelo() {
        return model;
    }

    public void pesquisarEstudante() {
        int opcao = cb_opcoes_pesquisa.getSelectedIndex() + 2;
        if (opcao > 1) {
            lista = EstudanteDAO.listaEstudantes("" + opcao, txt_pesquisa.getText().trim());
            model.actualizarLista(lista);
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

        //inicializacao do campo pesquisa turmas
        txt_pesq_turma = new CampoTexto();
        txt_pesq_turma.setTextoFundo("Digite o codigo ou o ano");
        txt_pesq_turma.setFont(new Font("Century Gothic", Font.BOLD, 12));
        txt_pesq_turma.setForeground(new Color(29, 36, 98));
        pane_menu_lateral.add(txt_pesq_turma);

        //inicializacao do scrolpane para tabela turmas
        pane_tbl_turmas = new JScrollPane();
        pane_tbl_turmas.setBackground(Color.WHITE);
        pane_menu_lateral.add(pane_tbl_turmas);

        //inicializacao da tabela turmas
        tbl_turmas = new JTable();
        tbl_turmas.setBackground(new Color(255, 255, 255));
        tbl_turmas.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        tbl_turmas.setGridColor(new Color(75, 130, 181));
        tbl_turmas.getTableHeader().setFont(new Font("Centuary Gothic", Font.BOLD, 15));
        tbl_turmas.getTableHeader().setBackground(new Color(160, 196, 229));
        tbl_turmas.getTableHeader().setForeground(new Color(29, 36, 98));
        tbl_turmas.setRowHeight(25);
        pane_tbl_turmas.setViewportView(tbl_turmas);

        //inicializacao da caixa do texto para mostara a turma selecionada
        txt_tur_sel= new CampoTexto();
        txt_tur_sel.setEditable(false);
        txt_tur_sel.setBackground(new Color(240, 240, 240));
        txt_tur_sel.setForeground(new Color(80, 80, 80));
        txt_tur_sel.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        pane_menu_lateral.add(txt_tur_sel);
        
        //inicializacao do botao para listar os estudantes da turma selecionada
        btn_listar = new Botao("Lista de estudantes da turma selecionada");
        btn_listar.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        btn_listar.setFocusPainted(false);
        btn_listar.setBackground(new Color(0, 128, 0));
        btn_listar.setBackgroundMouseEntered(new Color(38, 180, 45));
        btn_listar.setForeground(cor_font_botao);
        pane_menu_lateral.add(btn_listar);
        
        //inicializacao do painel de conteudo (painel que carrgea a tabela da listagem de turmas )
        pane_conteudo = new JPanel();
        pane_conteudo.setBackground(new Color(255, 255, 255));
        pane_conteudo.setSize(800, 500);
        pane_conteudo.setBorder(new LineBorder(new Color(0, 0, 0), 2));

        //inicializacao do painel de botoes(botoes que fazem CRUD de estudantes)
        pane_butoes = new JPanel();
        pane_butoes.setLayout(null);
        pane_butoes.setBackground(cor_font_botao);
        pane_butoes.setBorder(new LineBorder(new Color(29, 36, 98), 1, true));

        btn_novo = new Botao("Novo");
        btn_novo.setFont(font_botao);
        btn_novo.setFocusPainted(false);
        btn_novo.setBackground(new Color(0, 128, 0));
        btn_novo.setBackgroundMouseEntered(new Color(38, 180, 45));
        btn_novo.setForeground(cor_font_botao);
        pane_butoes.add(btn_novo);

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
        txt_pesquisa.setTextoFundo("Digite aqui para pesquisar");
        txt_pesquisa.setFont(new Font("Century Gothic", Font.BOLD, 13));
        txt_pesquisa.setForeground(new Color(29, 36, 98));

        String opcoes[] = new String[]{"Pesquisa pelo Codigo", "Pesquisa pelo Nome",
            "Pesquisa pelo Apelido", "Pesquisa pelo nr do BI", "Pesquisa pela Turma", "Pesquisa pelo Curso"};
        cb_opcoes_pesquisa = new JComboBox<>();
        cb_opcoes_pesquisa.setModel(new DefaultComboBoxModel<>(opcoes));
        cb_opcoes_pesquisa.setFont(new Font("Times new Roman", Font.BOLD, 14));
        cb_opcoes_pesquisa.setBackground(new Color(255, 255, 255));
        cb_opcoes_pesquisa.setForeground(new Color(29, 36, 98));
        cb_opcoes_pesquisa.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pane_tabela = new JScrollPane();
        pane_tabela.setBackground(cor_font_botao);

        tbl_alunos = new JTable();
        tbl_alunos.setBackground(new Color(255, 255, 255));
        tbl_alunos.setFont(new Font("Centuary Gothic", Font.BOLD, 13));
        tbl_alunos.setGridColor(new Color(75, 130, 181));
        tbl_alunos.getTableHeader().setFont(new Font("Centuary Gothic", Font.BOLD, 15));
        tbl_alunos.getTableHeader().setBackground(new Color(160, 196, 229));
        tbl_alunos.getTableHeader().setForeground(new Color(29, 36, 98));
        tbl_alunos.setRowHeight(25);
        pane_tabela.setViewportView(tbl_alunos);
        pane_conteudo.add(pane_tabela);

        pane_conteudo.add(txt_pesquisa);
        pane_conteudo.add(cb_opcoes_pesquisa);
        pane_conteudo.add(pane_butoes);

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

        // localizacao do campo pesquisa turma
        txt_pesq_turma.setBounds(10, 80, 280, 25);

        // definicao da localizacao da tabela turmas
        h = pane_menu_lateral.getHeight() - 200;
        y = txt_pesq_turma.getHeight() + txt_pesq_turma.getY() + 10;
        pane_tbl_turmas.setBounds(10, y, 280, h);
        tbl_turmas.setSize(pane_tbl_turmas.getSize());
        
        //definicao da localizacao campo turmas selecionadas
       int y1=h+y+10;
        txt_tur_sel.setBounds(10, y1, 280, 27);
        
        //
        btn_listar.setBounds(15, y1+35, 270, 25);

        h = pane_menu_lateral.getHeight() - 5;
        w = pane_conteiner.getWidth() - pane_menu_lateral.getWidth() - 15;

        pane_conteudo.setBounds(310, pane_titulo.getHeight() + 10, w, h);

        w = pane_conteudo.getWidth() - 10;
        pane_butoes.setBounds(5, 5, w, 50);

        w = pane_conteudo.getWidth() / 2;
        y = pane_butoes.getHeight() + pane_butoes.getY() + 15;
        txt_pesquisa.setBounds(15, y, w + 120, 30);

        x = txt_pesquisa.getX() + txt_pesquisa.getWidth() + 20;
        cb_opcoes_pesquisa.setBounds(x, txt_pesquisa.getY(), w - 160, 30);

        w = pane_conteudo.getWidth() - 15;
        h = pane_conteudo.getHeight() - pane_butoes.getHeight() - txt_pesquisa.getHeight() - 50;
        y = txt_pesquisa.getY() + txt_pesquisa.getHeight() + 20;

        pane_tabela.setBounds(10, y, w, h);
        tbl_alunos.setBounds(0, 0, w, h);

        x = (pane_butoes.getWidth() / 4) - 13;

        btn_novo.setSize(x, 30);
        btn_novo.setLocation(12, (pane_butoes.getHeight() - btn_novo.getHeight()) / 2);

        y = (pane_butoes.getHeight() - btn_novo.getHeight()) / 2;
        btn_editar.setSize(x, 30);
        btn_editar.setLocation(btn_novo.getX() + btn_novo.getWidth() + 10, y);

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
        pane = this;
        btn_novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DialogoCadastroEstudante d = new DialogoCadastroEstudante(pane);
                d.setVisible(true);
            }
        });

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
                DialogoInfoEstudante d = new DialogoInfoEstudante(estudante);
                d.setVisible(true);
            }
        });
        tbl_alunos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                indice = tbl_alunos.getSelectedRow();
                if (indice >= 0) {
                    estudante = model.retornarEstudante(indice);
                    btn_info.setEnabled(true);
                } else {
                    btn_info.setEnabled(false);
                }
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                indice = tbl_alunos.getSelectedRow();
                if (indice >= 0) {
                    estudante = model.retornarEstudante(indice);
                    btn_info.setEnabled(true);
                    DialogoInfoEstudante d = new DialogoInfoEstudante(estudante);
                    d.setVisible(true);
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
        btn_listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control("listar");
            }

        });
        

    }
    
    private JTable tbl_alunos, tbl_turmas;
    private CampoTexto txt_pesquisa, txt_pesq_turma, txt_tur_sel;
    private JPanel pane_butoes, pane_conteudo, pane_conteiner, pane_menu_lateral, pane_titulo;
    private JLabel lb_titulo;
    private Botao btn_novo, btn_editar, btn_remover, btn_info, btn_listar;
    private Font font_botao, font_titulo, font_menu;
    private Color cor_font_botao;
    private JComboBox<String> cb_opcoes_pesquisa;
    private JScrollPane pane_tabela, pane_tbl_turmas;
    private TabelaEstudante model;
    private TabelaTurma model_turma;
    private TelaEstudante pane;
    private List<Estudante> lista;
    private Estudante estudante;
    private Turma turma;
    private List<Turma> lista_turmas;
    private Botao btn_sair, btn_home;
    private int indice;

}
