/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTabelas;

import Entidades.TelefoneEstudante;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Salomao Valoi
 */
public class TabelaTelefoneEstudante extends AbstractTableModel {

    private List<TelefoneEstudante> lista;
    private String colunas[];

    public TabelaTelefoneEstudante(List<TelefoneEstudante> lista) {
        this.lista = lista;
        colunas = new String[]{"Codigo", "Telefone", "Tipo"};
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int indice) {
        return colunas[indice];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        TelefoneEstudante tel = lista.get(linha);
        switch (coluna) {
            case 0:
                return tel.getCodigo();
            case 1:
                return tel.getTelefone();
            case 2:
                return tel.getTipo();
            default:
                return "";
        }

    }

}
