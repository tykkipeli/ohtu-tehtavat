/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author matilaol
 */
public class HasFewerThan implements Matcher{
    
    private int value;
    private String fieldName;

    public HasFewerThan(int value, String category) {
        this.value = value;
        fieldName = category;
    }

    @Override
    public boolean matches(Player p) {
        return new Not(new HasAtLeast(value, fieldName)).matches(p);
    }
    
}
