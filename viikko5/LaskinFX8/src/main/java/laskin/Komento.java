
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public abstract class Komento {
    protected TextField tuloskentta, syotekentta;
    protected Button nollaa, undo;
    protected Sovelluslogiikka logiikka;
    protected String prevTulos, prevSyote;
    int prevArvo;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka logiikka) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.logiikka = logiikka;
        this.prevTulos = "";
        this.prevSyote = "";
        this.prevArvo = 0;
    }
    
    public abstract void suorita();
    
    public void peru() {
        syotekentta.setText(prevSyote);
        tuloskentta.setText(prevTulos);
        logiikka.setTulos(prevArvo);
        disableTarkistus();
    }
    
    public int lueSyote() {
        prevArvo = logiikka.tulos();
        return Integer.parseInt(syotekentta.getText());
    }
    
    public void paivitaKentat() {
        prevTulos = tuloskentta.getText();
        prevSyote = syotekentta.getText();
        int tulos = logiikka.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        disableTarkistus();
    }

    private void disableTarkistus() {
        int tulos = logiikka.tulos();
        if ( tulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
    
}
