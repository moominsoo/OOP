package PhoneBook;

import java.util.InputMismatchException;
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

    public void insert(String name, String num, String email) {  // 신규 회원 추가
        pb_cnt++;
        String id = Integer.toString(pb_cnt);
        pb[pb_cnt] = new PhoneBook(id,name,num,email);
    }
    public void delete() {  // 관리번호로 삭제
        String id = sc.nextLine();

    }
    public void modify(int i) { // 기존 회원의 전화번호 변경
        String num = sc.nextLine();
        pb[i].number = num;
    }
    public void show() { // 전화번호부 출력
        for (int i=0;i<pb_cnt;i++)
            System.out.println(pb[i]);
    }
    public void findByid() { // 관리 번호로 찾기
        System.out.print("\n관리 번호 입력 : ");
        String id = sc.nextLine();
        for (int i=0;i<pb_cnt;i++) {
            if (id.compareTo(pb[i].ID) == 0)
                System.out.println(pb[i]);
                System.out.println("1. 전화번호 수정");
                System.out.println("2. 전화번호 삭재");
                System.out.println("3. 검색 종료");

        }
    }
    public void findByname() { // 이름으로 찾기
        System.out.print("\n이름 입력 : ");
        String name = sc.nextLine();
        for (int i=0;i<pb_cnt;i++) {
            if (name.compareTo(pb[i].ID) == 0)
                System.out.println(pb[i]);
            System.out.println("1. 전화번호 수정");
            System.out.println("2. 전화번호 삭재");
            System.out.println("3. 검색 종료");

        }
    }
}

public class PhoneBookTest {
    public static void main(String[] args) {
        PhoneBookManager pbm = new PhoneBookManager();
        Scanner sc = new Scanner(System.in);

        String[] nameData ={"MGBRI","SVZSZ","VHJMG","TTARA","MZLQJ","YTLNZ","XMFSC","BBAHD","PWUMM","OLMST","GJHUX","PJXRQ","HZBOH","IZNCD","BRKRB","RZPYU","KIKQW","PAWVH","KCSXQ","FCJIE"};
        String[] numberData = {"017-4631-1167","016-964-7215","013-9122-7752","014-2854-2748","019-3371-6737","011-9485-1060","016-3717-6668","019-7079-5734","017-8682-3018","019-4199-3540","010-8424-2485","016-6384-655","019-8708-1824","010-8803-1940","014-309-6233","019-8661-8255","010-5618-8642","011-6836-7177","011-1306-35","013-8942-7379"};
        String[] emailData = {"apple@yahoo.com","zet@naver.com","pink@naver.com","pepper@naver.com","air@naver.com","yellow@gmail.com","drop@naver.com","coffee@gmail.com","nine@yahoo.com","friday@gmail.com","elephant@yahoo.com","rabbit@naver.com","blue@naver.com","white@naver.com","black@naver.com","queen@gmail.com","nick@naver.com","simple@gmail.com","zoe@yahoo.com","kdney@gmail.com"};
        // 미리 만들어 둔 데이터 20개

        for (int i=0;i<20;i++)
            pbm.insert(nameData[i],numberData[i],emailData[i]);

        int input;
        while(true) { // 프로그램 반복
            while (true) {  // 입력 예외처리
                try {
                    System.out.println("1. 전체 전화번호 표시");
                    System.out.println("2. 신규 회원 추가");
                    System.out.println("3. 기존 회원 삭제");
//                    System.out.println("4. 전화번호 수정");
                    System.out.println("5. 전화번호 검색");
                    System.out.println("6. 프로그램 종료");

                    System.out.print("\n입력 : ");
                    input = sc.nextInt();
                    break;
                } catch (InputMismatchException ime) {  // 숫자가 아닌 다른것 입력 시 다시 입력 받도록 진행
                    System.out.println("올바른 숫자를 입력하세요!\n");
                    sc = new Scanner(System.in);
                }
            }
            if (input == 1)

                pbm.show();
            else if (input == 2) {
                String name = sc.nextLine();
                String num = sc.nextLine();
                String email = sc.nextLine();
                pbm.insert(name,num,email);
            }
            else if (input == 3)
                pbm.delete();
//            else if (input == 4)
//                pbm.modify();
            else if (input == 5) {
                System.out.println("1. 관리 번호로 검색");
                System.out.println("2. 이름으로 검색");
                System.out.print("\n입력 : ");
                input = sc.nextInt();
                if (input==1)
                    pbm.findByid();
                else if (input==2)
                    pbm.findByname();
            }
            else if (input == 6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else
                System.out.println("올바른 숫자를 입력하세요!\n");
        }
    }
}
