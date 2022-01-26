package controller;

import Model.penumpangModel;
import object.getObject;
import object.kereta;
import object.penumpang;
import view.signupView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class signupController implements ActionListener, getObject {
    signupView s;
    penumpangModel p;
    private String id, nama, username, password, email, nomor_hp;

    public signupController() {
        s = new signupView();
        p = new penumpangModel();
        s.addListener(this);
        s.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ae = e.getSource();
        if (ae == s.getBtnDaftar()){
            if (s.getLabelNama().getText().equals("") ||
            s.getLabelEmail().getText().equals("") ||
            s.getLabelNomorHp().getText().equals("") ||
            s.getLabelUsername().getText().equals("") ||
            s.getLabelPassword().getText().equals("")){
                JOptionPane.showMessageDialog(s, "Tidak boleh ada data yang kosong");
            } else {
                this.id = null;
                this.nama = s.getLabelNama().getText();
                this.username = s.getLabelUsername().getText();
                this.password = s.getLabelPassword().getText();
                this.email = s.getLabelEmail().getText();
                this.nomor_hp = s.getLabelNomorHp().getText();
                p.daftarPenumpang(getPenumpang());
                JOptionPane.showMessageDialog(s, "Proses SignUp Berhasil");
                new signinController();
                s.dispose();
            }
        } else if (ae == s.getBtnBack()){
            new signinController();
            s.dispose();
        }
    }

    @Override
    public penumpang getPenumpang() {
        penumpang p = new penumpang(id, nama, username, password, email, nomor_hp);
        return p;
    }

    @Override
    public kereta getKereta() {
        return null;
    }
}
