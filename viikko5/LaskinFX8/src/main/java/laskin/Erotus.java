
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento{

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka logiikka) {
        super(tuloskentta, syotekentta, nollaa, undo, logiikka);
    }

    @Override
    public void suorita() {
        this.logiikka.miinus(this.lueSyote());
        paivitaKentat();
    }
    
}
