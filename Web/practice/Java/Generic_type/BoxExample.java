package generic_type;

public class BoxExample {

	public static void main(String[] args) {
		Box <Integer> box = new Box<Integer> ();

		System.out.println("box.set : " + 4);
		box.set(4);
		System.out.println("box.get : " + box.get());

		Box <String> box1 = new Box <String> ();

		System.out.println("box.set : " + "hello");
		box1.set("hello");
		System.out.println("box.get : " + box1.get());
	}

}
