public class SingletonExample {
  public static void main(String[] args) {
    /*
    // 외부에서 싱글톤 객체가 생성 되는지 테스트
    Singleton Sobj1 = new Singleton();
    Singleton Sobj2 = new Singleton();

    // 당연히 컴파일 에러 발생
    */

    Singleton obj1 = Singleton.getInstance();
    Singleton obj2 = Singleton.getInstance();

    // 싱글톤 객체를 참조한 obj1, 2 가 동일한지 검사
    if(obj1 == obj2) {
      System.out.println("같은 객체입니다.");
    } else {
      System.out.println("다른 객체입니다.");
    }
  }
}

// 프로그램 실행 결과 같은 객체 확인.
