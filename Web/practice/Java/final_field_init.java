public class Person {
  final String nation = "Korea";
  final String ssn; // 해당 변수 존재만 선언해놓고 실 값은 이후 생성자에서 부여함
  String name;

  public Person(String ssn, String name){ // 여기서 final 속성 ssn에 파라미터 전달 (당연히 고정됨)
    this.ssn = ssn;
    this.name = name;
  }
}

public class PersonExample {
  public static void main(String[] args) {
    Person p1 = new Person("12344-12344", "김김");

    System.out.println(p1.nation);
    System.out.println(p1.ssm);
    System.out.println(p1.name);

    p1.name = "현";
  }
}
