/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadtree3;

import static quadtree3.DortluAgac.EnKucuk;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

   class AgacDugum<T extends Nokta> {
        private final Rectangle2D sinirlar; ///sınırlar
        private AgacDugum<T>[] cocuklar;// çocuklar
        private List<T> nesneler;//nesneler
/**Yerel değişkene nesne değişkenini atadık.
 * @param sinirlar Sınırlarımızı tutan değişken
 */
        public AgacDugum(Rectangle2D sinirlar) {
            this.sinirlar = sinirlar;
//Yerel değişkene nesne değişkenini ata
        }
/**En küçük boyutu Belirledik
 */
        private boolean MinimumBoyutu() {
            return sinirlar.getWidth() <= EnKucuk || sinirlar.getHeight() <= EnKucuk;
        }
/**Ağacımızın düğümlerinin oluşturulduğu bölme işlemlerinin yapıldığı fonksiyon
 */
        private void Bolunme() {
            double yarigenislik = sinirlar.getWidth() / 2.0; ///Yarıya bölme genişliği
            double yariyukseklik = sinirlar.getHeight() / 2.0; ///Yarıya bölme uzunluğu

            Rectangle2D KB = new Rectangle2D.Double(
                    sinirlar.getMinX(), sinirlar.getMinY(), yarigenislik, yariyukseklik);
            Rectangle2D KD= new Rectangle2D.Double(
                    sinirlar.getMinX() + yarigenislik, sinirlar.getMinY(), yarigenislik, yariyukseklik);
            Rectangle2D GB = new Rectangle2D.Double(
                    sinirlar.getMinX(), sinirlar.getMinY() + yariyukseklik, yarigenislik, yariyukseklik);
            Rectangle2D GD = new Rectangle2D.Double(
                    sinirlar.getMinX() + yarigenislik, sinirlar.getMinY() + yariyukseklik, yarigenislik, yariyukseklik);
/// Ağacın çocuklarını oluşturduk.
            cocuklar = new AgacDugum[4];
            cocuklar[0] = new AgacDugum<>(KB);
            cocuklar[1] = new AgacDugum<>(KD);
            cocuklar[2] = new AgacDugum<>(GB);
            cocuklar[3] = new AgacDugum<>(GD);
///4 çocuğumuza atadık.
            for (AgacDugum<T> cocuk: cocuklar) {
                cocuk.ekle(nesneler.get(0));
            }
            nesneler = null;
            //cocuk'a for each döngüsü kullanılarak sırasıyla cocukların hepsi atanıyor.Ve nesne ekleme işlemi yapılıyor
        }
/**Ekleme fonksiyonu
 * @param obje T genericinde nesnemiz.
 */
        public boolean ekle(T obje) {
            //Kesişme yoksa ekleme
            if (!obje.Kesisme(sinirlar)) {
                return false;
            }
            //Kesişiyorsa ve başka nesne tutmuyorsa nesne oluştur.Boşsa gir.
            if (BosMu()) {
                nesneler = new ArrayList<>();
                nesneler.add(obje);
                return true;
            }

            //Minimum boyutta bir düğüm herhangi bir sayıda nesneyi tutsun
            if (nesneler != null && MinimumBoyutu()) {
                nesneler.add(obje);
                return true;
            }

            //Hiç bir çocuk yoksa ve ikinci bir nesne eklenirse ekranı böl
            if (cocuklar == null) {
                Bolunme();
            }

            //Nesneyi çocuklara ekle
            for (AgacDugum<T> cocuk: cocuklar) {
                cocuk.ekle(obje);
            }            
            return true;
        }     
/**Silme Fonksiyonu
 * @param nesne T tipinde nesnemiz
 */
        public void Sil(T nesne) {
            // Bu düğümde nesneler varsa sil
            if (nesneler != null) { 
                nesneler.remove(nesne);
///Nesneler boşsa sıfırla
                if (nesneler.isEmpty()) {
                    nesneler = null;
                }
            }
//Düğümler varsa sil
            if (cocuklar != null) {
                for (AgacDugum<T> cocuk: cocuklar) {
                    cocuk.Sil(nesne);
                }
/// Çocuklar varsa çocukları sil
                Set<T> objs = list();
                if (objs.size() <= 1) {
                    cocuklar = null;

                    nesneler = new ArrayList<>();
                    nesneler.addAll(objs);
                }
            }
        }
      
/**Daha sonra çizdirme yapabilmek için düğüm sınırlarını tutar.
 * 
 * @param dugumSınırları Düğümlerimizin sınırlarını tutan List sınıfı Rectangle2d tipinde değişken 
 */
        public void DugumSınırlarınıTut(List<Rectangle2D> dugumSınırları) {
            dugumSınırları.add(sinirlar);
            if (cocuklar != null) {
                for (AgacDugum<T> cocuk: cocuklar) {
                    cocuk.DugumSınırlarınıTut(dugumSınırları);
                }
            }
        }
/*
      Sonucu tuttuğumuz veri yapımız
        */
        public Set<T> list() {
            Set<T> sonuc = new HashSet<>();
            listele(sonuc);
            return sonuc;
        }
/*      Nesneleri veri yapısına eklememizi sağlar.
        @param degerler
        */
        private void listele(Set<T> degerler) {
            if (nesneler != null) {
                degerler.addAll(nesneler);
            }

            if (cocuklar != null) {
                for (AgacDugum<T> cocuk: cocuklar) {
                    cocuk.listele(degerler);
                }
            }
        }       
/*Nesne veya çocuk kontrolü yapar.
        */
        public boolean BosMu() {
            return nesneler == null && cocuklar == null;
        }
        
    }

