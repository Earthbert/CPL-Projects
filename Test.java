public class Test {
	public static void main(String[] args) {
		String input = "\\a\\b\\c";
		String output = input.replaceAll("\\\\([a-zA-Z])", "$1");
		System.out.println(output);
	}
}
