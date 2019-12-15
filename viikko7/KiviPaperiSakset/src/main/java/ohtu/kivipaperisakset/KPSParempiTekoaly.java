package ohtu.kivipaperisakset;


public class KPSParempiTekoaly extends PeliMoodi{

    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String annaSiirto() {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }

    @Override
    protected void asetaSiirto(String siirto) {
        tekoaly.asetaSiirto(siirto);
    }
}
