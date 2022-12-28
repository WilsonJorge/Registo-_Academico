/*
`	 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;



import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Salomao Valoi
 */
public class ConexaoDAO {

    public static Connection abrirConexao() {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_reg_academico";
        String user = "root";
        String passw = "186426561379";
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, passw);

        } catch (ClassNotFoundException | SQLException x) {
            JOptionPane.showMessageDialog(null, x, "mensagem de erro", 0);

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x, "mensagem de erro", 0);
        }
        return conexao;
    }

    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "mensagem de erro", 0);
        }
    }

    public static void fecharConexao(Connection conexao, CallableStatement call) {
        try {
            if (call != null) {
                call.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "mensagem de erro", 0);
        }
        finally{
            fecharConexao(conexao);
        }
    }
    public static void fecharConexao(Connection conexao, CallableStatement call, ResultSet resultado) {
        try {
            if (resultado!= null) {
               resultado.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "mensagem de erro", 0);
        }
        finally{
            fecharConexao(conexao, call);
        }
    }
}
