/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabelas;

import ConexaoBD.EstudanteDAO;
import Entidades.Estudante;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Salomao Valoi
 */
public class TabelaEstudante extends AbstractTableModel {

    private List<Estudante> lista;
    private String[] colunas = new String[]{"Codigo", "Nome completo", "Curso"};

    public TabelaEstudante() {
    }
    public TabelaEstudante(List<Estudante> estudantes) {
        lista=estudantes;
    }
    public void actualizarLista(List<Estudante> estudantes) {
        lista=estudantes;
        this.fireTableDataChanged();
    }

   @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
public String getColumnName(int indice){
    return colunas[indice];
}
    @Override
    public Object getValueAt(int linha, int coluna) {
    Estudante est=lista.get(linha);
    
    switch(coluna){
        case 0:
            return est.getCodigo();
            
        case 1:
            return est.getNome()+" "+est.getApelido();
        case 2:
            
            return est.getNomeCurso();
            
        default:
            return "";
    }
    }
    
    public void actualizar(Estudante estudante){
        lista.add(estudante);
        fireTableRowsInserted(lista.size()-1, lista.size()-1);
    }
    
    public Estudante retornarEstudante(int indice){
        return lista.get(indice);
    }

}
