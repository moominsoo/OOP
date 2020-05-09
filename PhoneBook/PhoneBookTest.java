package PhoneBook;
class PhoneBook {
    String ID;
    String name;
    String number;
    String email;

    PhoneBook(){}
    PhoneBook(String i, String n, String num, String e){
        ID=i; name=n; number=num; email=e;
    }
}

class PhoneBookManager {
    public void insert(String i, String n, String num, String e) {  // 신규 회원 추가


    }
    public void delete(String i) {  // 관리번호로 삭제

    }
    public void modify(String i) { // 기존 회원의 전화번호 변경

    }
    public void show() { // 전화번호부 출력

    }
    public void findByid(String i) { // 관리 번호로 찾기

    }
    public void findByname(String name) { // 이름으로 찾기

    }

}

public class PhoneBookTest {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

    }
}
