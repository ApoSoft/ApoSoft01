/**
 * 
 */
package de.waksh.aposoft.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import de.waksh.aposoft.domain.Role;
import de.waksh.aposoft.repository.RoleRepository;
import de.waksh.aposoft.view.admin.AdminButtonPanel;
import de.waksh.aposoft.view.admin.AdminRolesPermsPanel;

/**
 * Controller for the administration panel.
 * 
 * @author Christoph Mende
 * 
 */
@Component
public class AdminController {

    @Autowired
    private MainController mainController;

    @Autowired
    private RoleRepository roleRepository;

    private AdminButtonPanel buttonPanel;
    private AdminRolesPermsPanel rolesPermsPanel;

    @Getter
    private JPanel selected;

    private ActionListener rolesPermsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            selected = rolesPermsPanel.getPanel();
            mainController.setCenter(selected);
        }
    };

    public AdminController() {
        rolesPermsPanel = new AdminRolesPermsPanel();
        buttonPanel = new AdminButtonPanel();
        buttonPanel.getBtnRolesPerms().addActionListener(rolesPermsListener);
        selected = rolesPermsPanel.getPanel();
    }

    @PostConstruct
    private void postConstruct() {
        initializeRolesPermsPanel();
    }

    public JPanel getButtonPanel() {
        return buttonPanel.getPanel();
    }

    private void initializeRolesPermsPanel() {
        rolesPermsPanel = new AdminRolesPermsPanel();
        List<Role> roles = Lists.newArrayList(roleRepository.findAll());
        rolesPermsPanel.getRolesList().setListData(new Vector<Role>(roles));
    }

}
