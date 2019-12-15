package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        HashMap<String, PeliMoodi> mappi = new HashMap<>();

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            
            PeliMoodi moodi;
            moodi = PeliMoodi.luoPelimoodi(vastaus);
            if (moodi == null) break;

            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            moodi.pelaa();
        }

    }
}
