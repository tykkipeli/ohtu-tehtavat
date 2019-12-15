package ohtu.kivipaperisakset;

// "Muistava tekoäly"
public class TekoalyParannettu {

    private String[] muisti;
    private int muistiIndeksi;
    private String[] voittavaString = {"p","s","k"};

    public TekoalyParannettu(int muistinKoko) {
        muisti = new String[muistinKoko];
        muistiIndeksi = 0;
    }

    public void asetaSiirto(String siirto) {
        // jos muisti täyttyy, unohdetaan viimeinen alkio
        if (muistiIndeksi == muisti.length) {
            for (int i = 1; i < muisti.length; i++) {
                muisti[i - 1] = muisti[i];
            }
            muistiIndeksi--;
        }
        muisti[muistiIndeksi] = siirto;
        muistiIndeksi++;
    }

    public String annaSiirto() {
        if (muistiIndeksi <= 1) return "k";
        String viimeisinSiirto = muisti[muistiIndeksi - 1];
        int[] statistics = new int[3];
        
        for (int i = 0; i < muistiIndeksi - 1; i++) {
            if (viimeisinSiirto.equals(muisti[i])) {
                statistics[toInt(muisti[i])]++;
            }
        }
        return voittavaString[suurin(statistics)];
    }

    private int toInt(String siirto) {
        if (siirto.equals("k")) return 0;
        if (siirto.equals("p")) return 1;
        return 2;
    }

    private int suurin(int[] arr) {
        int max = 0;
        int maxInd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxInd]) {
                maxInd = i;
                max = arr[i];
            }
        }
        return maxInd;
    }
}
