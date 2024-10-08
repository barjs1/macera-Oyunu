public abstract class normalLoc extends location{

    public normalLoc(player Player,String name) {
        super(Player);
        this.name=name;
    }

    public boolean getLocation(){
        return true;
    }
}
