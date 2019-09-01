package multi_parameter_generic_method;

public class CompareMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pair <Integer, String> p1 = new Pair<> (1, "사과"); // 다이아몬드 연산자 빼먹지 않게 주의!!
		Pair <Integer, String> p2 = new Pair<> (2, "바나나");
		Pair <Integer, String> p3 = new Pair<> (2, "바나나");

		boolean result = Util.compare(p1, p2); // 컴파일러가 파라미터의 타입을 보고 타입 파라미터 값을 유추함


		System.out.println("p1, p2 두 객체는 같습니까? : "+result);
		System.out.println("p2, p3 두 객체는 같습니까? : "+Util.compare(p2, p3));

	}

}
