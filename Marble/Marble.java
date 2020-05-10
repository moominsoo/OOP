package Marble;
class Player {
    static int cnt=0; // 플레이어 수
    String name;
    int balance;
    int loc;

    Player(){
        this.name=Integer.toString(++cnt);
        this.balance=5000;
        this.loc=0;
    }
}

class City {
    String name;
    String owner;
    int price;
    String[] room;
//    City(){
//        this.name=""; this.owner = "empty"; this.price = 300; this.room = new String[2];
//    }
    City(String n){
        this.name=n; this.owner="empty"; this.price=300; this.room=new String[2];
        room[0]="";room[1]="";
    }

}

class Game {
    City[] city;
    int dice;

    String[] cityname = {"START","Seoul","Tokyo","Sydney","LA","Cairo","Phuket","New delhi","Hanoi","Paris"};

    Game() {
        this.city=new City[10];
        this.dice=0;
    }

    void cityinput(){
        for(int i=0; i<10; i++)
            city[i] = new City(cityname[i]);
        this.city[0].owner="None";
    }

    void move(Player p){
        for (int i=0;i<2;i++)   // 주사위를 굴려 이동하므롤 city에 있는거 제거
            if (city[p.loc].room[i].equals(p.name))
                city[p.loc].room[i]="";

        dice=(int)(Math.random()*6+1); // 1~6까지의 수 랜덤
        System.out.println("Player "+p.name+" got "+dice);
        p.loc+=dice;
        if (p.loc>=10)
            p.loc-=10;
        System.out.println(city[p.loc].name+"("+city[p.loc].owner+")");

        for (int i=0;i<2;i++)
            if (city[p.loc].room[i].equals("")) {
                city[p.loc].room[i] = p.name;
                break;
            }
    }

    void bulid(Player p) {
        if (city[p.loc].owner.equals("empty")) {
            if (p.balance>=300) {
                city[p.loc].owner = p.name;
                System.out.println("Player "+p.name+" buys "+city[p.loc].name);
                p.balance-=city[p.loc].price;
                System.out.println("Player "+p.name+"'s balance is "+p.balance);
                // player 1’s balance is 4700.
            }
            else {
                ;
            }
        }
        else if (!city[p.loc].owner.equals(p.name)) {// 내 땅이 아니면 통행료 지불
            ;
        }

    }

//    void toll(int i){
//        if ("p1".compareTo(city[i].owner) == 0){
//            p1.balance+=600;
//            p2.balance-=600;
//        }
//    }

}

public class Marble {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Player p1 = new Player();
        Player p2 = new Player();
        Game g = new Game();
        g.cityinput();

        int turn = 30;
        for (int i=0;i<turn;i++)
        {
            System.out.println("Turn "+(i+1));
            g.move(p1);
            g.bulid(p1);
            System.out.println();

            g.move(p2);
            g.bulid(p2);
            System.out.println();
        }
    }
}
