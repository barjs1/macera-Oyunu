public class toolStore extends normalLoc {


    toolStore(player Player) {
        super(Player, "mağaza");

    }

    public boolean getLocation() {

        System.out.println("para: " + Player.getMoney());
        System.out.println("1- silahlar");
        System.out.println("2- zırhlar");
        System.out.println("3- çıkış");

        System.out.println("seçiminiz: ");
        int selTool = scan.nextInt();
        int selItemID;

        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;

            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;

            case 3:
                break;
            default:
                break;
        }
        return true;

    }
    public int armorMenu(){
        System.out.println("1- hafif \t para  : 15 - koruma : 2 ");
        System.out.println("2- orta   \t para : 25 - koruma : 3 ");
        System.out.println("3- ağır   \t para : 40 - koruma : 7 ");
        System.out.println("4- çıkış");
        System.out.println("silah seçiniz: ");
        int selArmorID = scan.nextInt();
        return selArmorID;

    }
    public void buyArmor(int itemID){
        int avoid = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                aName = "hafif zırh";
                price = 15;
                break;

            case 2:
                avoid = 3;
                aName = "orta zırh";
                price = 15;
                break;

            case 3:
                avoid = 5;
                aName = "ağır zırh";
                price = 40;
                break;
            case 4:
                System.out.println("çıkış yapılıyor");
                break;

            default:
                System.out.println("geçersiz işlem");
                break;

        }
        if (price > 0) {

            if (Player.getMoney() >= price) {
                Player.getInv().setArmor(avoid);
                Player.getInv().setaName(aName);


                Player.setMoney(Player.getMoney() - price);
                System.out.println(aName + " satın aldınız engellenen hasar: " + Player.getDamage() + " " + "yeni hasar: " + (Player.getInv().getArmor()));

                System.out.println("kalan para: " + Player.getMoney());
            } else {
                System.out.println("o kadar paran yok fakir");
            }


        }
    }

    public int weaponMenu() {
        System.out.println("1- tabanca \t para : 25 - hasar : 2 ");
        System.out.println("2- kılıç   \t para : 35 - hasar : 3 ");
        System.out.println("3- tüfek   \t para : 45 - hasar : 7 ");
        System.out.println("4- çıkış");

        System.out.println("silah seçiniz: ");
        int selWeaponID = scan.nextInt();

        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "tabanca";
                price = 25;
                break;

            case 2:
                damage = 3;
                wName = "kılıç";
                price = 35;
                break;

            case 3:
                damage = 7;
                wName = "tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("çıkış yapılıyor");
                break;

            default:
                System.out.println("geçersiz işlem");
                break;

        }
        if (price > 0) {

            if (Player.getMoney() > price) {
                Player.getInv().setDamage(damage);
                Player.getInv().setwName(wName);

                Player.setMoney(Player.getMoney() - price);
                System.out.println(wName + " satın aldınız önceki hasar: " + Player.getDamage() + " " + "yeni hasar: " + (Player.getTotalDamage()));

                System.out.println("kalan para: " + Player.getMoney());
            } else {
                System.out.println("o kadar paran yok fakir");
            }


        }
    }
}