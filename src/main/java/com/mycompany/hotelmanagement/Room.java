/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotelmanagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *

 */
public class Room extends javax.swing.JFrame {
    public Room() {
        initComponents();
        ThemPhong();
        LoadRoom();
        LoadHang();
    }
    
    private void LoadRoom(){
            Vector vt;
     try {
            DefaultTableModel dtm = (DefaultTableModel) RoomTable.getModel();
            dtm.setNumRows(0);
            Connection ketnoi = SQLConnection.getConnection();
            String sql = "SELECT SOPHONG, TENKP, TENLP, TENTT, GIA\n" +
"FROM PHONG, KIEU_PHONG, LOAI_PHONG, TRANG_THAI, HANG_PHONG, GIA_HP\n" +
"WHERE PHONG.MATT = TRANG_THAI.MATT AND PHONG.HANGPHONG = HANG_PHONG.HANGPHONG\n" +
"AND HANG_PHONG.MAKP = KIEU_PHONG.MAKP AND HANG_PHONG.MALP = LOAI_PHONG.MALP\n" +
"AND PHONG.HANGPHONG = GIA_HP.HANGPHONG";
            PreparedStatement ps = ketnoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString("SOPHONG"));
                vt.add(rs.getString("TENKP"));
                vt.add(rs.getString("TENLP"));
                vt.add(rs.getString("TENTT"));
                vt.add(rs.getString("GIA"));
                dtm.addRow(vt);
            }
            RoomTable.setModel(dtm);
            rs.close();
            ps.close();
            ketnoi.close();
        } catch (SQLException ex) {
            Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void LoadHang(){
    Vector vt;
     try {
            Connection ketnoi = SQLConnection.getConnection();
            String sql = "SELECT HANGPHONG FROM HANG_PHONG";
            PreparedStatement ps = ketnoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbHnag.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    
        private String ThemPhong(){
        String id = "";
        Connection ketNoi = SQLConnection.getConnection();
        String sql = "SELECT COUNT(SOPHONG) FROM PHONG";
        
        try {
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int temp = 0;

            while (rs.next()) {
                temp = rs.getInt(1);
                id = String.valueOf(temp+1);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
       }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        CusBtn = new javax.swing.JLabel();
        RoomBtn = new javax.swing.JLabel();
        Bookbtn = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTT = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        RoomTable = new javax.swing.JTable();
        SuaBtn = new javax.swing.JButton();
        ThemBtn = new javax.swing.JButton();
        XoaBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phong = new javax.swing.JTextField();
        cbHnag = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        CusBtn.setBackground(new java.awt.Color(0, 0, 0));
        CusBtn.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        CusBtn.setForeground(new java.awt.Color(255, 255, 255));
        CusBtn.setText("Check in");
        CusBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CusBtnMouseClicked(evt);
            }
        });

        RoomBtn.setBackground(new java.awt.Color(0, 0, 0));
        RoomBtn.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        RoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        RoomBtn.setText("Rooms");

        Bookbtn.setBackground(new java.awt.Color(0, 0, 0));
        Bookbtn.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        Bookbtn.setForeground(new java.awt.Color(255, 255, 255));
        Bookbtn.setText("Check Out");
        Bookbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookbtnMouseClicked(evt);
            }
        });

        LogoutBtn.setBackground(new java.awt.Color(0, 0, 0));
        LogoutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setText("Log Out");
        LogoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bookbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(RoomBtn)
                .addGap(18, 18, 18)
                .addComponent(CusBtn)
                .addGap(18, 18, 18)
                .addComponent(Bookbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutBtn)
                .addGap(23, 23, 23))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Trang Chính");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Quản Trị");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 102));
        jLabel2.setText("Số phòng");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 102));
        jLabel4.setText("Trạng thái");

        cbTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bảo Trì", "Có Khách", "Đặt Trước", "Dơ", "Sẵn Sàng", "" }));
        cbTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTTActionPerformed(evt);
            }
        });

        RoomTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Số Phòng", "Kiểu Phòng", "Loại", "Trạng Thái", "Giá"
            }
        ));
        RoomTable.setToolTipText("");
        RoomTable.setGridColor(new java.awt.Color(204, 204, 204));
        RoomTable.setSelectionForeground(new java.awt.Color(255, 255, 0));
        RoomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RoomTable);

        SuaBtn.setText("Sửa");
        SuaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaBtnActionPerformed(evt);
            }
        });

        ThemBtn.setText("Thêm");
        ThemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtnActionPerformed(evt);
            }
        });

        XoaBtn.setText("Xóa");
        XoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 153));
        jLabel1.setText("Quản Lí Phòng");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 102));
        jLabel6.setText("Hạng phòng");

        phong.setEditable(false);
        phong.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addComponent(jLabel1)
                        .addContainerGap(430, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ThemBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SuaBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(XoaBtn))
                            .addComponent(jLabel6)
                            .addComponent(cbTT, 0, 270, Short.MAX_VALUE)
                            .addComponent(phong)
                            .addComponent(cbHnag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbHnag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addGap(2, 2, 2)
                        .addComponent(cbTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SuaBtn)
                            .addComponent(ThemBtn)
                            .addComponent(XoaBtn))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutBtnMouseClicked

    private void CusBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusBtnMouseClicked
                // TODO add your handling code here:
                new Checkin().setVisible(true);
                this.dispose();
    }//GEN-LAST:event_CusBtnMouseClicked

    private void BookbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookbtnMouseClicked
        // TODO add your handling code here:
        new Checkout().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BookbtnMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
