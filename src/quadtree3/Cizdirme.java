/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree3;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JComponent;

public class Cizdirme extends JComponent {

    private static final int SIZE = 512;//Üzerinde işlem yapacağımız ekran boyutumuz.
    private DortluAgac<Nokta> quadTree = new DortluAgac<>(new Rectangle2D.Double(0, 0, SIZE, SIZE));
    private int x;
    private int y;
    private int width;
    private int height;
    private final Cizdirme.MouseDrag mouseDrag;
    public int cemberMerkezX, cemberMerkezY, cemberMerkezR;
    Graphics2D g2d;

    public Cizdirme() {
        //Mouse tıklandığında yapılacak işlemler.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onMouseClick(e);
            }
        }
        );
        mouseDrag = new Cizdirme.MouseDrag();
        addMouseListener(mouseDrag);
        addMouseMotionListener(mouseDrag);

    }

    /*
    Noktaların görüntüsünü silmemize yarar.
     */
    public void temizle() {
        quadTree = new DortluAgac<>(new Rectangle2D.Double(0, 0, SIZE, SIZE));
        repaint();
    }

    private final class MouseDrag extends MouseAdapter {

        private boolean surukleniyorMu = false;
        private Point son;

        /*Mouse basıldığında..
        @param m mouse olayları için değişken.
         */
        @Override
        public void mousePressed(MouseEvent m) {
            son = m.getPoint();
            surukleniyorMu = icindeMi(son);
            if (!surukleniyorMu) {
                x = son.x;
                y = son.y;
                width = 0;
                height = 0;
            }
            repaint();
        }

        /*Mouse serbest kaldığında..
        @param m mouse olayları için değişken.
         */
        @Override
        public void mouseReleased(MouseEvent m) {
            son = null;
            surukleniyorMu = false;
            repaint();
        }

        /*Mouse sürüklendiğinde..
        @param m mouse olayları için değişken.
         */
        @Override
        public void mouseDragged(MouseEvent m) {

            int dx = m.getX() - son.x;
            int dy = m.getY() - son.y;
            if (surukleniyorMu) {
                x += dx;
                y += dy;
            } else {
                width += dx;
                height += dy;
            }

            //System.out.println("Sonx:"+son.x);
            son = m.getPoint();
            repaint();
        }
    }

    /*Mouse tıklandığında..
        @param m mouse olayları için değişken.
     */
    private void onMouseClick(MouseEvent evt) {
        //Sol fare tuş ile nesne,nokta ekle.
        if (evt.getButton() == MouseEvent.BUTTON1) {
            quadTree.ekle(new Nokta(evt.getX(), evt.getY(), DortluAgac.EnKucuk));
        }
        repaint();
    }

    /*Sürükleme için
    @param point Point sınıfında koordinatlar için değişken
     */
    public boolean icindeMi(Point point) {
        return new Ellipse2D.Float(x, y, width, width).contains(point);
    }
/**
 * Dairenin içinde nokta var mı tespit eder
 * @param cemberX cemberin merkezinin x kordinatı
 * @param cemberY cemberin merkezinin y kordinatı
 * @param R       yarıçap
 * @param noktaX noktanın x kordinatı
 * @param noktaY noktanın y kordinatı
 * @return 
 */
    public boolean icindeMi2(double cemberX, double cemberY, double R, double noktaX, double noktaY) {
        if (Math.sqrt(Math.pow(noktaX - cemberX, 2) + Math.pow(noktaY - cemberY, 2)) <= R) {
            return true;
        }
        return false;
    }
