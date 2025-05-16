package com.example.terminalMarittimo.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.terminalMarittimo.classiEntita.nave;

public class naveDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserisci una nuova nave
    public void inserisci(String tipologia, String nome) {
        String sql = "INSERT INTO nave (nome, tipo) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, tipologia);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizza tutte le navi
    public List<nave> visualizza() {
        List<nave> lista = new ArrayList<>();
        String sql = "SELECT * FROM nave";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                nave n = new nave(
                    rs.getInt("ID"),
                    rs.getString("nome"),
                    rs.getString("tipo")
                );
                lista.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Elimina una nave
    public void cancella(int ID) {
        String sql = "DELETE FROM nave WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
