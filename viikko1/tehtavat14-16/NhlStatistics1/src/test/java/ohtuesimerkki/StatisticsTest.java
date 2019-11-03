/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matilaol
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
    
    @Test
    public void searchMetodiLoytaaOikeanHenkilon() {
        Player player = stats.search("Kurri");
        assertEquals(player.getName(),"Kurri");
    }
    
    @Test
    public void searchMetodiPalauttaaNullJosHenkiloaEiOle() {
        Player player = stats.search("Erkki");
        assertEquals(player, null);
    }
    
    @Test
    public void teamMetodiPalauttaaOikeatHenkilot() {
        List<Player> lista = stats.team("EDM");
        assertEquals(3, lista.size());
        assertEquals("Semenko", lista.get(0).getName());
        assertEquals("Kurri", lista.get(1).getName());
        assertEquals("Gretzky", lista.get(2).getName());
    }
    
    @Test
    public void topScorersMetodiPalauttaaOikeatHenkilot() {
        List<Player> lista = stats.topScorers(3);
        assertEquals(3, lista.size());
        assertEquals("Gretzky", lista.get(0).getName());
        assertEquals("Lemieux", lista.get(1).getName());
        assertEquals("Yzerman", lista.get(2).getName());
    }
}
