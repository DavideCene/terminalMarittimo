package com.example.terminalMarittimo.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.terminalMarittimo.classiEntita.fornitore;

public class fornitoreDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal_marittimo";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Metodo per inserire un fornitore
    public void inserisci(String nome, String cognome, String email, String telefono, String password) {
        String sql = "INSERT INTO fornitore (nome, cognome, email, telefono, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, email);
            stmt.setString(4, telefono);
            stmt.setString(5, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per visualizzare tutti i fornitori
    public List<fornitore> visualizza() {
        List<fornitore> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornitore";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornitore f = new fornitore(
                    rs.getInt("ID"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("email"),
                    rs.getString("telefono"),
                    rs.getString("password")
                );
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Metodo per eliminare un fornitore tramite ID
    public void cancella(int ID) {
        String sql = "DELETE FROM fornitore WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIDLogin(String username, String pass) {
        try (Connection conn = DriverManager.getConnection(url, user,password)) 
        {
            String sql = "SELECT ID FROM fornitore WHERE password = ? AND email = ?";
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
