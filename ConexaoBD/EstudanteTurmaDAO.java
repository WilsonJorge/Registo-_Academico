/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Entidades.TelefoneEstudante;
import Entidades.Turma;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salomao Valoi
 */
public class EstudanteTurmaDAO {
    private static Connection conexao;
    private static CallableStatement call;
    private static ResultSet result;
    
//    public static List<Turma> listaTurmas(String opcao, String chave) {
//        List<Turma> lista = new ArrayList<>();
//        try {
//            conexao = ConexaoBD.ConexaoDAO.abrirConexao();
//            call = conexao.prepareCall("{ call listaturmas(?,?)}");
//            call.setString(1, opcao);
//            call.setString(2, chave);
//            result = call.executeQuery();
//            while (result.next()) {
//                
//                lista.add(new Turma(result.getString(1), result.getString(2), result.getString(3)));
//            }
//        } catch (SQLException x) {
//
//        } catch (Exception x) {
//
//        } finally {
//            ConexaoBD.ConexaoDAO.fecharConexao(conexao, call, result);
//        }
//        return lista;
//    }
    
}
