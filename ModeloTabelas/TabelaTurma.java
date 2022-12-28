/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabelas;

import Entidades.Curso;
import Entidades.Turma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Salomao Valoi
 */
public class TabelaTurma extends AbstractTableModel{
    private List<Turma> lista;
    private String colunas[];

    public TabelaTurma(List<Turma> lista) {
        this.lista = lista;
        colunas = new String[]{"Codigo", "Ano"};
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int i) {
        return colunas[i];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Turma c = lista.get(linha);
        switch (coluna) {
            case 0:
                return c.getCodigo();
            case 1:
                return c.getDesigncao();

            default:
                return "";
        }
    }

    public Turma retornarCurso(int linha) {
        return lista.get(linha);
    }

    public void actualizar(List<Turma> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void actualizarLinha(Turma c) {
        lista.add(c);
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }
}
