package PhoneBook;
class PhoneBook {
    String ID;
    String name;
    String number;
    String email;
    PhoneBook(String i, String n, String num, String e){
        ID=i; name=n; number=num; email=e;
    }
}

class PhoneBookManager {
    public void insert(String i, String n, String num, String e) {  // 신규 회원 추가

    }
    public void delete(String i) {  // 관리번호로 삭제

    }
    public void modify(String n) { // 기존 회원의 전화번호 변경

    }
}

public class PhoneBookTest {
    public static void main(String[] args) {

    }
}
