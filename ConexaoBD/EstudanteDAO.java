/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import java.sql.*;
import java.util.*;
import Entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class EstudanteDAO {

    private static Connection conexao;
    private static CallableStatement call;
    private static ResultSet result;
    private static DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public static List<Estudante> listaEstudantes(String opcao, String chave) {
        List<Estudante> lista = new ArrayList();
        try {
            conexao = ConexaoDAO.abrirConexao();
            call = conexao.prepareCall("{ call listaestudantes(?,?)}");
            call.setString(1, opcao);
            call.setString(2, chave);
            result = call.executeQuery();
            while (result.next()) {
                Estudante estudante = new Estudante();

                estudante.setCodigo(result.getString(1));
                estudante.setApelido(result.getString(2));
                estudante.setNome(result.getString(3));
                estudante.setData_nasc(formato.format(result.getDate(4)));
                estudante.setNum_bi(result.getString(5));
                estudante.setNum_nuit(result.getString(6));
                estudante.setGenero(result.getString(7));
                estudante.setEstado_civi(result.getString(8));
                estudante.setCod_prov_morada(result.getString(9));
                estudante.setBairro(result.getString(10));
                estudante.setQuarteirao(result.getString(11));
                estudante.setNum_casa(result.getByte(12));
                estudante.setCod_prov_naturalidade(result.getString(13));
                estudante.setNomeCurso(result.getString(15));
                lista.add(estudante);
            }
        } catch (SQLSyntaxErrorException x) {
            JOptionPane.showMessageDialog(null, x);
        } catch (SQLException x) {
             JOptionPane.showMessageDialog(null, x);
        } catch (Exception x) {
             JOptionPane.showMessageDialog(null, x);
        
        } finally {
            ConexaoDAO.fecharConexao(conexao, call, result);
        }
        return lista;
    }

    public static boolean inserirOuActualizar(Estudante estudante, String opcao, String chave) {
        boolean conf = false;
        try {
            conexao = ConexaoDAO.abrirConexao();
            call = conexao.prepareCall("{call crudestudante(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            call.setString(1, opcao);
            call.setString(2, chave);
            call.setString(3, estudante.getCodigo());
            call.setString(4, estudante.getApelido());
            call.setString(5, estudante.getNome());
            call.setString(6, estudante.getData_nasc());
            call.setString(7, estudante.getNum_bi());
            call.setString(8, estudante.getNum_nuit());
            call.setString(9, estudante.getGenero());
            call.setString(10, estudante.getEstado_civi());
            call.setString(11, estudante.getCod_prov_morada());
            call.setString(12, estudante.getBairro());
            call.setString(13, estudante.getQuarteirao());
            call.setByte(14, estudante.getNum_casa());
            call.setString(15, estudante.getCod_prov_naturalidade());
            call.setString(16, estudante.getCodCurso());
            call.execute();
            conf = true;
        } catch (SQLException x) {

             x.printStackTrace();
            JOptionPane.showMessageDialog(null, x);
        } catch (Exception x) {
            x.printStackTrace();
            JOptionPane.showMessageDialog(null, x);
        } finally {
            ConexaoDAO.fecharConexao(conexao, call);
        }

        return conf;
    }
}

    

