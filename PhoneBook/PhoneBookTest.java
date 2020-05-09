package PhoneBook;

import java.util.InputMismatchException;
import java.util.Scanner;

class PhoneBook {
    String ID;
    String name;
    String number;
    String email;

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
        pb_cnt=1;
    }

    public void insert(String name, String num, String email) {  // 신규 회원 추가
        String id = Integer.toString(pb_cnt);
        pb[pb_cnt++] = new PhoneBook(id,name,num,email);
    }

    public void delete(String id) {  // 관리번호로 삭제
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            try {
//                pb[Integer.parseInt(id)].ID = "";
                pb[Integer.parseInt(id)].name = "";
                pb[Integer.parseInt(id)].number = "";
                pb[Integer.parseInt(id)].email = "";
                System.out.println(id + "번 삭제 완료\n");
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("없는 관리 번호 입니다! 다시 입력하세요");
                System.out.print("관리 번호 입력 : ");
                id = sc.nextLine();
            }
        }
    }

    public void modify(String id) { // 기존 회원의 전화번호 변경
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            try {
                System.out.println("관리 번호 : " + pb[Integer.parseInt(id)].ID + " / 이름 : " + pb[Integer.parseInt(id)].name + " / 전화번호 : " + pb[Integer.parseInt(id)].number + " / 이메일 :" + pb[Integer.parseInt(id)].email);
                System.out.print("바꿀 이름 입력 : ");
                pb[Integer.parseInt(id)].name = sc.nextLine();
                System.out.print("바꿀 전화번호 입력 : ");
                pb[Integer.parseInt(id)].number = sc.nextLine();
                System.out.print("바꿀 이메일 입력 : ");
                pb[Integer.parseInt(id)].email = sc.nextLine();
                System.out.println(id+"번 수정 완료\n");
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("없는 관리 번호 입니다! 다시 입력하세요");
                System.out.print("관리 번호 입력 : ");
                id = sc.nextLine();
            }
        }
    }

    public void findByid(String id) { // 관리 번호로 찾기
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            try {
                pb[Integer.parseInt(id)].ID = pb[Integer.parseInt(id)].ID;
                System.out.println("\n검색 결과 입니다.");
                System.out.println("관리 번호 : " + pb[Integer.parseInt(id)].ID + " / 이름 : " + pb[Integer.parseInt(id)].name + " / 전화번호 : " + pb[Integer.parseInt(id)].number + " / 이메일 :" + pb[Integer.parseInt(id)].email+"\n");
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("없는 관리 번호 입니다! 다시 입력하세요");
                System.out.print("관리 번호 입력 : ");
                id = sc.nextLine();
            }
        }
        while(true) {
            System.out.println("1. 전화번호 수정");
            System.out.println("2. 전화번호 삭재");
            System.out.println("3. 검색 종료");
            while (true) {
                try {
                    System.out.print("\n입력 : ");
                    input = sc.nextInt();
                    break;
                } catch (InputMismatchException ime) {  // 숫자가 아닌 다른것 입력 시 다시 입력 받도록 진행
                    System.out.println("올바른 숫자를 입력하세요!\n");
                    sc = new Scanner(System.in);
                }
            }
            if (input == 1) {
                System.out.println(id + "번 수정");
                modify(id);
                break;
            }
            else if (input == 2) {
                System.out.println(id + "번 삭제");
                delete(id);
                break;
            }
            else if (input == 3) {
                System.out.println("검색 종료\n");
                break;
            }
            else
                System.out.println("올바른 숫자를 입력하세요!\n");
        }
    }

    public void findByname(String name) { // 이름으로 찾기
        String id="";
        boolean find=false;

        for (int i=1;i<pb_cnt;i++)
            if (name.compareTo(pb[i].name) == 0) {
                id=Integer.toString(i);
                find=true;
                break;
            }

        if (find==false)
            System.out.println("찾는 이름이 없습니다.\n");
        else {
            System.out.println("관리 번호 : " + pb[Integer.parseInt(id)].ID + " / 이름 : " + pb[Integer.parseInt(id)].name + " / 전화번호 : " + pb[Integer.parseInt(id)].number + " / 이메일 :" + pb[Integer.parseInt(id)].email+"\n");
            int input;
            while (true) {
                System.out.println("1. 전화번호 수정");
                System.out.println("2. 전화번호 삭재");
                System.out.println("3. 검색 종료");
                while (true) {
                    try {
                        System.out.print("\n입력 : ");
                        input = sc.nextInt();
                        break;
                    } catch (InputMismatchException ime) {  // 숫자가 아닌 다른것 입력 시 다시 입력 받도록 진행
                        System.out.println("올바른 숫자를 입력하세요!\n");
                        sc = new Scanner(System.in);
                    }
                }
                if (input == 1) {
                    System.out.println(id + "번 수정");
                    modify(id);
                    break;
                } else if (input == 2) {
                    System.out.println(id + "번 삭제");
                    delete(id);
                    break;
                } else if (input == 3) {
                    System.out.println("검색 종료\n");
                    break;
                } else
                    System.out.println("올바른 숫자를 입력하세요!\n");
            }
        }
    }

    public void show() { // 전화번호부 출력
        for (int i=0;i<20;i++)
            System.out.print("-");
        System.out.print("전체 전화번호 표시");
        for (int i=0;i<20;i++)
            System.out.print("-");
        System.out.println();
        for (int i=1;i<pb_cnt;i++)
            System.out.println("관리 번호 : "+pb[i].ID+" / 이름 : "+pb[i].name+" / 전화번호 : "+pb[i].number+" / 이메일 :"+pb[i].email);
        System.out.println();
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
                    System.out.println("4. 전화번호 수정");
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
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.print("신규 회원 추가");
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.println();
                sc.nextLine();

                System.out.print("이름 입력 : ");
                String name = sc.nextLine();
                System.out.print("전화 번호 입력 : ");
                String num = sc.nextLine();
                System.out.print("이메일 입력 : ");
                String email = sc.nextLine();
                pbm.insert(name,num,email);
                System.out.println();
            }
            else if (input == 3) {
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.print("기존 회원 삭제");
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.println();
                sc.nextLine();

                System.out.print("관리 번호 입력 : ");
                String id = sc.nextLine();
                pbm.delete(id);
            }
            else if (input == 4) {
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.print("전화번호 수정");
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.println();
                sc.nextLine();

                System.out.print("관리 번호 입력 : ");
                String id = sc.nextLine();
                pbm.modify(id);
            }
            else if (input == 5) {
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.print("전화번호 검색");
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.println();

                while (true) { // 프로그램 반복
                    while (true) {  // 입력 예외처리
                        try {
                            System.out.println("1. 관리 번호로 검색");
                            System.out.println("2. 이름으로 검색");
                            System.out.print("\n입력 : ");
                            input = sc.nextInt();
                            break;
                        } catch (InputMismatchException ime) {  // 숫자가 아닌 다른것 입력 시 다시 입력 받도록 진행
                            System.out.println("올바른 숫자를 입력하세요!\n");
                            sc = new Scanner(System.in);
                        }
                    }
                    if (input == 1) {
                        for (int i=0;i<10;i++)
                            System.out.print("-");
                        System.out.print("관리 번호로 검색");
                        for (int i=0;i<10;i++)
                            System.out.print("-");
                        System.out.println();
                        sc.nextLine();

                        System.out.print("관리 번호 입력 : ");
                        String id = sc.nextLine();
                        pbm.findByid(id);
                        break;
                    }
                    else if (input == 2) {
                        for (int i=0;i<10;i++)
                            System.out.print("-");
                        System.out.print("이름으로 검색");
                        for (int i=0;i<10;i++)
                            System.out.print("-");
                        System.out.println();
                        sc.nextLine();

                        System.out.print("이름 입력 : ");
                        String name = sc.nextLine();
                        pbm.findByname(name);
                        break;
                    }
                    else
                        System.out.println("올바른 숫자를 입력하세요!\n");
                }
            }
            else if (input == 6) {
                for (int i=0;i<10;i++)
                    System.out.print("-");
                System.out.print("프로그램을 종료합니다.");
                for (int i=0;i<10;i++)
                    System.out.print("-");
                break;
            }
            else
                System.out.println("올바른 숫자를 입력하세요!\n");
        }
    }
}
