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
import com.example.terminalMarittimo.classiEntita.camion;
import com.example.terminalMarittimo.classiEntita.ritiro;

public class ritiroDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal_marittimo";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserisci nuovo ritiro
    public void inserisci(String targaCamion, int idAutista, double peso, String data) {
        String sql = "INSERT INTO ritiro (camion_targa, autista_id, peso, data) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, targaCamion);
            stmt.setInt(2, idAutista);
            stmt.setDouble(3, peso);
            stmt.setString(4, data);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizza tutti i ritiri
    public List<ritiro> visualizza() {
        List<ritiro> lista = new ArrayList<>();
        String sql = "SELECT r.ID, r.peso, r.data, c.targa, c.modello, a.id as autista_id, a.nome, a.username, a.password " +
                     "FROM ritiro r " +
                     "JOIN camion c ON r.camion_targa = c.targa " +
                     "JOIN autista a ON r.autista_id = a.id";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                camion c = new camion(rs.getString("targa"), rs.getString("modello"));

                autista a = new autista(rs.getInt("autista_id"),rs.getString("nome"),rs.getString("username"),rs.getString("password"));

                ritiro r = new ritiro(rs.getInt("ID"),a,rs.getString("data"),rs.getDouble("peso"),c);
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Elimina ritiro per ID
    public void cancella(int ID) {
        String sql = "DELETE FROM ritiro WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
