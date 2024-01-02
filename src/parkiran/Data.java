/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkiran;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Data {
    
    Connection cn = DataBase.KoneksiDatabase.bukaKoneksi();
    
    public Data(Connection connection){
        this.cn = connection;
    }
    
    public boolean isNomorPlatExist(String nomorPlat) {
        String query = "SELECT COUNT(*) FROM data WHERE plat = ?";
        try (PreparedStatement preparedStatement = cn.prepareStatement(query)) {
            preparedStatement.setString(1, nomorPlat);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Mengembalikan true jika nomor plat sudah ada
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiteMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean insertData(String nomorPlat, String jenisKendaraan, String waktu) {
        String sql = "INSERT INTO data (plat, kendaraan, masuk) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
            preparedStatement.setString(1, nomorPlat);
            preparedStatement.setString(2, jenisKendaraan);
            preparedStatement.setString(3, waktu);
            preparedStatement.executeUpdate();
            return true; // Berhasil menyimpan data
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Gagal menyimpan data
        }
    }
    
    public void hapusData(String nomorPlat) {
        try {
            String deleteQuery = "DELETE FROM data WHERE plat = ?";
            try (PreparedStatement preparedStatement = cn.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, nomorPlat);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {       
        }
    }
    
    public ResultSet getDataByNomorPlat(String nomorPlat) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = cn.prepareStatement("SELECT * FROM data WHERE plat = ?");
            preparedStatement.setString(1, nomorPlat);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
}
