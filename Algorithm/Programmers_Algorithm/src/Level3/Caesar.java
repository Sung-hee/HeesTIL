package Level3;

public class Caesar {
	String caesar(String s, int n) {
		String result = "";

		n = n % 26;
		char[] array = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			if (array[i] >= 'A' && array[i] <= 'Z') {
				if (array[i] + n > 90) {
					array[i] = (char) ((array[i] + n) - 26);
				} else
					array[i] = (char) (array[i] + n);
			} else if (array[i] >= 'a' && array[i] <= 'z') {
				if (array[i] + n > 122) {
					array[i] = (char) ((array[i] + n) - 26);
				} else
					array[i] = (char) (array[i] + n);
			}

			else if (array[i] == 32) {
				array[i] = 32;
			} else {
				array[i] = (char) (array[i] + n);
			}

		}
		for (int i = 0; i < s.length(); i++) {
			result += array[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
	}
}
