package controller;

import Model.penumpangModel;
import object.penumpang;
import view.hasilPencarianView;
import view.menuView;

import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuController implements ActionListener {
    menuView m;
    penumpang p;
    penumpangModel pmod;
    hasilPencarianView h;

    public menuController(penumpang p) {
        this.p = p;
        m = new menuView();
        m.addListener(this);
        m.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ae = e.getSource();
        if (ae == m.getBtnOrder()){
            new searchController(p);
        } else if (ae == m.getBtnTiketSaya()){
            new hasilPencarianController(p);
        } else if (ae == m.getBtnLogout()){
            new signinController();
        }
        m.dispose();
    }
}
