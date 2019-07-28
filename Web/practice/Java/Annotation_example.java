//  car.java

public class Car {
  // 필드
  Tire frontLeftTire = new Tire ("앞 왼쪽", 6);
  Tire frontRightTire = new Tire ("앞 오른쪽", 2);
  Tire backLeftTire = new Tire ("뒤 왼쪽", 3);
  Tire backRightTire = new Tire ("뒤 오른쪽", 4);

  // 생성자

  // 메소드
  int run() {
    System.out.println("[자동차 주행 시작.]");
    if(frontLeftTire.roll()== false) {stop(); return 1; }
    .....
    return 0;
  }


  void stop() {
    System.out.println("[자동차 정지.]");
  }
}


// HankookTire.java (자식 클래스)

public class HankookTire extends Tire {
  // 필드
  // 생성자

  public HankookTire(String location, int maxRotation) {
    super(location, maxRotation);
  }

  // 메소드
  @Override    // 이처럼 오버라이드를 할 메소드에 어노테이션을 명시해줘야 컴파일러가 잘 판단할 수 있다.
  public boolean roll(){
    ++accmulatedRotation;
    if(accmulatedRotation < maxRotation) {
      System.out.println(location + "HankookTire 수명: " + (maxRotation-accmulatedRotation) + "회");
      return true;
    } else {
      System.out.println("*** " + location + " HankookTire 펑크 ***");
      return false;
    }
  }
}
