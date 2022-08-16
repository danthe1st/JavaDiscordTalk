package amber.patternmatching;

public class SwitchPatternmatching {
	public static void main(String[] args) {
		Object o = "abc";
		String description = switch (o) {
			case String s -> "o is a String: " + s;
			case null -> "o is null";
			default -> "o is something else: " + o.getClass().getCanonicalName();
		};
		System.out.println(description);
	}
}
