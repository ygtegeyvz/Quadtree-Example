package quadtree3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class JFrame extends javax.swing.JFrame {

     private final Cizdirme quadTree = new Cizdirme();

    public JFrame() {
        initComponents();//bu metod pencere üzerindeki buton,etiket vb bileşenleri ilklendirir
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Kapatınca programın çalışması dursun
        setSize(new Dimension(640, 600));//Pencere boyutu
        setLocationRelativeTo(null);//Açılan pencerenin ortada açılmasını belirliyoruz
        setLayout(new BorderLayout());
        add(quadTree, BorderLayout.CENTER);//Merkeze Cizdirme sınıfından quadtree ekle.
        getContentPane().setBackground(Color.BLACK);
        DoguPaneli.setBackground(Color.BLACK);
        
    }
/*
    Design ile tasarladığımız label,button,panel kodları.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DoguPaneli = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Random");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Temizle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Kapat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Bilgi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Ara");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DoguPaneliLayout = new javax.swing.GroupLayout(DoguPaneli);
        DoguPaneli.setLayout(DoguPaneliLayout);
        DoguPaneliLayout.setHorizontalGroup(
            DoguPaneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoguPaneliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoguPaneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoguPaneliLayout.createSequentialGroup()
                        .addGroup(DoguPaneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DoguPaneliLayout.setVerticalGroup(
            DoguPaneliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoguPaneliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(519, Short.MAX_VALUE)
                .addComponent(DoguPaneli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DoguPaneli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    Random butonuna tıkladığımızda random fonksiyonunu çağır.
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.addActionListener(this::Random);
    }//GEN-LAST:event_jButton1ActionPerformed
/*
    Temizle butonuna tıkladığımızda Temizle fonksiyonunu çağır.
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       jButton2.addActionListener(this::Temizle);
    }//GEN-LAST:event_jButton2ActionPerformed
/*
    Kapat butonuna tıkladığımızda Kapat fonksiyonunu çağır.
    */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      jButton3.addActionListener(this::Kapat);
    }//GEN-LAST:event_jButton3ActionPerformed
/*
    Bilgi butonuna tıkladığımızda ekrana bilgi mesajı bas.
    */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      JOptionPane.showMessageDialog(null,"Sol Fare Tuşu:Nokta Ekler\nFareyi sürükleyerek arama dairesi çıkarabilir ve boyutunu ayarlayabilirsiniz.","Nasıl Kullanılır?",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        jButton5.addActionListener(this::Ara);
    }//GEN-LAST:event_jButton5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new JFrame().setVisible(true));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
        
    
    }
    //Random fonksiyonunu çağırırız.
    private void Random(ActionEvent evt) {
        quadTree.random(600);
    }
//Temizle fonksiyonunu çağırırız.
    private void Temizle(ActionEvent evt) {
        quadTree.temizle();
    }
//Program kapatılır.
    private void Kapat(ActionEvent evt) {
        System.exit(0);
    }
    private void Ara(ActionEvent evt) {
        quadTree.arama(quadTree.cemberMerkezX,quadTree.cemberMerkezY,quadTree.cemberMerkezR);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DoguPaneli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
}
