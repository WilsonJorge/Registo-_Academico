/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.submenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Salomao Valoi
 */
public class PainelDashBoard extends JPanel {

    public PainelDashBoard() {
        inicializacao();
    }

    private void inicializacao() {
        this.setLayout(null);
        this.setBackground(new Color(255, 255, 255));
        this.setBorder(new LineBorder(new Color(29, 36, 98),2));
        this.setSize(800, 500);

        font_lb_titulo = new Font("Centruy Schoolbock", Font.BOLD, 25);
        font_total = new Font("Ebrima", Font.BOLD, 30);
        cor_font = new Color(255, 255, 255);

        pane_estudante = new JPanel(null);
        pane_estudante.setBackground(new Color(220, 92, 0));

        lb_tit_est = new JLabel("Estudantes");
        lb_tit_est.setBackground(new Color(240, 130, 26));
        lb_tit_est.setFont(font_lb_titulo);
        lb_tit_est.setForeground(cor_font);
        pane_estudante.add(lb_tit_est);

        pane_turma = new JPanel(null);
        pane_turma.setBackground(new Color(63, 107, 181));

        lb_tit_tur = new JLabel("Turmas");
        lb_tit_tur.setBackground(new Color(57, 129, 222));
        lb_tit_tur.setFont(font_lb_titulo);
        lb_tit_tur.setForeground(cor_font);

        pane_curso = new JPanel(null);
        
        eventosTela();

    }

    private void posicionamento() {
        int x = (this.getWidth() / 3) - 40;
        int y = (this.getHeight() / 2) - 60;

        pane_estudante.setBounds(10, 20, x, y);
        lb_tit_est.setBounds(0, 0, pane_estudante.getWidth(), 40);

        pane_turma.setBounds(pane_estudante.getX() + x + 10, 20, x, y);
        lb_tit_tur.setBounds(0, 0, pane_turma.getWidth(), 40);
    }
    
    public void dimensao(int x, int y){
        this.setSize(x, y);
        eventosTela();
    }
    
    private void eventosTela(){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                posicionamento();
            }
            
});
    }

    private JPanel pane_estudante, pane_turma, pane_curso, painel5;
    private JLabel lb_tit_est, lb_tit_tur, lb_tit_cur, l22, l3, l33, l4, l44, l5, l55, l6, l66;
    private Font font_lb_titulo, font_total;
    private Color cor_font;
}
