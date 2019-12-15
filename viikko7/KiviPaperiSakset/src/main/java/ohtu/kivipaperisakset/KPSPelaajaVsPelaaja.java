package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends PeliMoodi{

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String annaSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        String siirto = scanner.nextLine();
        return siirto;
    }

    @Override
    protected void asetaSiirto(String siirto) {
    }
}