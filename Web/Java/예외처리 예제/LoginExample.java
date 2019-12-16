
public class LoginExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			login("white", "12345");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			login("blue", "54321");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void login(String id, String password) {

		if (!id.equals("blue")) {
			throw new NotExistIDException("아이디가 존재하지 않습니다.");
		}

		if (!password.equals("12345")) {
			throw new NotExistIDExepton("패스워드가 일치하지 않습니다.");
		}
	}

}
