/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Entidades.TelefoneEstudante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TelefoneEstudanteDAO {

    private static Connection conexao;
    private static CallableStatement call;
    private static ResultSet result;
    
    public static List<TelefoneEstudante> listaTelefones(String opcao, String chave) {
        List<TelefoneEstudante> lista = new ArrayList<>();
        try {
            conexao = ConexaoBD.ConexaoDAO.abrirConexao();
            call = conexao.prepareCall("{ call listatelefone(?,?)}");
            call.setString(1, opcao);
            call.setString(2, chave);
            result = call.executeQuery();
            while (result.next()) {
                TelefoneEstudante telefone = new TelefoneEstudante(result.getString(1),
                        result.getString(2), result.getString(3));
                lista.add(telefone);
            }
        } catch (SQLException x) {

        } catch (Exception x) {

        } finally {
            ConexaoBD.ConexaoDAO.fecharConexao(conexao, call, result);
        }
        return lista;
    }

}
