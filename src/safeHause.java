public class safeHause extends normalLoc {
    public safeHause(player Player) {
        super(Player, "güvenli ev");
    }

    public boolean getLocation(){
        Player.setHealth(Player.getRhealth());
        System.out.println("iyileştiniz.");

        System.out.println("şuan güvenli evdesiniz");
        return true;
    }
}
