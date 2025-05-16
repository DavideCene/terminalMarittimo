package com.example.terminalMarittimo.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.terminalMarittimo.classiEntita.cliente;
import com.example.terminalMarittimo.classiEntita.polizza;
import com.example.terminalMarittimo.classiEntita.viaggio;

public class polizzaDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserimento
    public void inserisci(int clienteID, String data, String merce, double peso, int viaggioID) {
        String sql = "INSERT INTO polizza (viaggio, peso, data, merce, cliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(5, clienteID);
            stmt.setString(3, data);
            stmt.setString(4, merce);
            stmt.setDouble(2, peso);
            stmt.setInt(1, viaggioID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizzazione
    public ArrayList<polizza> visualizza() {
        ArrayList<polizza> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.ID AS cliente_id, c.nome AS cliente_nome, c.cognome AS cliente_cognome, " +
                     "v.ID AS viaggio, v.data_partenza, v.data_arrivo " +
                     "FROM polizza p " +
                     "JOIN cliente c ON p.cliente = c.ID " +
                     "JOIN viaggio v ON p.viaggio = v.ID";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cliente c = new cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("cliente_nome"),
                        rs.getString("cliente_cognome"),
                        null, null, null, null
                );

                viaggio v = new viaggio(
                        rs.getInt("viaggio_id"),
                        rs.getString("data_arrivo"),
                        rs.getString("data_partenza"),
                        null, null, null, null
                );

                polizza p = new polizza(
                        rs.getInt("ID"),
                        c,
                        rs.getString("data"),
                        rs.getString("merce"),
                        rs.getDouble("peso"),
                        v
                );

                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Eliminazione
    public void cancella(int ID) {
        String sql = "DELETE FROM polizza WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
