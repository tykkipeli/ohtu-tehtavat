package ohtu.kivipaperisakset;


public class KPSTekoaly extends PeliMoodi{
    
    private Tekoaly tekoaly = new Tekoaly();

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