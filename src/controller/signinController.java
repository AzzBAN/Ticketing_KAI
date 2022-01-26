package controller;

import Model.penumpangModel;
import object.kereta;
import object.penumpang;
import view.signinView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class signinController implements ActionListener, outputObject, KeyListener {
    signinView s;
    penumpangModel pmod;
    penumpang p;

    public signinController() {
        this.s = new signinView();
        s.setVisible(true);
        s.addListener(this);
        s.addKeyListener(this);
        pmod = new penumpangModel();
    }

    public void signIn(){
        String username = s.getTfUsername().getText();
        String password = String.valueOf(s.getTfPassword().getPassword());
        boolean login;
        if (username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(s, "Tidak Boleh kosong");
        } else {
            login = pmod.loginValidasi(username, password);
            if (login){
                p = pmod.getPenumpang();
                printPenumpang(p);
                JOptionPane.showMessageDialog(s, "Proses Sign in Berhasil");
                new menuController(p);
                s.dispose();
            } else {
                System.out.println("Login GAGAL!! || username/password salah");
                JOptionPane.showMessageDialog(s, "username password salah");
                new signinController();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ae = e.getSource();
        if(ae == s.getBtnSignin()){
            signIn();
        } else if (ae == s.getBtnSignUp()){
            new signupController();
            s.dispose();
        }
    }

    @Override
    public void printPenumpang(penumpang p) {
        System.out.println("====Info login====");
        System.out.println("ID Penumpang\t: "+p.getId());
        System.out.println("Nama\t\t\t: "+p.getNama());
        System.out.println("Username\t\t: "+p.getUsername());
        System.out.println("Password\t\t: "+p.getPassword());
        System.out.println("Email\t\t\t: "+p.getEmail());
        System.out.println("Nomor HP\t\t: "+p.getNomor_hp());
    }

    @Override
    public void printKereta(kereta k) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            signIn();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
