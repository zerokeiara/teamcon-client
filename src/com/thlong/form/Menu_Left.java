package com.thlong.form;

import com.thlong.component.Item_People;
import com.thlong.event.EventMenuLeft;
import com.thlong.event.PublicEvent;
import com.thlong.model.Model_User_Account;
import com.thlong.swing.ScrollBar;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;

public class Menu_Left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;

    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        userAccount = new ArrayList<>();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                for (Model_User_Account d : users) {
                    userAccount.add(d);
                    menuList.add(new Item_People(d), "wrap");
                    refreshMenuList();
                }
            }

            @Override
            public void userConnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
        });
        showMessage();
    }

    private void showMessage() {
        //  test data
        menuList.removeAll();
        for (Model_User_Account d : userAccount) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showBox() {
        //  test data
        menuList.removeAll();
        for (int i = 0; i < 10; i++) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void refreshMenuList() {
        menuList.repaint();
        menuList.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new com.thlong.component.MenuButton();
        menuCloud = new com.thlong.component.MenuButton();
        menuSetting = new com.thlong.component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        menu.setBackground(new java.awt.Color(229, 229, 229));
        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/message_selected.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/message.png"))); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuCloud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/cloud.png"))); // NOI18N
        menuCloud.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/cloud_selected.png"))); // NOI18N
        menuCloud.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/cloud.png"))); // NOI18N
        menuCloud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloudActionPerformed(evt);
            }
        });
        menu.add(menuCloud);

        menuSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/setting.png"))); // NOI18N
        menuSetting.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/setting_selected.png"))); // NOI18N
        menuSetting.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/thlong/icon/setting.png"))); // NOI18N
        menuSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSettingActionPerformed(evt);
            }
        });
        menu.add(menuSetting);

        sp.setBackground(new java.awt.Color(242, 242, 242));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(242, 242, 242));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp)
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (!menuMessage.isSelected()) {
            menuMessage.setSelected(true);
            menuCloud.setSelected(false);
            menuSetting.setSelected(false);
            showMessage();
        }
    }                                           

    private void menuCloudActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (!menuCloud.isSelected()) {
            menuMessage.setSelected(false);
            menuCloud.setSelected(true);
            menuSetting.setSelected(false);
        }
    }                                         

    private void menuSettingActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (!menuSetting.isSelected()) {
            menuMessage.setSelected(false);
            menuCloud.setSelected(false);
            menuSetting.setSelected(true);
            showBox();
        }
    }                                           

    // Variables declaration - do not modify                     
    private javax.swing.JLayeredPane menu;
    private com.thlong.component.MenuButton menuCloud;
    private javax.swing.JLayeredPane menuList;
    private com.thlong.component.MenuButton menuMessage;
    private com.thlong.component.MenuButton menuSetting;
    private javax.swing.JScrollPane sp;
    // End of variables declaration                   
}
