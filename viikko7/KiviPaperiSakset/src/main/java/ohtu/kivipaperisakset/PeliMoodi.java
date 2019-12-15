/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author matilaol
 */
public abstract class PeliMoodi {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static PeliMoodi luoKPSTekoaly() {
        return new KPSTekoaly();
    }   
    public static PeliMoodi luoKPSParempiTekoaly() {
        return new KPSParempiTekoaly();
    }
    public static PeliMoodi luoKPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }
    
    public static PeliMoodi luoPelimoodi(String str) {
        if (str.equals("a")) {
            return PeliMoodi.luoKPSPelaajaVsPelaaja();
        } else if(str.equals("b")) {
            return PeliMoodi.luoKPSTekoaly();
        } else if (str.equals("c")) {
            return PeliMoodi.luoKPSParempiTekoaly();
        }
        return null;
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto = annaSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = annaSiirto();
            asetaSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected abstract String annaSiirto();
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract void asetaSiirto(String siirto);
}
