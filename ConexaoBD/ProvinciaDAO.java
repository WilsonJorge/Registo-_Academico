
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

public class ProvinciaDAO {
    private static Connection conexao;
    private static CallableStatement call;
    private static ResultSet result;

    public static List<Provincia> listaProvincias(String opcao, String chave) {
        List<Provincia> lista = new ArrayList();
        try {
            conexao = ConexaoDAO.abrirConexao();
            call = conexao.prepareCall("{ call listaprovincias(?,?)}");
            call.setString(1, opcao);
            call.setString(2, chave);
            result = call.executeQuery();
            while (result.next()) {
                lista.add(new Provincia(result.getString(1), result.getString(2), result.getString(3)));
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
//        boolean conf = false;
//        try {
//            conexao = ConexaoDAO.abrirConexao();
//            call = conexao.prepareCall("{call inserir_ou_actualizar_cliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//
//            call.setString(1, opcao);
//            call.setString(2, chave);
//            call.setString(3, cliente.getCodigo());
//            call.setString(4, cliente.getApelido());
//            call.setString(5, cliente.getNome());
//            call.setString(6, cliente.getData_nasc());
//            call.setString(7, cliente.getTipo_documento());
//            call.setString(8, cliente.getNumDocumento());
//            call.setString(9, cliente.getData_emissao());
//            call.setString(10, cliente.getCodigo_local());
//            call.setString(11, cliente.getSexo());
//            call.setString(12, cliente.getBairro());
//            call.setString(13, cliente.getAvenida());
//            call.setString(14, cliente.getQuarteirao());
//            call.setString(15, cliente.getCasa());
//            call.setString(16, cliente.getEmail());
//            call.setString(17, cliente.getCodigo_tipo());
//            call.setString(18, cliente.getCodigo_pais());
//            call.setString(19, cliente.getCodigo_provincia());
//            call.setString(20, cliente.getDescricao());
//            call.execute();
//            conf = true;
//        } catch (SQLException x) {
//
//            alerta.setTitle("Mensagem de Erro");
//            alerta.setContentText(x.toString());
//            alerta.show();
//        } catch (Exception x) {
//            alerta.setTitle("Mensagem de Erro");
//            alerta.setContentText(x.toString());
//            alerta.show();
//        } finally {
//            ConexaoDAO.fecharConexao(conexao, call);
//        }
//
//        return conf;
//    }
}
