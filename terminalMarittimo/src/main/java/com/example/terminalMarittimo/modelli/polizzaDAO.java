package com.example.terminalMarittimo.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.terminalMarittimo.classiEntita.cliente;
import com.example.terminalMarittimo.classiEntita.fornitore;
import com.example.terminalMarittimo.classiEntita.nave;
import com.example.terminalMarittimo.classiEntita.polizza;
import com.example.terminalMarittimo.classiEntita.porto;
import com.example.terminalMarittimo.classiEntita.viaggio;

public class polizzaDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserimento
    public void inserisci(int clienteID, String data, String merce, double peso, int viaggioID,int fornitoreID) {
        String sql = "INSERT INTO polizza (viaggio, peso, data, merce, cliente,fornitore) VALUES (?, ?, ?, ?, ?,?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(5, clienteID);
            stmt.setString(3, data);
            stmt.setString(4, merce);
            stmt.setDouble(2, peso);
            stmt.setInt(1, viaggioID);
            stmt.setInt(6, fornitoreID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizzazione
  public ArrayList<polizza> visualizza() {
    ArrayList<polizza> lista = new ArrayList<>();

    String sql = "SELECT p.*, " +
                 "c.ID AS cliente_id, c.nome AS cliente_nome, c.cognome AS cliente_cognome, " +
                 "c.mail AS cliente_email, c.tel AS cliente_telefono, c.indirizzo AS cliente_indirizzo, c.password AS cliente_password, " +
                 "v.ID AS viaggio_id, v.data_partenza, v.data_arrivo, " +
                 "pp.ID AS porto_partenza_id, pp.nome AS porto_partenza_nome, " +
                 "pa.ID AS porto_arrivo_id, pa.nome AS porto_arrivo_nome, " +
                 "n.ID AS nave_id, n.nome AS nave_nome, " +
                 "f.ID AS fornitore_id, f.nome AS fornitore_nome, f.cognome AS fornitore_cognome, " +
                 "f.mail AS fornitore_email, f.tel AS fornitore_telefono, f.password AS fornitore_password " +
                 "FROM polizza p " +
                 "JOIN cliente c ON p.cliente = c.ID " +
                 "JOIN viaggio v ON p.viaggio = v.ID " +
                 "JOIN porto pp ON v.porto_partenza = pp.ID " +
                 "JOIN porto pa ON v.porto_arrivo = pa.ID " +
                 "JOIN nave n ON v.nave = n.ID " +
                 "JOIN fornitore f ON p.fornitore = f.ID";

    try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {

            cliente c = new cliente(
                rs.getInt("cliente_id"),
                rs.getString("cliente_nome"),
                rs.getString("cliente_cognome"),
                rs.getString("cliente_email"),
                rs.getString("cliente_telefono"),
                rs.getString("cliente_indirizzo"),
                rs.getString("cliente_password")
            );

            porto portoPartenza = new porto(
                rs.getInt("porto_partenza_id"),
                null,
                rs.getString("porto_partenza_nome"),
                null
            );

            porto portoArrivo = new porto(
                rs.getInt("porto_arrivo_id"),
                null,
                rs.getString("porto_arrivo_nome"),
                null
            );

            nave n = new nave(
                rs.getInt("nave_id"),
                rs.getString("nave_nome"),
                null
            );

            viaggio v = new viaggio(
                rs.getInt("viaggio_id"),
                rs.getString("data_arrivo"),
                rs.getString("data_partenza"),
                n,
                portoArrivo,
                portoPartenza 
            );

            fornitore f = new fornitore(
                rs.getInt("fornitore_id"),
                rs.getString("fornitore_nome"),
                rs.getString("fornitore_cognome"),
                rs.getString("fornitore_email"),
                rs.getString("fornitore_telefono"),
                rs.getString("fornitore_password")
            );

            polizza p = new polizza(
                rs.getInt("ID"),
                c,
                rs.getString("data"),
                rs.getString("merce"),
                rs.getDouble("peso"),
                v,
                f
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
