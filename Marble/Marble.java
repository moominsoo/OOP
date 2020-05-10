package Marble;

import java.util.Arrays;

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

    City(String n){
        this.name=n; this.owner="empty"; this.price=300; this.room=new String[Player.cnt];
        Arrays.fill(room,"");
    }

}

class Game {
    City[] city;
    int dice;
    static int pay=0;

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

        if (pay!=0) {
            p.balance += pay;
            pay=0;
        }

        if (city[p.loc].owner.equals("empty")) {
            if (p.balance>=300) {
                city[p.loc].owner = p.name;
                System.out.println("Player "+p.name+" buys "+city[p.loc].name);
                p.balance-=city[p.loc].price;
                System.out.println("Player "+p.name+"'s balance is "+p.balance);
            }
            else {
                System.out.println("Can't buy "+city[p.loc].name);
                System.out.println("Player "+p.name+"'s balance is "+p.balance);
            }
        }
        else if (city[p.loc].owner.equals(p.name))
            System.out.println("Player "+p.name+"'s balance is "+p.balance);
        else if (city[p.loc].owner.equals("None"))
            System.out.println("Player "+p.name+"'s balance is "+p.balance);
        else { // 내 땅이 아니면 통행료 지불
            toll(p);
        }
    }

    void toll(Player p){
        System.out.println("LUCKY! Opponent get 600 MONEY!!");
        p.balance-=600;
        pay=600;
        if (p.balance<0) {
            System.out.println("Player "+p.name+" bankruptcy!");
            System.out.println("GAME OVER");
            System.exit(0);
        }
        else
            System.out.println("Player "+p.name+"'s balance is "+p.balance);
    }

}

public class Marble {
    public static void main(String[] args) {

        Player p1 = new Player();
        Player p2 = new Player();
        Game g = new Game();
        g.cityinput();

        int turn = 30;
        for (int i=0;i<turn;i++)
        {
            for (int j=0;j<15;j++)
                System.out.print("-");
            System.out.print("Turn "+(i+1));
            for (int j=0;j<15;j++)
                System.out.print("-");
            System.out.println();

            g.move(p1);
            g.bulid(p1);
            System.out.println();

            g.move(p2);
            g.bulid(p2);
            System.out.println();
        }
        if (p1.balance>p2.balance)
            System.out.println("Winner is Player 1!");
        else if (p1.balance<p2.balance)
            System.out.println("Winner is Player 2!");
        else
            System.out.println("DRAW");

        System.out.println("GAME OVER");
    }
}
