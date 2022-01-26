package object;

public class tiket {
    private String id, namaPenumpang, kereta, jenis, rute,  tanggal, berangkat, tiba, kursi, harga;

    public tiket(String id, String namaPenumpang, String kereta, String jenis, String rute, String tanggal, String berangkat, String tiba, String kursi, String harga) {
        this.id = id;
        this.namaPenumpang = namaPenumpang;
        this.kereta = kereta;
        this.jenis = jenis;
        this.rute = rute;
        this.tanggal = tanggal;
        this.berangkat = berangkat;
        this.tiba = tiba;
        this.kursi = kursi;
        this.harga = harga;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    public void setNamaPenumpang(String namaPenumpang) {
        this.namaPenumpang = namaPenumpang;
    }

    public String getKereta() {
        return kereta;
    }

    public void setKereta(String kereta) {
        this.kereta = kereta;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
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

    public String getKursi() {
        return kursi;
    }

    public void setKursi(String kursi) {
        this.kursi = kursi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
