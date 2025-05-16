package com.example.terminalMarittimo.modelli;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.terminalMarittimo.classiEntita.autista;

public class autistaDAO {
 private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(String nome, String username, String password) {
        String sql = "INSERT INTO autista (nome, username, password) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<autista> visualizza() {
        List<autista> lista = new ArrayList<>();
        String sql = "SELECT * FROM autista";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                autista a = new autista(
                    rs.getInt("ID"),
                    rs.getString("nome"),
                    rs.getString("username"),
                    rs.getString("password")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void cancella(int id) {
        String sql = "DELETE FROM autista WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }  

    public int getIDLogin(String username, String pass) {
        try (Connection conn = DriverManager.getConnection(url, user,password)) 
        {
            String sql = "SELECT ID FROM autista WHERE password = ? AND username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pass);
            stmt.setString(2, username);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("ID");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}