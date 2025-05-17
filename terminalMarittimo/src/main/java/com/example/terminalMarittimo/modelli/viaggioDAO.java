package com.example.terminalMarittimo.modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    public void inserisci(String dataArrivo, String dataPartenza,int naveID, int portoArrivoID, int portoPartenzaID) {
        String sql = "INSERT INTO viaggio (porto_partenza, porto_arrivo, data_arrivo, data_partenza, nave) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(3, dataArrivo);
            stmt.setString(4, dataPartenza);
            stmt.setInt(5, naveID);
            stmt.setInt(2, portoArrivoID);
            stmt.setInt(1, portoPartenzaID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Visualizzazione viaggi
    public ArrayList<viaggio> visualizza() {
    ArrayList<viaggio> lista = new ArrayList<>();

    String sql = "SELECT " +
             "v.ID AS viaggio_id, v.data_arrivo, v.data_partenza, " +
             "n.ID AS nave_id, n.nome AS nave_nome, n.tipo AS nave_tipo, " +
             "pa.ID AS porto_arrivo_id, pa.nome AS porto_arrivo_nome, pa.rotta AS porto_arrivo_rotta, pa.nazione AS porto_arrivo_nazione, " +
             "pp.ID AS porto_partenza_id, pp.nome AS porto_partenza_nome, pp.rotta AS porto_partenza_rotta, pp.nazione AS porto_partenza_nazione " +
             "FROM viaggio v " +
             "JOIN nave n ON v.nave = n.ID " +          
             "JOIN porto pa ON v.porto_arrivo = pa.ID " +
             "JOIN porto pp ON v.porto_partenza = pp.ID";

    try (
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
    ) {
        while (rs.next()) {
            nave n = new nave(
                rs.getInt("nave_id"),
                rs.getString("nave_nome"),
                rs.getString("nave_tipo")
            );

            porto portoArrivo = new porto(
                rs.getInt("porto_arrivo_id"),
                rs.getString("porto_arrivo_nazione"),
                rs.getString("porto_arrivo_nome"),
                rs.getString("porto_arrivo_rotta")
            );

            porto portoPartenza = new porto(
                rs.getInt("porto_partenza_id"),
                rs.getString("porto_partenza_nazione"),
                rs.getString("porto_partenza_nome"),
                rs.getString("porto_partenza_rotta")
            );

            viaggio v = new viaggio(
                rs.getInt("viaggio_id"),
                rs.getString("data_arrivo"),
                rs.getString("data_partenza"),
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
