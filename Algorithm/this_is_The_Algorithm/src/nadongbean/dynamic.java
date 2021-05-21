package nadongbean;

public class dynamic {

	static long[] list = new long[100];

	public static void main(String[] args) {
		System.out.println(recall(50));

	}

	public static long recall(int x) {
		long result = 0;
		if (x == 1 || x == 2) {
			return 1;
		} else {
			if (list[x] != 0) {
				return list[x];
			} else {
				list[x] = recall(x - 1) + recall(x - 2);
				return list[x];
			}

		}

	}
}
