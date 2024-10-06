package wh3.calendar;

public class Calendar {

	public static void main(String[] args) {
		System.out.println("  일 월  화  수 목  금 토");
		System.out.println("---------------------");
		for (int i = 1; i < 29; i++) {
			System.out.print((i < 10) ? "  " + i : " " + i);
			if (i % 7 == 0)
				System.out.println();
		}

	}

}
