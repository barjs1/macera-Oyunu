import java.util.Scanner;

public class game {

    player Player;
    location Location;

    Scanner scan = new Scanner(System.in);

    public void login(){

        Scanner scan = new Scanner(System.in);
        System.out.println("adventure time oyununa hoşgeldin savaşçı !!!");
        System.out.println(" lütfen oyuna başlamadan önce ismini bana söyler misin: ");

        String playerName = scan.nextLine();
        Player = new player(playerName);

        Player.selectCha();

        start();




    }
    public void start(){
        while(true){
            System.out.println();
            System.out.println("======================================");
            System.out.println();
            System.out.println("bana nereye gitmek istediğini söyle seni götüreyim: ");
            System.out.println("1- güvenli ev --> senin sıcacık ve güvenli evin gidersen canın dolar");
            System.out.println("2- mağara --> burda zombiler olabilir dikkat et");
            System.out.println("3- orman --> kan emici vampirlere dikkat et");
            System.out.println("4- nehir --> söylentilere göre burda bir ayı varmış dikkat et");
            System.out.println("5- mağaza --> burası güvenli istediğin silah ya da zırhı alabilirsiniz");
            System.out.println("girmek istediğiniz yer : ");
            int selLoc = scan.nextInt();

            while(selLoc<0||selLoc>5){
                System.out.println("maalesef böyle bir seçenek yok");
                selLoc = scan.nextInt();
            }

            switch (selLoc){
                case 1:
                    Location =new safeHause(Player);
                    break;
                case 2:
                    Location = new cave(Player);
                        break;
                case 3:
                    Location = new forest(Player);
                   break;

                case 4:
                    Location = new river(Player);
                    break;

                case 5:
                    Location = new toolStore(Player);
                    break;

                default:
                    Location = new safeHause(Player);
                    break;
            }

            if (Location.getClass().getName().equals("safeHause")){
                if(Player.getInv().isFirewood()&&Player.getInv().isFood()&&Player.getInv().isWater()){
                    System.out.println("vee macerayı tamamladın seni tebrik ediyorum artık usta bir savaşçısın kendine iyi bak");
                    break;
                }

            }
            if(!Location.getLocation()){
                System.out.println("game over");
                break;
            }
        }
    }
}
