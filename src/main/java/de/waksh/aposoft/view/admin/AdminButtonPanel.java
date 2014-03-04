package de.waksh.aposoft.view.admin;

import javax.swing.JButton;
import javax.swing.JPanel;

import lombok.Getter;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * Panel for navigation inside the admin menu
 * 
 * @author Christoph Mende
 * 
 */
public class AdminButtonPanel {

    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private JPanel panel;

    @Getter
    private JButton btnRolesPerms;
    @Getter
    private JButton btnLog;
    @Getter
    private JButton btnBranch;
    @Getter
    private JButton btnUserMgmt;
    @Getter
    private JButton btnEmplMgmt;
    @Getter
    private JButton btnProdGrp;
    @Getter
    private JButton btnCstGrp;

    /**
     * Construct a new AdminButtonPanel and initialize it
     */
    public AdminButtonPanel() {
        initialize();
    }

    private void initialize() {
        btnRolesPerms = new JButton("Rollen/Rechte");
        btnLog = new JButton("Protokoll");
        btnBranch = new JButton("Filiale");
        btnUserMgmt = new JButton("Benutzerverwaltung");
        btnEmplMgmt = new JButton("Mitarbeiterverwaltung");
        btnProdGrp = new JButton("Produktgruppen");
        btnCstGrp = new JButton("Kundengruppen");

        FormLayout layout = new FormLayout("fill:pref",
                "pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref, 3dlu, pref");

        PanelBuilder builder = new PanelBuilder(layout);
        CellConstraints cc = new CellConstraints();
        builder.add(btnRolesPerms, cc.xy(1, 1));
        builder.add(btnLog, cc.xy(1, 3));
        builder.add(btnBranch, cc.xy(1, 5));
        builder.add(btnUserMgmt, cc.xy(1, 7));
        builder.add(btnEmplMgmt, cc.xy(1, 9));
        builder.add(btnProdGrp, cc.xy(1, 11));
        builder.add(btnCstGrp, cc.xy(1, 13));
        panel = builder.getPanel();
    }

}
