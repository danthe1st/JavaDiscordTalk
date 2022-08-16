package amber.switchexpressions;

public class SwitchExpressions {
	public static void main(String[] args) {
		String s = "Hello";
		String obtained = switch (s) {
		case "Hello" -> "Hi";
		default -> {
			int len = s.length();
			yield "Some string with " + len + " characters";
		}
		};
		System.out.println(obtained);
	}
}
