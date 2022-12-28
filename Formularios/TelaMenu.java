package Formularios;

import ConexaoBD.EstudanteDAO;
import Formularios.submenu.PainelDashBoard;
import Formularios.submenu.TelaCurso;
import Formularios.submenu.TelaEstudante;
import componentes.Botao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class TelaMenu extends JFrame {

    public TelaMenu() {
        inicializacao();
        eventosButoes();
        layouts();
        
        adicionarPaneis("inicio");
        preencher();

    }

    public void preencher(){
        total = EstudanteDAO.listaEstudantes("1", "").size();
        lb_total_est.setText(total+"");
    }
    private void inicializacao() {

        font = new Font("Century Gothic", Font.BOLD, 30);
        font_menu = new Font("Century", Font.BOLD, 20);
        font_desc= new Font("Times new Roman", Font.BOLD, 17);
        
        
        lb_titulo = new JLabel("Sistema de Registo Academico");
        lb_titulo.setForeground(new Color(255, 255, 255));
        lb_titulo.setOpaque(false);
        lb_titulo.setSize(400, 40);
        lb_titulo.setFont(font);
        lb_titulo.setHorizontalAlignment(SwingConstants.CENTER);

        pane_titulo = new JPanel();
        pane_titulo.setLayout(null);
        pane_titulo.setBackground(new Color(29, 36, 98));
        pane_titulo.add(lb_titulo);

        pane_menu_lateral = new JPanel();
        pane_menu_lateral.setLayout(null);
        pane_menu_lateral.setBackground(new Color(29, 36, 98));

        pane_conteudo = new JPanel();
        pane_conteudo.setLayout(null);
        pane_conteudo.setBackground(new Color(255, 255, 255));

        

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

        

        pane_principal = new JPanel();
        pane_principal.setLayout(null);
        pane_principal.setBackground(new Color(255, 255, 255));
        pane_principal.add(pane_titulo);
        pane_principal.add(pane_menu_lateral);
        pane_principal.add(pane_conteudo);
        
        
        
        //Inicio da codificacao do dashboard
        
        
        font_lb_titulo = new Font("Centruy Schoolbock", Font.BOLD, 25);
        font_total = new Font("Ebrima", Font.BOLD, 50);
        cor_font = new Color(255, 255, 255);

        pane_estudante = new JPanel(null);
        pane_estudante.setBackground(new Color(220, 92, 0));
        pane_conteudo.add(pane_estudante);

        lb_tit_est = new JLabel("Estudantes");
        lb_tit_est.setBackground(new Color(240, 130, 26));
        lb_tit_est.setFont(font_lb_titulo);
        lb_tit_est.setForeground(cor_font);
        lb_tit_est.setOpaque(true);
        lb_tit_est.setHorizontalAlignment(SwingConstants.CENTER);
        pane_estudante.add(lb_tit_est);

        lb_total_est=new JLabel("0");
        lb_total_est.setForeground(cor_font);
        lb_total_est.setFont(font_total);
        lb_total_est.setHorizontalAlignment(SwingConstants.CENTER);
        pane_estudante.add(lb_total_est);
        
        lb_desc_est= new JLabel("* Nos ultimos 3 Meses");
        lb_desc_est.setFont(font_desc);
        lb_desc_est.setForeground(cor_font);
        lb_desc_est.setHorizontalAlignment(SwingConstants.CENTER);
        pane_estudante.add(lb_desc_est);
        
        pane_turma = new JPanel(null);
        pane_turma.setBackground(new Color(63, 107, 181));
        pane_conteudo.add(pane_turma);

        lb_tit_tur = new JLabel("Turmas");
        lb_tit_tur.setBackground(new Color(57, 129, 222));
        lb_tit_tur.setFont(font_lb_titulo);
        lb_tit_tur.setForeground(cor_font);
        lb_tit_tur.setOpaque(true);
        lb_tit_tur.setHorizontalAlignment(SwingConstants.CENTER);
        pane_turma.add(lb_tit_tur);
        
        lb_total_turma=new JLabel("0");
        lb_total_turma.setForeground(cor_font);
        lb_total_turma.setFont(font_total);
        lb_total_turma.setHorizontalAlignment(SwingConstants.CENTER);
        pane_turma.add(lb_total_turma);
        
        lb_desc_turma= new JLabel("* Nos ultimos 3 Anos");
        lb_desc_turma.setFont(font_desc);
        lb_desc_turma.setForeground(cor_font);
        lb_desc_turma.setHorizontalAlignment(SwingConstants.CENTER);
        pane_turma.add(lb_desc_turma);

        pane_curso = new JPanel(null);
        pane_curso.setBackground(new Color(0, 134, 116));
        pane_conteudo.add(pane_curso);
        
        lb_tit_cur= new JLabel("Cursos");
        lb_tit_cur.setBackground(new Color(31, 169, 158));
        lb_tit_cur.setFont(font_lb_titulo);
        lb_tit_cur.setForeground(cor_font);
        lb_tit_cur.setOpaque(true);
        lb_tit_cur.setHorizontalAlignment(SwingConstants.CENTER);
        pane_curso.add(lb_tit_cur);
        
        lb_total_curso=new JLabel("0");
        lb_total_curso.setForeground(cor_font);
        lb_total_curso.setFont(font_total);
        lb_total_curso.setHorizontalAlignment(SwingConstants.CENTER);
        pane_curso.add(lb_total_curso);
        
        lb_desc_curso= new JLabel("* Nos ultimos 3 Anos");
        lb_desc_curso.setFont(font_desc);
        lb_desc_curso.setForeground(cor_font);
        lb_desc_curso.setHorizontalAlignment(SwingConstants.CENTER);
        pane_curso.add(lb_desc_curso);
        
        
        //Fim da codificacao do dashboard
        
        

        this.getContentPane().add(pane_principal);
        this.setSize(1200, 700);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventosJanela();
        

    }

    private void adicionarPaneis(String opcao) {

        switch (opcao) {

            case "curso":
                TelaCurso t = new TelaCurso();
                this.dispose();
                t.show();
                break;
            case "estudante":
               tela_est= new TelaEstudante();
               tela_est.setTitulo("Estudantes");
               this.dispose();
               tela_est.show();
               
                break;
        }

    }

    private void layouts() {
        
        //defininicao da localizacao do panel de cabelhalho
        pane_titulo.setSize(this.pane_principal.getWidth() - 5, 50);
        pane_titulo.setLocation((this.getWidth() - pane_titulo.getWidth()) / 2 - 8, 5);

         //defininicao da localizacao da label de cabelhalho
        lb_titulo.setSize(pane_titulo.getWidth()-10, 40);
        lb_titulo.setLocation((pane_titulo.getWidth() - lb_titulo.getWidth()) / 2, 5);

        //defininicao da localizacao do panel de menu
        pane_menu_lateral.setSize(300, pane_principal.getHeight() - 65);
        pane_menu_lateral.setLocation(2, pane_titulo.getHeight() + 10);

        //defininicao da localizacao do panel de conteudos
        int h = pane_menu_lateral.getHeight() - 5;
        int w = this.getWidth() - pane_menu_lateral.getWidth() - 15;
        pane_conteudo.setBounds(310, pane_titulo.getHeight() + 10, w, h);

        int x = (pane_conteudo.getWidth() / 3) - 20;
        int y = (pane_conteudo.getHeight() / 2) - 60;

        //defininicao da localizacao do panel de estatisticas dos estudantes na tela
        pane_estudante.setBounds(10, 20, x, y);
        lb_tit_est.setBounds(0, 0, pane_estudante.getWidth(), 40);
        y = pane_estudante.getHeight()-lb_tit_est.getHeight()+lb_tit_est.getY()-110;
        lb_total_est.setBounds(0,y , pane_estudante.getWidth(), 50);
        lb_desc_est.setBounds(0, lb_total_est.getHeight()+lb_total_est.getY()+50, pane_estudante.getWidth(), 30);

        //defininicao da localizacao do panel de estatisticas das turmas na tela
        y = (pane_conteudo.getHeight() / 2) - 60;
        pane_turma.setBounds(pane_estudante.getX() + x + 10, 20, x, y);
        lb_tit_tur.setBounds(0, 0, pane_turma.getWidth(), 40);
        y = pane_turma.getHeight()-lb_tit_cur.getHeight()+lb_tit_cur.getY()-110;
        lb_total_turma.setBounds(0,y , pane_turma.getWidth(), 50);
        lb_desc_turma.setBounds(0, lb_total_turma.getHeight()+lb_total_turma.getY()+50, pane_turma.getWidth(), 30);
        
        //defininicao da localizacao do panel de estatisticas dos cursos na tela
        y = (pane_conteudo.getHeight() / 2) - 60;
        pane_curso.setBounds(pane_turma.getX() + x + 10, 20, x, y);
        lb_tit_cur.setBounds(0, 0, pane_curso.getWidth(), 40);
        y = pane_curso.getHeight()-lb_tit_cur.getHeight()+lb_tit_cur.getY()-110;
        lb_total_curso.setBounds(0,y , pane_curso.getWidth(), 50);
        lb_desc_curso.setBounds(0, lb_total_curso.getHeight()+lb_total_curso.getY()+50, pane_curso.getWidth(), 30);
        
    }

    private void eventosJanela() {

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                layouts();
            }

        });

    }

    private void eventosButoes() {
        btn_estudantes.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarPaneis("estudante");
            }
        });
        btn_home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarPaneis("inicio");
            }

        });
        btn_cursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarPaneis("curso");
            }

        });
        btn_cursos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarPaneis("turma");
            }

        });
    }

    public static void main(String[] args) {
        TelaMenu tela = new TelaMenu();
        tela.setVisible(true);
    }

    private JLabel lb_titulo,lb_tit_est, lb_tit_tur, lb_tit_cur,lb_total_est,lb_desc_est,lb_total_turma,
            lb_desc_turma,lb_total_curso, lb_desc_curso;
    private JPanel pane_principal, pane_conteudo, pane_titulo, pane_menu_lateral,pane_estudante, pane_turma, pane_curso;
    private JButton botao_sair;
    private LayoutStyle layout;
    private Font font, font_menu,font_lb_titulo, font_total,font_desc;
    private Botao btn_cursos, btn_sair, btn_estudantes, btn_turmas, btn_home;
    private String opcao;
    private PainelDashBoard pane_dash;
    private TelaEstudante tela_est;
    private int total;
    private Color cor_font;
}