/**
 * Ağaçta arama yapan fonksiyon
 * @param cemberX  cemberin merkezinin x kordinatı
 * @param cemberY  cemberin merkezinin y kordinatı
 * @param R        yarıçap
 */
    public void arama(double cemberX, double cemberY, double R) {
        int i = 0;
        double[] siralaX = new double[100];
        double[] siralaY = new double[100];
        for (Nokta c : quadTree.list()) {
            double x = c.noktaX;
            double y = c.noktaY;
            
            if (icindeMi2(cemberX, cemberY, R, x, y)) {
                System.out.println(x + "," + y);
                siralaX[i] = x;
                siralaY[i] = y;
                i++;
            }
        }
        int temp = 0;
        int temp1 = 0;
        for (i = 0; i < siralaX.length - 1; i++) {

            for (int j = 0; j < siralaX.length - i - 1; j++) { //dizinin en büyük elemanı sona geldiği için bir daha onu karşılaştırmaya sokmuyoruz

                if (siralaX[j] > siralaX[j + 1]) { //dizinin koşula göre elemanlarının yerlerini değiştiriyoruz

                    temp = (int) siralaX[j];

                    siralaX[j] = siralaX[j + 1];

                    siralaX[j + 1] = temp;

                    temp1 = (int) siralaY[j];

                    siralaY[j] = siralaY[j + 1];

                    siralaY[j + 1] = temp1;
                }

            }
        }
        System.out.println("X'e göre noktaları sıralama----------");
        for (i = siralaX.length - 1; i > 0; i--) {
            if (siralaX[i] != 0) {
                System.out.println(siralaX.length - i + ". nokta :" + siralaX[i] + "," + siralaY[i]);
            }
        }

        for (i = 0; i < siralaY.length - 1; i++) {

            for (int j = 0; j < siralaY.length - i - 1; j++) { //dizinin en büyük elemanı sona geldiği için bir daha onu karşılaştırmaya sokmuyoruz

                if (siralaY[j] > siralaY[j + 1]) { //dizinin koşula göre elemanlarının yerlerini değiştiriyoruz

                    temp = (int) siralaY[j];
                    siralaY[j] = siralaY[j + 1];
                    siralaY[j + 1] = temp;
                    temp1 = (int) siralaX[j];
                    siralaX[j] = siralaX[j + 1];
                    siralaX[j + 1] = temp1;
                }

            }
        }
        System.out.println("Y'e göre noktaları sıralama----------");
        for (i = siralaX.length - 1; i > 0; i--) {
            if (siralaX[i] != 0) {
                System.out.println(siralaX.length - i + ". nokta :" + siralaX[i] + "," + siralaY[i]);
            }
        }
    }

    /*
    Çizim işlemlerimizi gerçekleştirdiğimiz Fonksiyon.
    @param g Graphics sınıfının değişkeni
     */
    @Override
    protected void paintComponent(Graphics g) {

        /*Graphics2D*/ g2d = (Graphics2D) g.create();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, SIZE, SIZE);
        //Bölme Çizgilerni çizer
        for (Rectangle2D bound : quadTree.DugumSınırlarınıTut()) {
            g2d.setColor(Color.BLACK);
            g2d.draw(bound);
        }
//Arama şeylerini çizer
        g2d.setColor(Color.red);
        cemberMerkezR = width / 2;//yarıçap 
        cemberMerkezX = x + cemberMerkezR; //Çemberin merkezinin x kordinatı
        cemberMerkezY = y + cemberMerkezR; ////Çemberin merkezinin y kordinatı
        g2d.drawOval(x, y, width, width);
//Noktaları Çizdirir
        for (Nokta c : quadTree.list()) {
            c.Cizdir(g2d);
        }
        g2d.drawString(
                String.format("Nesne: %d",
                        quadTree.list().size()), 535, 255);
//Grafik kaynaklarını temizle.
        g2d.dispose();
    }
    /*
    Rastgele nesne ekleme fonksiyonu
    @param sayac 
     */
    public void random(int sayac) {
        quadTree = new DortluAgac<>(new Rectangle2D.Double(0, 0, SIZE, SIZE));
        double d = (double) SIZE / sayac;
        List<Double> xs = new ArrayList<>();
        List<Double> ys = new ArrayList<>();
        for (int i = 0; i < sayac; i++) {
            xs.add(i * d);
            ys.add(i * d);
           
            
        }
        //Noktaların ekrana karışık basılmasını sağlar.
        Collections.shuffle(xs);
        Collections.shuffle(ys);
        for (int i = 0; i < sayac; i++) {
            quadTree.ekle(new Nokta(xs.get(i), ys.get(i), DortluAgac.EnKucuk));
        }
        repaint();
    }

}
