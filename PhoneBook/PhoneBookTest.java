package PhoneBook;

import java.util.Scanner;

class PhoneBook {
    String ID;
    String name;
    String number;
    String email;

    PhoneBook(){}
    PhoneBook(String i, String n, String num, String e){
        this.ID=i; this.name=n; this.number=num; this.email=e;
    }
}

class PhoneBookManager {
    PhoneBook[] pb;
    static int pb_cnt;
    Scanner sc = new Scanner(System.in);

    public PhoneBookManager(){
        pb=new PhoneBook[100];
        pb_cnt=0;
    }

    public void insert() {  // 신규 회원 추가
        pb_cnt++;
        String id = Integer.toString(pb_cnt);
        String name = sc.nextLine();
        String num = sc.nextLine();
        String email = sc.nextLine();
        pb[pb_cnt] = new PhoneBook(id,name,num,email);
    }
    public void delete() {  // 관리번호로 삭제

    }
    public void modify() { // 기존 회원의 전화번호 변경

    }
    public void show() { // 전화번호부 출력

    }
    public void findByid() { // 관리 번호로 찾기

    }
    public void findByname() { // 이름으로 찾기

    }

}

public class PhoneBookTest {
    public static void main(String[] args) {
        String[] nameData ={};
        String[] numberData = {};

        PhoneBook pb = new PhoneBook();
        Scanner sc = new Scanner(System.in);

        for (int i=0; i < 20; ++i){
            insert(nameData[i], numberData[i]);
        }

        while(true) {
        System.out.println("1. 전체 전화번호 표시");
        System.out.println("2. 신규 회원 추가");
        System.out.println("3. 기존 회원 삭제");
        System.out.println("4. 전화번호 수정");
        System.out.println("5. 전화번호 검색");
        System.out.println("6. 프로그램 종료");

            int input = sc.nextInt();

            if (input == 1)
                ;
            else if (input == 2)
                ;
            else if (input == 3)
                ;
            else if (input == 4)
                ;
            else if (input == 5) {
                System.out.println("1. 관리 번호로 검색");
                System.out.println("2. 이름으로 검색");
            }
            else if (input == 6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
