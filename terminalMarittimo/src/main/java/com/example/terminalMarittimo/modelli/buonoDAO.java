package com.example.terminalMarittimo.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.terminalMarittimo.classiEntita.buono;
import com.example.terminalMarittimo.classiEntita.polizza;

public class buonoDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserimento buono
    public void inserisci(String data, double peso, int polizzaID) {
        String sql = "INSERT INTO buono (data, peso, polizza) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, data);
            stmt.setDouble(2, peso);
            stmt.setInt(3, polizzaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizzazione buoni
    public List<buono> visualizza() {
        List<buono> lista = new ArrayList<>();
        String sql = "SELECT b.*, p.ID as polizza_ID, p.data as polizza_data, p.merce, p.peso as polizza_peso " +
                     "FROM buono b " +
                     "JOIN polizza p ON b.polizza = p.ID";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                polizza p = new polizza(
                    rs.getInt("polizza"),
                    null, // cliente (non caricato qui)
                    rs.getString("polizza_data"),
                    rs.getString("merce"),
                    rs.getDouble("polizza_peso"),
                    null  // viaggio (non caricato qui)
                );

                buono b = new buono(
                    rs.getInt("ID"),
                    rs.getString("data"),
                    rs.getDouble("peso"),
                    p
                );
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Eliminazione buono
    public void cancella(int ID) {
        String sql = "DELETE FROM buono WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserisciRichiesta(int idCliente, int idPolizza, float peso) 
    {
        try (Connection conn = DriverManager.getConnection(url, user,password)) {
            String sql = "INSERT INTO buono (cliente, polizza, peso) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idPolizza);
            stmt.setFloat(3, peso);
            stmt.executeUpdate();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
