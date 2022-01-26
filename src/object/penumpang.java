package object;

public class penumpang {
    private String id, nama, username, password, email, nomor_hp;

    public penumpang(String id, String nama, String username, String password, String email, String nomor_hp) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nomor_hp = nomor_hp;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomor_hp() {
        return nomor_hp;
    }

    public void setNomor_hp(String nomor_hp) {
        this.nomor_hp = nomor_hp;
    }
}
