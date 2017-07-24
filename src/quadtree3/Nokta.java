/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author ege
 */
public class Nokta {

    public static int DegmeSayisi = 0;
    private boolean Bulundu = false;
    private boolean DegdiMi = false;
    public final Ellipse2D Daire;
    public double noktaX, noktaY, noktaR;

    public Nokta(double x, double y, double radius) {
        double hr = radius / 2.0;
        noktaX = x;
        noktaY = y;
        noktaR = hr;
        Daire = new Ellipse2D.Double(x - hr, y - hr, radius, radius);
    }
    /*Noktaları çizen fonksiyon
  @param g Graphics2D değişkeni
     */
    public void Cizdir(Graphics2D g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor((Color.BLUE));
        g2d.fill(Daire);
        g2d.dispose();
    }   
//Kesişmeleri Kontrol eder.
//@param aabb Rectangle2D değişkeni
    public boolean Kesisme(Rectangle2D aabb) {
        Bulundu = Daire.intersects(aabb);//quadtree'de Dikdörtgenler kesişiyor mu kontrol eder.
        DegdiMi = true;
        DegmeSayisi++;
        return Bulundu;
    }

}
