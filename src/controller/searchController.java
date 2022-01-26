package controller;

import Model.searchModel;
import object.penumpang;
import view.hasilPencarianView;
import view.searchView;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchController implements ActionListener {
    searchView s;
    hasilPencarianView h;
    penumpang p;
    searchModel sModel;

    public searchController(penumpang p) {
        s = new searchView();
        sModel = new searchModel();
        this.p = p;
        s.addListener(this);
        s.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ae = e.getSource();
        if(ae == s.getBtnCari()){
            if (s.getCbstasiunawal().getSelectedItem().equals("Pilih") ||
            s.getCbstasiunAkhir().getSelectedItem().equals("Pilih") ||
            s.getCbTanggal().getSelectedItem().equals("Pilih") ||
            s.getCbBulan().getSelectedItem().equals("Pilih") ||
            s.getCbTahun().getSelectedItem().equals("Pilih")){
                JOptionPane.showMessageDialog(s, "Tidak boleh ada data yang kosong");
            } else if (s.getCbstasiunawal().getSelectedItem().equals(s.getCbstasiunAkhir().getSelectedItem())){
                JOptionPane.showMessageDialog(s, "Stasiun awal dan akhir tidak bisa sama");
            } else {
                h = new hasilPencarianView();
                String tanggalSearch = s.getCbTahun().getSelectedItem()+"-"+s.getCbBulan().getSelectedItem()+"-"+s.getCbTanggal().getSelectedItem();
                TableModel model = sModel.showSearchResult(s, h.getTable().getModel());
                new hasilPencarianController(p, model, tanggalSearch);
                s.dispose();
            }
        } else if (ae == s.getBtnBack()){
            new menuController(p);
            s.dispose();
        }
    }
}
