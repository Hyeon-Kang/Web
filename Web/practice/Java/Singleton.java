public class Singleton {
  private static Singleton singleton = new Singleton();
  // 정적 초기선언

  private Singleton() {} // 외부에서 추가 생성 차단

  static Singleton getInstance() {
    return singleton;
  }
  // 외부에서 생성된 singleton 객체를 참조할 경우 결과 반환처리 함수
}