//        new MainPage().setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ThemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtnActionPerformed
     String tt = "";
     if(cbTT.getSelectedItem().toString().equals("Bảo Trì"))
         tt = "05";
     else if(cbTT.getSelectedItem().toString().equals("Sẵn Sàng"))
         tt = "01";
     else if(cbTT.getSelectedItem().toString().equals("Dơ"))
         tt = "03";
     else if(cbTT.getSelectedItem().toString().equals("Có Khách"))
         tt = "02";
     else 
         tt = "04";
     
      Connection ketnoi = SQLConnection.getConnection();
        String sql = "INSERT INTO PHONG(SOPHONG, HANGPHONG, MATT) VALUES(?,?,?)"; 
        try {
            PreparedStatement stmt = ketnoi.prepareStatement(sql);
            stmt.setString(1, ThemPhong());
            stmt.setString(2, cbHnag.getSelectedItem().toString());
            stmt.setString(3,tt);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            LoadRoom();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
    }//GEN-LAST:event_ThemBtnActionPerformed

    private void cbTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTTActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void XoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBtnActionPerformed
       Connection ketnoi = SQLConnection.getConnection();
        String sql = "DELETE FROM PHONG WHERE SOPHONG=?"; 
        try {
            PreparedStatement stmt = ketnoi.prepareStatement(sql);
            stmt.setString(1, phong.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            LoadRoom();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Không thể xóa vì phòng đã đi vào sử dụng");
            return;
        }       
    }//GEN-LAST:event_XoaBtnActionPerformed

    private void RoomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomTableMouseClicked
               int row = RoomTable.getSelectedRow();
        String value = RoomTable.getModel().getValueAt(row, 0).toString();
        phong.setText(value);
    }//GEN-LAST:event_RoomTableMouseClicked

    private void SuaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaBtnActionPerformed
        String tt = "";
     if(cbTT.getSelectedItem().toString().equals("Bảo Trì"))
         tt = "05";
     else if(cbTT.getSelectedItem().toString().equals("Sẵn Sàng"))
         tt = "01";
     else if(cbTT.getSelectedItem().toString().equals("Dơ"))
         tt = "03";
     else if(cbTT.getSelectedItem().toString().equals("Có Khách"))
         tt = "02";
     else 
         tt = "04";
        
        Connection ketnoi = SQLConnection.getConnection();
        String sql = "UPDATE PHONG\n" +
"SET MATT=?, HANGPHONG=?\n" +
"WHERE SOPHONG=?"; 
        try {
            PreparedStatement stmt = ketnoi.prepareStatement(sql);
            stmt.setString(1, tt);
            stmt.setString(2, cbHnag.getSelectedItem().toString());
            stmt.setString(3, phong.getText());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            LoadRoom();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }       
    }//GEN-LAST:event_SuaBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bookbtn;
    private javax.swing.JLabel CusBtn;
    private javax.swing.JLabel LogoutBtn;
    private javax.swing.JLabel RoomBtn;
    private javax.swing.JTable RoomTable;
    private javax.swing.JButton SuaBtn;
    private javax.swing.JButton ThemBtn;
    private javax.swing.JButton XoaBtn;
    private javax.swing.JComboBox<String> cbHnag;
    private javax.swing.JComboBox<String> cbTT;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField phong;
    // End of variables declaration//GEN-END:variables
}
