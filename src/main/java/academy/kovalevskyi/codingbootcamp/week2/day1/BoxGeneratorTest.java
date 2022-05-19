package academy.kovalevskyi.codingbootcamp.week2.day1;

import java.util.Random;

public class BoxGeneratorTest {

	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		printer2WithEmptySecondArgument();
	}

	private static String rndAlphaNumRandString() {
		return ((StringBuilder)RANDOM.ints((long)RANDOM.nextInt(62), 48, 123).filter((i) -> {
			return (i <= 57 || i >= 65) && (i <= 90 || i >= 97);
		}).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)).toString();
	}


	public static void printer2WithEmptySecondArgument() {
		String symbol = "";
		String text = rndAlphaNumRandString();
		String s = expectedString(symbol, text);
		System.out.println(s);
		TextPrinter2.main(new String[]{symbol, text});
	}

	private static String expectedString(String symbol, String text) {
		if (symbol.length() > 1) {
			return "First arguments length should be 0 or 1, now it is: %d\n".formatted(new Object[]{symbol.length()});
		} else {
			String repeat = symbol.repeat(text.length() + 4);
			return "%s\n%s %s %s\n%s\n".formatted(new Object[]{repeat, symbol, text, symbol, repeat});
		}
	}
}
