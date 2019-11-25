
package ohtu.intjoukkosovellus;

import java.util.ArrayList;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, 
                            OLETUSKASVATUS = 5;  
    private int kasvatuskoko;   
    private int[] ljono;
    private int alkioidenLkm;

    public IntJoukko() {
        alusta(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        alusta(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        alusta(kapasiteetti, kasvatuskoko);
    }
    
    private void alusta(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Negatiivinen kapasiteetti");
        }
        if (kasvatuskoko < 0) {
            throw new IllegalArgumentException("Negatiivinen kasvatuskoko");
        }
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            if (alkioidenLkm >= ljono.length) {
                kasvataKapasiteettia();
            }
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) return true;
        }
        return false;
    }

    public boolean poista(int luku) {      
        int kohta = loytyyIndeksilta(luku);
        if (kohta == -1) return false;
        shiftaaLoppuVasemmalle(kohta+1);
        return true;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) return "{}";
        String tuloste = "{";
        for (int i = 0; i < alkioidenLkm-1; i++) {
            tuloste += ljono[i] + ", ";
        }
        tuloste += ljono[alkioidenLkm-1] + "}";
        return tuloste;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            tulos.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            tulos.lisaa(bTaulu[i]);
        }
        return tulos;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    tulos.lisaa(bTaulu[j]);
                }
            }
        }
        return tulos;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            tulos.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            tulos.poista(bTaulu[i]);
        }

        return tulos;
    }

    private void kasvataKapasiteettia() {
        int uusi[] = new int[ljono.length + kasvatuskoko];
        kopioiTaulukko(ljono,uusi);
        ljono = uusi;
    }

    private int loytyyIndeksilta(int luku) {
        for (int i = 0; i < ljono.length; i++) {
            if (ljono[i] == luku) return i;
        }
        return -1;
    }

    private void shiftaaLoppuVasemmalle(int kohta) {
        for (int i = kohta; i < alkioidenLkm; i++) {
            ljono[i-1] = ljono[i];
        }
        alkioidenLkm--;
    }
        
}
