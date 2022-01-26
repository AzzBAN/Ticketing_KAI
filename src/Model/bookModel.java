package Model;

import object.penumpang;
import view.hasilPencarianView;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;

public class bookModel {
    koneksi conn;
    Statement stmt;

    public bookModel() {
        this.conn = new koneksi();
        conn.bikinKoneksi();
    }

    public void bookTIket(hasilPencarianView t, penumpang p){
        JTable table = t.getTable();
        int idx = table.getSelectedRow();
        String namaKereta = (String) table.getValueAt(idx, 0);
        String jenis = (String) table.getValueAt(idx, 1);
        String rute = (String) table.getValueAt(idx, 2);
        String tanggal = t.getLabelTanggal().getText();
        String berangkat = String.valueOf(table.getValueAt(idx, 3)).substring(0, 5);
        String tiba = String.valueOf(table.getValueAt(idx, 3)).substring(6, 11);
        String kursi =  String.valueOf(table.getValueAt(idx, 5)).substring(0, 1);
        String harga = (String) table.getValueAt(idx, 6);
        try{
            stmt = conn.getConn().createStatement();
            String query = "INSERT INTO `tiketTerpesan` (`id`, `namaPenumpang`, `kereta`, `jenis`, `rute`, `tanggal`, `berangkat`, `tiba`, `kursi`, `harga`) VALUES (NULL, '"+p.getNama()+"', '"+namaKereta+"', '"+jenis+"', '"+rute+"', '"+tanggal+"', '"+berangkat+"', '"+tiba+"', '"+kursi+"', '"+harga+"');";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
