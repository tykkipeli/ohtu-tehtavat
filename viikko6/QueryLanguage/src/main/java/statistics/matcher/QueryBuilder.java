/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author matilaol
 */
public class QueryBuilder {
    
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public Matcher build() {
        Matcher tulos = matcher;
        this.matcher = new All();
        return tulos;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String str) {
        this.matcher = new And(matcher, new HasAtLeast(value,str));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String str) {
        this.matcher = new And(matcher, new HasFewerThan(value,str));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        Matcher matcher = new Not(new All());
        for (Matcher part : matchers) {
            matcher = new Or(matcher, part);
        }
        this.matcher = matcher;
        return this;
    }
}
