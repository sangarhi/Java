package test;

public class Test {

	public static void main(String[] args) {

		System.out.println(maskify("4556364607935616"));
		System.out.println(maskify("64607935616"));
		System.out.println(maskify("1"));
		System.out.println(maskify(""));
		System.out.println(maskify("Skippy"));
		System.out.println(maskify("Nananananananananananananananana Batman!"));

	}

	public static String maskify(String str) {
		int len = str.length();
		int aux = len - 4;
		StringBuilder nstr = new StringBuilder(str);
		for (int i = 0; i < aux; i++) {
			nstr.setCharAt(i, '#');
		}
		str = nstr.toString();
		return str;
	}

}
