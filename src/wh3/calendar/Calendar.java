package wh3.calendar;
import java.util.Scanner;
public class Calendar {

	public static void main(String[] args) {
		System.out.println("  일 월  화  수 목  금 토");
		System.out.println("---------------------");
		for (int i = 1; i < 29; i++) {
			System.out.print((i < 10) ? "  " + i : " " + i);
			if (i % 7 == 0)
				System.out.println();
		}
		
		int monthDays[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner scanner = new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		int month =scanner.nextInt();
		System.out.println(month+"월은 "+monthDays[month]+"일까지 있습니다.");
		
		scanner.close();
		
		
		
	}

}
