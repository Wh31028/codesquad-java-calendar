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
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		System.out.println("반복횟수를 입력하세요.");
		int n =scanner.nextInt();
		
		int[] monthex = new int[n];
		System.out.println("월을 입력하세요.");
		for(int i=0;i<n;i++) {
			monthex[i] = scanner.nextInt();			
		}
		for(int i =0;i<n;i++) {
			System.out.println(monthex[i] + "월은 " + cal.getMaxDaysofMonth(monthex[i]) + "일까지 있습니다.");
		}

		
//		cal.printSampleCalendar();
		
		scanner.close();

	}

}
