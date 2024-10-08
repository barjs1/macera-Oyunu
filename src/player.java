import java.util.Scanner;

public class player {
    private String name,cName;
    private inventory inv;
    private int damage;
    private int health;
    private int money;
    private int rhealth;
    Scanner scan = new Scanner(System.in);


    public int getRhealth() {
        return rhealth;
    }

    public void setRhealth(int rhealth) {
        this.rhealth = rhealth;
    }

    public player(String name) {
        this.name = name;
        this.inv=new inventory();
    }

    public void selectCha(){

       switch(chaMenu()){
           case 1:
             initPlayer("samuray",5,21,15);
               break;
           case 2:
               initPlayer("okçu",7,18,20);
               break;
           case 3:
               initPlayer("şövalye",8,24,5);
               break;

           default:
               initPlayer("samuray",5,21,15);
               break;
       }
        System.out.println("karakter: " +getcName()+ "\t hasar:" +getDamage()+"\t sağlık:" +getHealth()+" \t para:"+getMoney());

    }
    public int chaMenu(){

        System.out.println("lütfen karakter seçiniz: ");
        System.out.println("1--Samuray: hasar: 5 sağlık : 21 para : 15");
        System.out.println("2--okçu   : hasar: 7 sağlık : 18 para : 20");
        System.out.println("3--şövalye: hasar: 8 sağlık : 24 para : 5");
        System.out.print("karakter seçiminiz: ");
        int chaID = scan.nextInt();

        while(chaID<1 || chaID>3){
            System.out.print("öyle bir karakter yok maalesef");
            chaID=scan.nextInt();
        }

        return chaID;
    }

    public int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }

    public void initPlayer(String cName,int dmg,int hlty,int mny){

        setcName(cName);
        setDamage(dmg);
        setHealth(hlty);
        setMoney(mny);
        setRhealth(hlty);

    }






    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public inventory getInv() {
        return inv;
    }

    public void setInv(inventory inv) {
        this.inv = inv;
    }


}
