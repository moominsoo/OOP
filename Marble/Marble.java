package Marble;
class Player {
    int balance;
    int loc;
    Player(){
        this.balance=5000;
        this.loc=0;
    }
}

class City {
    String name;
    String owner;
    int price;
    String[] room;
    City(){
        this.name=""; this.owner = "empty"; this.price = 300; this.room = new String[2];
    }
    City(String n){
        this.name=n; this.owner="empty"; this.price=300; this.room=new String[2];
    }

}

class Game {
    City[] city;
    String[] cityname = {"START","Seoul","Tokyo","Sydney","LA","Cairo","Phuket","New delhi","Hanoi","Paris"};

    Game() {
        this.city=new City[10];
    }
    void cityinput(){
        for(int i=0; i<10; i++)
            city[i] = new City(cityname[i]);
    }
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
        }
    }
}
