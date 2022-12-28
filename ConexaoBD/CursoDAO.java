/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Entidades.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Salomao Valoi
 */
public class CursoDAO {
    
    private static Connection conexao;
    private static CallableStatement call;
    private static ResultSet result;

    public static List<Curso> listaCursos(String opcao, String chave) {
        List<Curso> lista = new ArrayList();
        try {
            conexao = ConexaoDAO.abrirConexao();
            call = conexao.prepareCall("{ call listacursos(?,?)}");
            call.setString(1, opcao);
            call.setString(2, chave);
            result = call.executeQuery();
            while (result.next()) {
                lista.add(new Curso(result.getString(1), result.getString(2), result.getString(3)));
            }
        } catch (SQLSyntaxErrorException x) {
            x.printStackTrace();
            JOptionPane.showMessageDialog(null, x);
        } catch (SQLException x) {
            x.printStackTrace();
             JOptionPane.showMessageDialog(null, x);
        } catch (Exception x) {
            x.printStackTrace();
             JOptionPane.showMessageDialog(null, x);
        
        } finally {
            ConexaoDAO.fecharConexao(conexao, call, result);
        }
        return lista;
    }

//    public static boolean inserirOuActualizar(Cliente cliente, String opcao, String chave) {

}
