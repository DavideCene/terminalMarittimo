package com.example.terminalMarittimo.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.terminalMarittimo.classiEntita.porto;

public class portoDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserimento porto
    public void inserisci(String nome, String rotta, String nazione) {
        String sql = "INSERT INTO porto (nome, rotta, nazione) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, rotta);
            stmt.setString(3, nazione);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizzazione porti
    public List<porto> visualizza() {
        List<porto> lista = new ArrayList<>();
        String sql = "SELECT * FROM porto";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                porto p = new porto(
                    rs.getInt("ID"),
                    rs.getString("nome"),
                    rs.getString("rotta"),
                    rs.getString("nazione")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Eliminazione porto
    public void cancella(int ID) {
        String sql = "DELETE FROM porto WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
