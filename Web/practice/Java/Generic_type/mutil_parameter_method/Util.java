package multi_parameter_generic_method;

// 멀티 파라미터 제네릭 메소드 예제
public class Util {
	public static <K, V> boolean compare(Pair<K, V>p1, Pair<K, V> p2) {

		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());


		return keyCompare && valueCompare;


	}

}
