package string;

public class ToUpperOrLowerCaseDemo {
	public static void main(String[] args) {
		String str = "我爱Java";
		
		String upper = str.toUpperCase();
		System.out.println(upper);
		String lower = str.toLowerCase();
		System.out.println(lower);
		
		String code = "3C5h";
		String line = "3c5h";
		boolean match = code.toUpperCase().equals(line.toUpperCase());
		if (match) {
			System.out.println("Match");
		}
	}
}
