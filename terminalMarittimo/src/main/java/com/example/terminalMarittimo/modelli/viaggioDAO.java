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
import com.example.terminalMarittimo.classiEntita.nave;
import com.example.terminalMarittimo.classiEntita.porto;
import com.example.terminalMarittimo.classiEntita.viaggio;

public class viaggioDAO {
    private final String url = "jdbc:mysql://localhost:3306/terminal_marittimo";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserimento viaggio
    public void inserisci(String dataArrivo, String dataPartenza,
                          int fornitoreID, int naveID, int portoArrivoID, int portoPartenzaID) {
        String sql = "INSERT INTO viaggio (data_arrivo, data_partenza, fornitore_id, nave_id, porto_arrivo_id, porto_partenza_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dataArrivo);
            stmt.setString(2, dataPartenza);
            stmt.setInt(3, fornitoreID);
            stmt.setInt(4, naveID);
            stmt.setInt(5, portoArrivoID);
            stmt.setInt(6, portoPartenzaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizzazione viaggi
    public List<viaggio> visualizza() {
        List<viaggio> lista = new ArrayList<>();
        String sql = "SELECT v.*, f.id AS fornitore_id, f.nome AS fornitore_nome, f.cognome, f.email, f.telefono, f.password, " +
                     "n.id AS nave_id, n.nome AS nave_nome, n.tipologia, " +
                     "pa.id AS porto_arrivo_id, pa.nome AS porto_arrivo_nome, pa.rotta, pa.nazione, " +
                     "pp.id AS porto_partenza_id, pp.nome AS porto_partenza_nome, pp.rotta, pp.nazione " +
                     "FROM viaggio v " +
                     "JOIN fornitore f ON v.fornitore_id = f.id " +
                     "JOIN nave n ON v.nave_id = n.id " +
                     "JOIN porto pa ON v.porto_arrivo_id = pa.id " +
                     "JOIN porto pp ON v.porto_partenza_id = pp.id";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornitore f = new fornitore(rs.getInt("fornitore_id"),rs.getString("fornitore_nome"), rs.getString("cognome"),
                    rs.getString("email"),
                    rs.getString("telefono"),
                    rs.getString("password")
                );

                nave n = new nave(
                    rs.getInt("nave_id"),
                    rs.getString("tipologia"),
                    rs.getString("nave_nome")
                );

                porto portoArrivo = new porto(
                    rs.getInt("porto_arrivo_id"),
                    rs.getString("porto_arrivo_nome"),
                    rs.getString("rotta"),
                    rs.getString("nazione")
                );

                porto portoPartenza = new porto(
                    rs.getInt("porto_partenza_id"),
                    rs.getString("porto_partenza_nome"),
                    rs.getString("rotta"),
                    rs.getString("nazione")
                );

                viaggio v = new viaggio(
                    rs.getInt("ID"),
                    rs.getString("data_arrivo"),
                    rs.getString("data_partenza"),
                    f,
                    n,
                    portoArrivo,
                    portoPartenza
                );

                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Cancellazione viaggio
    public void cancella(int ID) {
        String sql = "DELETE FROM viaggio WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
