package wh3.calendar;

import java.util.Scanner;

public class Calendar {
	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysofMonth(int month) {
		return MAX_DAYS[month - 1];

	}

	public void printSampleCalendar() {
		System.out.println("  일 월  화  수 목  금 토");
		System.out.println("---------------------");
		for (int i = 1; i < 29; i++) {
			System.out.print((i < 10) ? "  " + i : " " + i);
			if (i % 7 == 0)
				System.out.println();
		}
	}

	public static void main(String[] args) {
		String PROMPT = "cal>";
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;

		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1)
				break;
			if (month > 12)
				continue;
			System.out.println(month + "월은 " + cal.getMaxDaysofMonth(month) + "일까지 있습니다.");
		}

		System.out.println("Have a nice day!");

//		cal.printSampleCalendar();

		scanner.close();

	}

}
