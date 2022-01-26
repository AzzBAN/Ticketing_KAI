package controller;

import Model.bookModel;
import Model.penumpangModel;
import Model.searchModel;
import object.penumpang;
import view.hasilPencarianView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hasilPencarianController implements ActionListener {
    hasilPencarianView h;
    penumpang p;
    bookModel b;
    penumpangModel pmod;


    public hasilPencarianController(penumpang p, TableModel tModel, String tanggal) {
        h = new hasilPencarianView();
        b = new bookModel();
        this.p = p;
        h.getLabelTanggal().setText(tanggal);
        h.getTable().setModel(tModel);
        TableColumn col = h.getTable().getColumn("idPemesanan");
        h.getTable().getColumnModel().removeColumn(col);
        h.addListener(this);
        h.setVisible(true);
    }

    public hasilPencarianController(penumpang p){
        h = new hasilPencarianView();
        this.p = p;
        pmod = new penumpangModel();
        h.getjLabel1().setText("Tiket Saya");
//        TableColumnModel col = h.getTable().getColumnModel();
//        col.removeColumn(col.getColumn(7));
        TableModel model = pmod.tiketPenumpang(h.getTable().getModel(), p);
        h.getTable().setModel(model);
        h.getBtnBook().setVisible(false);
        h.addListener(this);
        h.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object ae = e.getSource();
        if (ae == h.getBtnBook()){
            if (String.valueOf(h.getTable().getSelectedRow()).equals(null)){
                JOptionPane.showMessageDialog(h, "Anda belum memilih tiket");
            } else {
                b.bookTIket(h, p);
                JOptionPane.showMessageDialog(h, "Proses Pemesanan berhasil");
                new menuController(p);
            }
        } else if (ae == h.getBtnBack()){
            if (h.getjLabel1().getText().equals("Tiket Saya")){
                new menuController(p);
            } else {
                new searchController(p);
            }
        }
        h.dispose();
    }
}
