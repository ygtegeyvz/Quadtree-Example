/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree3;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DortluAgac<T extends Nokta> {

    public static final double EnKucuk = 10.0;
    private final AgacDugum<T> root;

    public DortluAgac(Rectangle2D sinirlar) {
        root = new AgacDugum<>(sinirlar);
    }

    /*
    Roota ekleme fonksiyonu 
    @param object T tipinde bir nesne deÄŸiÅŸkeni
     */

    public void ekle(T object) {
        root.ekle(object);
    }

    /*
    Rootu silen fonksiyon
    @param object T tipinde bir nesne deÄŸiÅŸkeni
     */

    public void Sil(T object) {
        root.Sil(object);
    }

//Root için düğüm sınırlarını tutan fonksiyon.
    public List<Rectangle2D> DugumSınırlarınıTut() {
        List<Rectangle2D> DugumSınırları = new ArrayList<>();
        root.DugumSınırlarınıTut(DugumSınırları);
        return DugumSınırları;
    }

    public Set<T> list() {
        return root.list();

    }
}