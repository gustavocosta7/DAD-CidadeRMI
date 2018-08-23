/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class FabricaConexao {
    public static Connection getConnection(){
        try {
            String host = "jdbc:mysql://localhost/dad";
            String user = "root";
            String pass = "root";
            
            return DriverManager.getConnection(host, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


