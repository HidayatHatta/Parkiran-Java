package DataBase;
import java.sql.*;
import javax.swing.JOptionPane;

public class KoneksiDatabase {
    public static Connection bukaKoneksi() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/parkiran", "root", "");
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi data tidak tersambung", "DataBase", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}