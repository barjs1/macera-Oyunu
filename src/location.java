import java.util.Scanner;

public abstract class location {

    protected player Player;
    protected String name;

    Scanner scan = new Scanner(System.in);

    location(player Player){

        this.Player= Player;


    }
    public abstract boolean getLocation();

    public player getPlayer() {
        return Player;
    }

    public void setPlayer(player player) {
        Player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
