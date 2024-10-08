public abstract class battleLoc extends location {
     protected canavar Canavar;
     protected String award;

     battleLoc(player Player, String name, canavar Canavar,String award) {
        super(Player);
        this.name = name;
        this.Canavar = Canavar;
        this.award=award;
    }
public boolean getLocation(){
        int obsCount= Canavar.count();

    System.out.println("şuan buradasınız: "+this.getName());
    System.out.println("dikkat et burada "+obsCount+" "+" tane "+Canavar.getName()+" var ");
    System.out.println("<S>avaşmak mı istersin yoksa korkak gibi <K>açmak mı:");
    String selCase = scan.nextLine();
    selCase=selCase.toUpperCase();
    if (selCase.equals("S")) {
        if (combat(obsCount)) {
            System.out.println(this.getName() + " bölgesindeki düşmanları temizledin helal be");
            if (this.award.equals("food") && Player.getInv().isFood() == false) {
                System.out.println(this.award + " kazandın");
                Player.getInv().setFood(true);
            } else if (this.award.equals("water") && Player.getInv().isWater() == false) {
                System.out.println(this.award + " kazandın");
                Player.getInv().setWater(true);
            } else if (this.award.equals("firewood") && Player.getInv().isFirewood() == false) {
                System.out.println(this.award + " kazandın");
                Player.getInv().setFirewood(true);
            }
            return true;
        }
        if (Player.getHealth() <= 0) {
            System.out.println("öldün gg");
            return false;
        }
    }

    return true;

     }

     public boolean combat(int obsCount) {

    for (int i = 0; i < obsCount; i++) {
        int defObsHealth = Canavar.getHealth();
        PlayerStats();
        enemyStats();

        while (Player.getHealth() > 0 && Canavar.getHealth() > 0) {
            System.out.println("<V>ur veya <K>aç ");
            String selCase = scan.nextLine();
            selCase = selCase.toUpperCase();

            if (selCase.equals("V")) {
                System.out.println("güzel vurdun");
                Canavar.setHealth(Canavar.getHealth() - Player.getTotalDamage());
                afterhit();
                if (Canavar.getHealth() > 0) {
                    System.out.println();
                    System.out.println("sana fena geçirdi");
                    Player.setHealth(Player.getHealth() - (Canavar.getDamage() - Player.getInv().getArmor()));
                    afterhit();
                }
            } else {
                return false;
            }
        }
        if (Canavar.getHealth() < Player.getHealth()) {
            System.out.println("onun içinden geçtin tebrikler savaşçı!!!");

            Player.setMoney(Player.getMoney() + Canavar.getAward());
            System.out.println("güncel paran: " + Player.getMoney());
            Canavar.setHealth(defObsHealth);

        } else {
            return false;
        }
        System.out.println("---------------------");

    }
    return true;
}
public void PlayerStats(){
    System.out.println("oyuncu değerleri \n-----------------");
    System.out.println();
    System.out.println("can: "+Player.getHealth());
    System.out.println("hasar: "+Player.getTotalDamage());
    System.out.println("para: "+Player.getMoney());
    if (Player.getInv().getDamage()>0){
        System.out.println("silah: "+Player.getInv().getwName());
    }
    if (Player.getInv().getArmor()>0){
        System.out.println("zırh: "+Player.getInv().getaName());
    }
}

public void enemyStats(){
    System.out.println(" canavar değerleri \n------------");
    System.out.println();
    System.out.println("can: "+Canavar.getHealth());
    System.out.println("hasar: "+Canavar.getDamage());
    System.out.println("ödül: "+Canavar.getAward());

}
public void afterhit(){
    System.out.println("canın: "+Player.getHealth());
    System.out.println(Canavar.getName()+"canı: "+Canavar.getHealth());
    System.out.println("---------------------------------");
    }


}
