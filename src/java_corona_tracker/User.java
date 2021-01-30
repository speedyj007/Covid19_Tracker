
package java_corona_tracker;

public class User {
    
    private String name;
    private int confirmed;
    private int active;
    private int recovered;
    private int deaths;

    
    
    public User(String name, int confiremd, int active, int recovered, int deaths)
    {
        this.name = name;
        this.confirmed = confiremd;
        this.active  = active;
        this.recovered = recovered;
        this.deaths = deaths;
        
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
    
    
}           
 
    
   
