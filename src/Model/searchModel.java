package Model;

import controller.outputObject;
import object.*;
import view.searchView;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.io.ObjectStreamException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class searchModel implements outputObject {
    private koneksi conn;
    private Statement stmtKereta, stmtJadwal, stmtTiket;

    public searchModel() {
        this.conn = new koneksi();
        conn.bikinKoneksi();
    }

//    public boolean jadwalValidasi(ResultSet rsJadwal, ResultSet rsKereta){
//        String
//        return false;
//    }

    public TableModel showSearchResult(searchView s, TableModel t){
        kereta k;
        DefaultTableModel model = (DefaultTableModel) t;
        ArrayList<kereta> list = new ArrayList<>();
        String tanggalSearch = s.getCbTahun().getSelectedItem()+"-"+s.getCbBulan().getSelectedItem()+"-"+s.getCbTanggal().getSelectedItem();
        String asalSearch = (String) s.getCbstasiunawal().getSelectedItem();
        String akhirSearch = (String) s.getCbstasiunAkhir().getSelectedItem();
        String tujuanPenumpang = asalSearch+"-"+akhirSearch;
        int kursiPenumpang = Integer.parseInt((String) s.getCbJumlahPenumpang().getSelectedItem());
        ResultSet rsKereta, rsTiket, rsJadwal;
        try{
            int maxKursi, kursi = 0;
            stmtKereta = conn.getConn().createStatement();
            stmtJadwal = conn.getConn().createStatement();
            stmtTiket = conn.getConn().createStatement();
            String queryKereta = "SELECT * FROM kereta WHERE stasiunAsal = '"+asalSearch+"' AND stasiunAkhir = '"+akhirSearch+"' ";
            String queryTiket = "SELECT * FROM tiketTerpesan";
            String queryJadwal = "SELECT * FROM jadwal";
            rsKereta = stmtKereta.executeQuery(queryKereta);
            while (rsKereta.next()){
                maxKursi = rsKereta.getInt("jumlahKursi");
                String idKereta = rsKereta.getString(1);
                String namaKereta = rsKereta.getString("nama");
                String tujuanKereta = rsKereta.getString("stasiunAsal")+"-"+rsKereta.getString("stasiunAkhir");
                String jenisKereta = rsKereta.getString("jenis");
                String hargaKereta = rsKereta.getString("harga");
                rsJadwal = stmtJadwal.executeQuery(queryJadwal);
                while (rsJadwal.next()){
                    String jadwalBerangkat = rsJadwal.getString(1);
                    String jadwalTiba = rsJadwal.getString(2);
                    String jadwal = jadwalBerangkat+"-"+jadwalTiba;
                    rsTiket = stmtTiket.executeQuery(queryTiket);
                    while (rsTiket.next()){
                        String kereta = rsTiket.getString("kereta");
                        String tanggalTiket = rsTiket.getString("tanggal");
                        String berangkatTiba = rsTiket.getString("berangkat")+"-"+rsTiket.getString("tiba");
                        String jenisTiket = rsTiket.getString("jenis");
                        int kursiTiket = rsTiket.getInt("kursi");
                        System.out.println(kereta+"="+namaKereta);
                        System.out.println(tanggalSearch+"="+tanggalTiket);
                        System.out.println(tujuanKereta+"="+tujuanPenumpang);
                        System.out.println(jenisTiket+"="+jenisKereta);
                        System.out.println(jadwal+"="+berangkatTiba);
                        if (kereta.equals(namaKereta) && tanggalSearch.equals(tanggalTiket) && tujuanKereta.equals(tujuanPenumpang) && jenisKereta.equals(jenisTiket) && jadwal.equals(berangkatTiba)){
//                            if(jadwal.equals(berangkatTiba)){
//                                kursi = kursi + kursiTiket;
//                            }
                            kursi = kursi + kursiTiket;
                        }
                    }
                    kursi = kursi + kursiPenumpang;
                    System.out.println(kursi);
                    System.out.println(maxKursi);
                    if (kursi <= maxKursi && kursiPenumpang <= maxKursi){
                        System.out.println("true");
                        if (jenisKereta.equals("eksekutif")){
                            k = new keretaEksekutif(idKereta, namaKereta,
                                    jenisKereta,
                                    tujuanKereta,
                                    jadwalBerangkat,
                                    jadwalTiba,
                                    (String) s.getCbJumlahPenumpang().getSelectedItem() + " Tersedia",
                                    hargaKereta);
                        } else if (jenisKereta.equals("ekonomi")){
                            k = new keretaEkonomi(idKereta, namaKereta,
                                    jenisKereta,
                                    tujuanKereta,
                                    jadwalBerangkat,
                                    jadwalTiba,
                                    (String) s.getCbJumlahPenumpang().getSelectedItem()+ " Tersedia",
                                    hargaKereta);
                        } else if (jenisKereta.equals("bisnis")){
                            k = new keretaBisnis(idKereta, namaKereta,
                                    jenisKereta,
                                    tujuanKereta,
                                    jadwalBerangkat,
                                    jadwalTiba,
                                    (String) s.getCbJumlahPenumpang().getSelectedItem()+ " Tersedia",
                                    hargaKereta);
                        } else {
                            k = null;
                        }
                        list.add(k);
                        // masukkin hasil pencarian dari kereta tersebut ke arraylist
                    }
                    kursi = 0;
                }
            }
            Object rowData[] = new Object[7];
            for (int i = 0; i < list.size(); i++){
                rowData[0] = list.get(i).getNama();
                rowData[1] = list.get(i).getJenis();
                rowData[2] = list.get(i).getRute();
                rowData[3] = list.get(i).getBerangkat()+"-"+list.get(i).getTiba();
                int durasi = Integer.parseInt(list.get(i).getTiba().substring(0, 2)) - Integer.parseInt(list.get(i).getBerangkat().substring(0, 2));
                rowData[4] = durasi;
                rowData[5] = list.get(i).getJumlahKursi();
                rowData[6] = list.get(i).getHarga();
                System.out.println("\n====Info Kereta===="+i);
                printKereta(list.get(i));
                model.addRow(rowData);
            }
            return model;
            // masukkin hasil arraylist ke tabelmodel
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void printPenumpang(penumpang p) {

    }

    @Override
    public void printKereta(kereta k) {
        System.out.println("ID Kereta\t\t: "+k.getId());
        System.out.println("Nama Kereta\t: "+k.getNama());
        System.out.println("Jenis\t\t\t: "+k.getJenis());
        System.out.println("Rute\t\t\t: "+k.getRute());
        System.out.println("Berangkat\t\t: "+k.getBerangkat());
        System.out.println("Tiba\t\t\t: "+k.getTiba());
        System.out.println("Junlah Kursi\t: "+k.getJumlahKursi());
        System.out.println("Harga\t\t\t: "+k.getHarga());
    }
}
