package parkiran;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hitung {
    public long hitungSelisihWaktu(String jamMasuk, String jamKeluar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date dateJamMasuk = dateFormat.parse(jamMasuk);
            Date dateJamKeluar = dateFormat.parse(jamKeluar);
            return dateJamKeluar.getTime() - dateJamMasuk.getTime();
        } catch (ParseException ex) {
            Logger.getLogger(SiteKeluar.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int hitungHargaParkir(long selisihWaktuMillis, String jenisKendaraan) {
        int tarifMinimum = 0;
        int tarifPerJam = 0;

        if (jenisKendaraan.equals("Motor")) {
            tarifMinimum = 2000;
            tarifPerJam = 2000;
        } else if (jenisKendaraan.equals("Mobil")) {
            tarifMinimum = 3000;
            tarifPerJam = 3000;
        }

        long selisihJam = selisihWaktuMillis / (60 * 60 * 1000);
        return Math.max((int) selisihJam * tarifPerJam, tarifMinimum);
    }
}
