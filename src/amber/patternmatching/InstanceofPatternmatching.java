package amber.patternmatching;

public class InstanceofPatternmatching {
	public static void main(String[] args) {
		Object o = "Hello World";
		if (o instanceof String s && s.contains(" ")) {
			System.out.println("o is a String containing spaces");
		}
	}
}
