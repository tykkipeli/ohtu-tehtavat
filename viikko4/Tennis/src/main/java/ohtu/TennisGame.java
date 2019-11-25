package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private final String pisteTulosteet[] = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else
            player2Score++;
    }

    public String getScore() {
        if (player1Score == player2Score) return tasaPisteTuloste();
        return eriPisteTuloste();
    }

    private String tasaPisteTuloste() {
        if (player1Score > 3) return "Deuce";
        return pisteTulosteet[player1Score] + "-All";
    }

    private String yliNeljanPisteenTuloste() {
        String voittaja = player1Score > player2Score ? "player1" : "player2";
        if (Math.abs(player1Score - player2Score) == 1) return "Advantage " + voittaja;
        return "Win for " + voittaja;
    }

    private String eriPisteTuloste() {
        if (Math.max(player1Score,player2Score) > 3) return yliNeljanPisteenTuloste();
        return pisteTulosteet[player1Score] + "-" + pisteTulosteet[player2Score];
    }
}