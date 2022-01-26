package object;

public class kereta {
    private String id, nama, jenis, rute, berangkat, tiba, jumlahKursi, harga;

    public kereta(String id, String nama, String jenis, String rute, String berangkat, String tiba, String jumlahKursi, String harga) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.rute = rute;
        this.berangkat = berangkat;
        this.tiba = tiba;
        this.jumlahKursi = jumlahKursi;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public String getBerangkat() {
        return berangkat;
    }

    public void setBerangkat(String berangkat) {
        this.berangkat = berangkat;
    }

    public String getTiba() {
        return tiba;
    }

    public void setTiba(String tiba) {
        this.tiba = tiba;
    }

    public String getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(String jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
