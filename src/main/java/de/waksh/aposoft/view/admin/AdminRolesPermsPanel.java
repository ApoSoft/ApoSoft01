package de.waksh.aposoft.view.admin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import lombok.Getter;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import de.waksh.aposoft.domain.Role;

/**
 * Administration panel for roles and permissions
 * 
 * @author Christoph Mende
 * 
 */
public class AdminRolesPermsPanel {

    @Getter
    private JPanel panel;

    @Getter
    private JList<Role> rolesList;
    @Getter
    private JButton btnRoleAdd;
    @Getter
    private JButton btnRoleRemove;

    @Getter
    private JTextField txtId;
    @Getter
    private JTextField txtName;
    @Getter
    private JTextArea txtDescr;
    @Getter
    private JComboBox<Object> comboCreatedFor;

    /**
     * Construct a new AdminRolesPermsPanel and initialize it
     */
    public AdminRolesPermsPanel() {
        initialize();
    }

    private void initialize() {
        CellConstraints cc = new CellConstraints();
        FormLayout layout = new FormLayout("3dlu, pref, 3dlu, fill:pref, 3dlu", "fill:pref");

        panel = new JPanel(layout);

        JPanel rolePanel = new JPanel(new BorderLayout());

        rolesList = new JList<>();
        rolesList.setPreferredSize(new Dimension(200, 150));

        JScrollPane scrollPane = new JScrollPane(rolesList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        rolePanel.add(scrollPane, BorderLayout.NORTH);

        btnRoleAdd = new JButton("+ Rolle");
        rolePanel.add(btnRoleAdd, BorderLayout.WEST);
        btnRoleRemove = new JButton("- Rolle");
        rolePanel.add(btnRoleRemove, BorderLayout.EAST);

        panel.add(rolePanel, cc.xy(2, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(350, 200));

        tabbedPane.add("Beschreibung", buildDescriptionTab());
        tabbedPane.add("Aktionen", buildActionsTab());
        tabbedPane.add("Recht", buildPermissionTab());

        panel.add(tabbedPane, cc.xy(4, 1));
    }

    private Component buildDescriptionTab() {
        FormLayout layout = new FormLayout("l:p, $lcgap, p:g");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);

        txtId = new JTextField();
        txtName = new JTextField();
        txtDescr = new JTextArea(2, 0);
        comboCreatedFor = new JComboBox<>();

        builder.append("ID", txtId);
        builder.append("Bezeichnung", txtName);
        builder.append("Beschreibung", txtDescr);
        builder.append("angelegt für", comboCreatedFor);

        return builder.getPanel();
    }

    private Component buildActionsTab() {
        return null;
    }

    private Component buildPermissionTab() {
        return null;
    }

}
