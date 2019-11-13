
package ohtu;

public class Player implements Comparable<Player>{
    
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;
    private String birthdate;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public int pisteet() {
        return goals + assists;
    }

    @Override
    public int compareTo(Player player) {
        return pisteet() - player.pisteet();
    }
    
    private String tyhjaa(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += " ";
        }
        return str;
    }
    
    @Override
    public String toString() {
        String tuloste = name + tyhjaa(25-name.length());
        tuloste += team + "\t";
        tuloste += goals + " + " + assists + " = " + pisteet();
        return tuloste;
    }
    
}
