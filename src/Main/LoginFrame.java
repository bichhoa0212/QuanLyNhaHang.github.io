/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Untils.Auth;
import Untils.MsgBox;
import java.awt.Color;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author doanp
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        setUndecorated(true);
        initComponents();
        init();
    }
    
    void init() {
        new ChaoDiaLog(this, true).setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        hidePass();
        matKhauFocusLost();
    }
    
    void showPass() {
        lblShow.setIcon(new ImageIcon("src/icon/show.png"));
        txtMatKhau.setEchoChar('\u0000');
    }
    
    void hidePass() {
        lblShow.setIcon(new ImageIcon("src/icon/hide.png"));
        if (!txtMatKhau.getText().equals("Mật khẩu")) {
            txtMatKhau.setEchoChar('*');
        }
    }
    
    void addPlaceHolderStyle(JTextField textField) {
        textField.setForeground(new Color(128, 128, 128));
    }
    
    void removePlaceHolderStyle(JTextField textField) {
        textField.setForeground(Color.BLACK);
    }
    
    void tenDangNhapFocusGained() {
        if (txtTenDangNhap.getText().equals("Tên đăng nhập")) {
            txtTenDangNhap.setText(null);
            txtTenDangNhap.requestFocus();
            removePlaceHolderStyle(txtTenDangNhap);
        }
    }
    
    void tenDangNhapFocusLost() {
        if (txtTenDangNhap.getText().length() == 0) {
            addPlaceHolderStyle(txtTenDangNhap);
            txtTenDangNhap.setText("Tên đăng nhập");
        }
    }
    
    void matKhauFocusGained() {
        if (txtMatKhau.getText().equals("Mật khẩu")) {
            txtMatKhau.setText(null);
            txtMatKhau.requestFocus();
            txtMatKhau.setEchoChar('*');
            removePlaceHolderStyle(txtMatKhau);
        }
    }
    
    void matKhauFocusLost() {
        if (txtMatKhau.getText().length() == 0) {
            addPlaceHolderStyle(txtMatKhau);
            txtMatKhau.setText("Mật khẩu");
            txtMatKhau.setEchoChar('\u0000');
        }
    }
    
    boolean checkValidate() {
        if (txtTenDangNhap.getText().equals("Tên đăng nhập")) {
            MsgBox.alert(this, "Vui lòng nhập tên đăng nhập!");
            txtTenDangNhap.requestFocus();
            return false;
        } else if (txtMatKhau.getText().equals("Mật khẩu")) {
            MsgBox.alert(this, "Vui lòng nhập mật khẩu!");
            txtMatKhau.requestFocus();
            return false;
        }
        return true;
    }
    
    void dangNhap() {
        if (checkValidate()) {
            NhanVien nhanVien = new NhanVienDAO().selectById(txtTenDangNhap.getText());
            if (nhanVien == null || nhanVien.isTrangThai() == false) {
                MsgBox.alert(this, "Tên đăng nhập không tồn tại!");
            } else if (!txtMatKhau.getText().equals(nhanVien.getMatKhau())) {
                MsgBox.alert(this, "Sai mật khẩu!");
            } else {
                Auth.user = nhanVien;
                this.dispose();
                new TrangChuFrame().setVisible(true);
            }
        }
    }
    
    void openWeb(String link) {
        try {
            Runtime run = Runtime.getRuntime();
            run.exec("rundll32 url.dll, FileProtocolHandler " + link);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTenDangNhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        lblQMK = new javax.swing.JLabel();
        lblIG = new javax.swing.JLabel();
        lblFB = new javax.swing.JLabel();
        lblNP = new javax.swing.JLabel();
        lblShow = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        lblBackground = new javax.swing.JLabel();
        lblFB1 = new javax.swing.JLabel();
        lblNP1 = new javax.swing.JLabel();
        lblIG1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        txtTenDangNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusLost(evt);
            }
        });
        txtTenDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenDangNhapKeyReleased(evt);
            }
        });
        jPanel1.add(txtTenDangNhap);
        txtTenDangNhap.setBounds(470, 140, 260, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 83, 148));
        jLabel1.setText("ĐĂNG NHẬP");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(490, 50, 230, 44);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(470, 110, 140, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mật khẩu");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(470, 180, 90, 22);

        btnHuy.setBackground(new java.awt.Color(8, 83, 148));
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HUỶ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuy);
        btnHuy.setBounds(510, 250, 80, 30);

        btnOK.setBackground(new java.awt.Color(8, 83, 148));
        btnOK.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(btnOK);
        btnOK.setBounds(620, 250, 80, 30);

        lblQMK.setBackground(new java.awt.Color(255, 255, 255));
        lblQMK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQMK.setForeground(new java.awt.Color(204, 0, 0));
        lblQMK.setText("Quên mật khẩu? ");
        lblQMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQMKMouseClicked(evt);
            }
        });
        jPanel1.add(lblQMK);
        lblQMK.setBounds(550, 290, 150, 17);

        lblIG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ig.jpg"))); // NOI18N
        lblIG.setText("PickPet");
        lblIG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIGMouseClicked(evt);
            }
        });
        jPanel1.add(lblIG);
        lblIG.setBounds(680, 320, 100, 50);

        lblFB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fb.jpg"))); // NOI18N
        lblFB.setText("Ngỹn Pick");
        lblFB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFBMouseClicked(evt);
            }
        });
        jPanel1.add(lblFB);
        lblFB.setBounds(460, 320, 110, 50);

        lblNP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/call.jpg"))); // NOI18N
        lblNP.setText("0368.721.JQK");
        jPanel1.add(lblNP);
        lblNP.setBounds(560, 320, 120, 50);

        lblShow.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblShowMouseMoved(evt);
            }
        });
        lblShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblShowMouseExited(evt);
            }
        });
        jPanel1.add(lblShow);
        lblShow.setBounds(690, 210, 30, 30);

        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyReleased(evt);
            }
        });
        jPanel1.add(txtMatKhau);
        txtMatKhau.setBounds(470, 210, 260, 30);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LoginBG.jpg"))); // NOI18N
        lblBackground.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblBackgroundMouseMoved(evt);
            }
        });
        jPanel1.add(lblBackground);
        lblBackground.setBounds(0, 0, 800, 400);

        lblFB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fb.jpg"))); // NOI18N
        lblFB1.setText("Ngỹn Pick");
        lblFB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFB1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFB1);
        lblFB1.setBounds(460, 320, 110, 50);

        lblNP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/call.jpg"))); // NOI18N
        lblNP1.setText("0368.721.JQK");
        jPanel1.add(lblNP1);
        lblNP1.setBounds(560, 320, 120, 50);

        lblIG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ig.jpg"))); // NOI18N
        lblIG1.setText("Dogpick");
        lblIG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIG1MouseClicked(evt);
            }
        });
        jPanel1.add(lblIG1);
        lblIG1.setBounds(680, 320, 100, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblShowMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMouseMoved

    }//GEN-LAST:event_lblShowMouseMoved

    private void lblShowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMouseExited

    }//GEN-LAST:event_lblShowMouseExited

    private void txtTenDangNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenDangNhapKeyReleased

    }//GEN-LAST:event_txtTenDangNhapKeyReleased

    private void txtTenDangNhapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusGained
        tenDangNhapFocusGained();
    }//GEN-LAST:event_txtTenDangNhapFocusGained

    private void txtTenDangNhapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusLost
        tenDangNhapFocusLost();
    }//GEN-LAST:event_txtTenDangNhapFocusLost

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        matKhauFocusGained();
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        matKhauFocusLost();
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        if (MsgBox.confirm(this, "Bạn có chắc chắn muốn thoát?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnOKActionPerformed

    private void lblBackgroundMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackgroundMouseMoved

    }//GEN-LAST:event_lblBackgroundMouseMoved
    boolean show = true;
    private void lblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowMouseClicked
        if (show) {
            showPass();
            show = false;
        } else {
            hidePass();
            show = true;
        }
    }//GEN-LAST:event_lblShowMouseClicked

    private void txtMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyReleased

    }//GEN-LAST:event_txtMatKhauKeyReleased

    private void lblFBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFBMouseClicked
        if (evt.getClickCount() == 2) {
            openWeb("https://www.facebook.com/nguyen.bich.904750");
        }
    }//GEN-LAST:event_lblFBMouseClicked

    private void lblIGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIGMouseClicked
        if (evt.getClickCount() == 2) {
            openWeb("https://www.instagram.com/nguyen.bich.192/");
        }
    }//GEN-LAST:event_lblIGMouseClicked

    private void lblFB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFB1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFB1MouseClicked

    private void lblIG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIG1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblIG1MouseClicked
    ForgotPassFrame fg = new ForgotPassFrame();
    private void lblQMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQMKMouseClicked
        fg.setVisible(true);
    }//GEN-LAST:event_lblQMKMouseClicked

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblFB;
    private javax.swing.JLabel lblFB1;
    private javax.swing.JLabel lblIG;
    private javax.swing.JLabel lblIG1;
    private javax.swing.JLabel lblNP;
    private javax.swing.JLabel lblNP1;
    private javax.swing.JLabel lblQMK;
    private javax.swing.JLabel lblShow;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
