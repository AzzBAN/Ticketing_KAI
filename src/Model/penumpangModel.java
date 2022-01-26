package Model;

import object.getObject;
import object.kereta;
import object.penumpang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class penumpangModel implements getObject {
    private koneksi conn;
    private Statement stmt;
    private String username, password;

    public penumpangModel() {
        this.conn = new koneksi();
        conn.bikinKoneksi();
    }

    public boolean loginValidasi(String u, String p){
        try{
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM penumpang WHERE username = '"+u+"' AND password = '"+p+"' ";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next() && rs!=null){
                username = rs.getString("username");
                password = rs.getString("password");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public TableModel tiketPenumpang(TableModel table, penumpang p){
        DefaultTableModel model = (DefaultTableModel) table;
        ArrayList<kereta> list = new ArrayList<>();
        kereta k;
        String namaPenumpang = p.getNama();
        try {
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM tiketTerpesan WHERE namaPenumpang = '"+namaPenumpang+"' ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String nama = rs.getString("kereta");
                String jenis = rs.getString("jenis");
                String rute = rs.getString("rute");
                String id;
                if (jenis.equals("ekonomi")) {
                    String[] split = rute.split("-");
                    id = "EKM-"+split[0].substring(0,1)+split[1].substring(0,1)+"-"+rs.getString("id");
                } else if (jenis.equals("eksekutif")){
                    String[] split = rute.split("-");
                    id = "ESF-"+split[0].substring(0,1)+split[1].substring(0,1)+"-"+rs.getString("id");
                } else {
                    String[] split = rute.split("-");
                    id = "BSS-"+split[0].substring(0,1)+split[1].substring(0,1)+"-"+rs.getString("id");
                }
                String berangkat = rs.getString("berangkat");
                String tiba = rs.getString("tiba");
//                int durasi = Integer.parseInt(rs.getString("tiba").substring(0, 2))-Integer.parseInt(rs.getString("berangkat").substring(0, 2));
                String kursi = rs.getString("kursi")+" Tersedia";
                String harga = rs.getString("harga");
                k = new kereta(id, nama, jenis, rute, berangkat, tiba, kursi, harga);
                list.add(k);
            }
            Object rowData[] = new Object[8];
            for (int i = 0; i < list.size(); i++){
                rowData[0] = list.get(i).getNama();
                rowData[1] = list.get(i).getJenis();
                rowData[2] = list.get(i).getRute();
                rowData[3] = list.get(i).getBerangkat()+"-"+list.get(i).getTiba();
                int durasi = Integer.parseInt(list.get(i).getTiba().substring(0, 2)) - Integer.parseInt(list.get(i).getBerangkat().substring(0, 2));
                rowData[4] = durasi;
                rowData[5] = list.get(i).getJumlahKursi();
                rowData[6] = list.get(i).getHarga();
                rowData[7] = list.get(i).getId();
                model.addRow(rowData);
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void daftarPenumpang(penumpang p){
        try{
            stmt = conn.getConn().createStatement();
            String query = "INSERT INTO `penumpang` (`id`, `nama`, `username`, `password`, `email`, `nomor_hp`) VALUES (NULL, '"+p.getNama()+"', '"+p.getUsername()+"', '"+p.getPassword()+"', '"+p.getEmail()+"', '"+p.getNomor_hp()+"')";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public penumpang getPenumpang() {
        String id, nama, email, nomor_hp;
        penumpang p;
        try{
            stmt = conn.getConn().createStatement();
            String query = "SELECT * FROM penumpang WHERE username = '"+username+"' AND password = '"+password+"' ";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next() && rs!=null){
                username = rs.getString("username");
                password = rs.getString("password");
                id = rs.getString("id");
                nama = rs.getString("nama");
                email = rs.getString("email");
                nomor_hp = rs.getString("nomor_hp");
                p = new penumpang(id, nama, username, password, email, nomor_hp);
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public kereta getKereta() {
        return null;
    }
}
