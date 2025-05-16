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
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Inserimento viaggio
    public void inserisci(String dataArrivo, String dataPartenza,
                          int fornitoreID, int naveID, int portoArrivoID, int portoPartenzaID) {
        String sql = "INSERT INTO viaggio (fornitore, porto_partenza, porto_arrivo, data_arrivo, data_partenza, nave) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(4, dataArrivo);
            stmt.setString(5, dataPartenza);
            stmt.setInt(1, fornitoreID);
            stmt.setInt(6, naveID);
            stmt.setInt(3, portoArrivoID);
            stmt.setInt(2, portoPartenzaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizzazione viaggi
    public List<viaggio> visualizza() {
        List<viaggio> lista = new ArrayList<>();
        String sql = "SELECT v.*, f.ID AS fornitore_id, f.nome AS fornitore_nome, f.cognome, f.mail, f.tel, f.password, " +
                     "n.ID AS nave_id, n.nome AS nave_nome, n.tipo, " +
                     "pa.ID AS porto_arrivo_id, pa.nome AS porto_arrivo_nome, pa.rotta, pa.nazione, " +
                     "pp.ID AS porto_partenza_id, pp.nome AS porto_partenza_nome, pp.rotta, pp.nazione " +
                     "FROM viaggio v " +
                     "JOIN fornitore f ON v.fornitore_id = f.ID " +
                     "JOIN nave n ON v.nave_id = n.ID " +
                     "JOIN porto pa ON v.porto_arrivo_id = pa.ID " +
                     "JOIN porto pp ON v.porto_partenza_id = pp.ID";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornitore f = new fornitore(rs.getInt("fornitore_id"),rs.getString("fornitore_nome"), rs.getString("cognome"),
                    rs.getString("mail"),
                    rs.getString("tel"),
                    rs.getString("password")
                );

                nave n = new nave(
                    rs.getInt("nave_id"),
                    rs.getString("tipo"),
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
