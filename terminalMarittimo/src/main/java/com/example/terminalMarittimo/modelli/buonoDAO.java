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
import com.example.terminalMarittimo.classiEntita.cliente;
import com.example.terminalMarittimo.classiEntita.fornitore;
import com.example.terminalMarittimo.classiEntita.nave;
import com.example.terminalMarittimo.classiEntita.polizza;
import com.example.terminalMarittimo.classiEntita.viaggio;

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
String sql = 
            "SELECT b.ID as buono_id, b.data as buono_data, b.peso as buono_peso, " +
            "       p.ID as polizza_ID, p.data as polizza_data, p.merce, p.peso as polizza_peso, " +
            "       v.ID as viaggio_id, v.data_partenza, v.data_arrivo, " +
            "       n.ID as nave_id, n.nome as nave_nome, " +
            "       c.ID as cliente_id, c.nome as cliente_nome, c.cognome as cliente_cognome, c.mail as cliente_mail, " +
            "       f.ID as fornitore_id, f.nome as fornitore_nome, f.cognome as fornitore_cognome, " +
            "       f.mail as fornitore_mail, f.tel as fornitore_tel, f.password as fornitore_password " +
            "FROM buono b " +
            "JOIN polizza p ON b.polizza = p.ID " +
            "JOIN viaggio v ON p.viaggio = v.ID " +
            "JOIN nave n ON v.nave = n.ID " +
            "JOIN cliente c ON p.cliente = c.ID " +
            "JOIN fornitore f ON p.fornitore = f.ID";

    try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {

            nave naveObj = new nave(rs.getInt("nave_id"), rs.getString("nave_nome"),null);

            viaggio viaggioObj = new viaggio(
                rs.getInt("viaggio_id"),
                rs.getString("data_arrivo"),
                rs.getString("data_partenza"),
                naveObj,
                null,
                null
            );

            cliente clienteObj = new cliente(
                rs.getInt("cliente_id"),
                rs.getString("cliente_nome"),
                rs.getString("cliente_cognome"),
                rs.getString("cliente_mail"),
                null,
                null,
                null
            );

            fornitore fornitoreObj = new fornitore(
                rs.getInt("fornitore_id"),
                rs.getString("fornitore_nome"),
                rs.getString("fornitore_cognome"),
                rs.getString("fornitore_mail"),
                null, // telefono
                null  // password
            );

            polizza polizzaObj = new polizza(
                rs.getInt("polizza_ID"),
                clienteObj,                   
                rs.getString("polizza_data"),
                rs.getString("merce"),
                rs.getDouble("polizza_peso"),
                viaggioObj,                 
                fornitoreObj
            );
            buono buonoObj = new buono(
                rs.getInt("buono_id"),
                rs.getString("buono_data"),
                rs.getDouble("buono_peso"),
                polizzaObj
            );

            lista.add(buonoObj);
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
