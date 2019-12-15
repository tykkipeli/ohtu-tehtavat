package ohtu.kivipaperisakset;

public class Tekoaly {

    private int siirto;
    private String siirrot[] = {"k","p","s"};

    public Tekoaly() {
        siirto = 0;
    }

    public String annaSiirto() {
        siirto++;
        return siirrot[siirto%3];
    }

    void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
