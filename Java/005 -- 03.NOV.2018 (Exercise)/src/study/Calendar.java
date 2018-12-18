package study;

import java.util.Scanner;

public class Calendar {

	// Input name of month and see that month's calendar for 2018
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input the NUMBER of the month you would like to see : ");
		int choice = scan.nextInt();
		
		char[] MakeWeek = makeWeekdays();
		int[][] Month = makeMonth(choice);
		getMonth(choice, Month, MakeWeek);
	}
	
	private static void getWeekdays(char[] weekday) {
		for(int i = 0; i < 7; i++) {
			System.out.printf("%3c", weekday[i]);
		}
	}
		
	private static char[] makeWeekdays() {
		char[] weekday;
		weekday = new char[] {'S', 'M', 'T', 'W', 'T', 'F', 'S'};
		// '일' --> char
		//  일    --> 변수명 --> 여기서는 이런 변수 없다고 에러난 것
		return weekday;
	}
	
	private static int[][] makeMonth(int choice) {
		int[][] month = null;
		switch (choice) {
			case 1:
				month = makeJanuary();
				break;
			case 2:
				month = makeFebruary();
				break;
			case 3:
				month = makeMarch();
				break;
			case 4:
				month = makeApril();
				break;
			case 5:
				month = makeMay();
				break;
			case 6:
				month = makeJune();
				break;
			case 7:
				month = makeJuly();
				break;
			case 8:
				month = makeAugust();
				break;
			case 9:
				month = makeSeptember();
				break;
			case 10:
				month = makeOctober();
				break;
			case 11:
				month = makeNovember();
				break;
			case 12:
				month = makeDecember();
				break;
		}
		return month;
	}
	
	private static void getMonth(int choice, int[][] month, char[] weekdays) {
		switch (choice) {
		case 1:
			getJanuary(month, weekdays);
			break;
		case 2:
			getFebruary(month, weekdays);
			break;
		case 3:
			getMarch(month, weekdays);
			break;
		case 4:
			getApril(month, weekdays);
			break;
		case 5:
			getMay(month, weekdays);
			break;
		case 6:
			getJune(month, weekdays);
			break;
		case 7:
			getJuly(month, weekdays);
			break;
		case 8:
			getAugust(month, weekdays);
			break;
		case 9:
			getSeptember(month, weekdays);
			break;
		case 10:
			getOctober(month, weekdays);
			break;
		case 11:
			getNovember(month, weekdays);
			break;
		case 12:
			getDecember(month, weekdays);
			break;
		}
	}
	
	private static int[][] makeJanuary() {
		// Make the month of January in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		january : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && j == 0) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 31) {
					break january;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeFebruary() {
		// Make the month of February in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		february : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 3)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 28) {
					break february;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeMarch() {
		// Make the month of March in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		march : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 3)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 31) {
					break march;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeApril() {
		// Make the month of April in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		april : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				month[i][j] = day;
				day++;
				if (day > 30) {
					break april;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeMay() {
		// Make the month of May in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		may : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 1)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 31) {
					break may;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeJune() {
		// Make the month of June in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		june : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 4)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 30) {
					break june;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeJuly() {
		// Make the month of July in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		july : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				month[i][j] = day;
				day++;
				if (day > 31) {
					break july;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeAugust() {
		// Make the month of August in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		august : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 2)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 31) {
					break august;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeSeptember() {
		// Make the month of September in calendar format
		int day = 1;
		int[][] month = new int[6][7];

		september : for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 5)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 30) {
					break september;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeOctober() {
		// Make the month of October in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		october : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && j == 0) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 31) {
					break october;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeNovember() {
		// Make the month of November in calendar format
		int day = 1;
		int[][] month = new int[5][7];

		november : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 3)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 30) {
					break november;
				}
			}
		}
		return month;
	}
	
	private static int[][] makeDecember() {
		// Make the month of December in calendar format
		int day = 1;
		int[][] month = new int[6][7];

		december : for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if(i == 0 && (j >= 0 && j <= 5)) {
					continue;
				} else {
					month[i][j] = day;
					day++;
				}
				if (day > 31) {
					break december;
				}
			}
		}
		return month;
	}
	
	private static void getJanuary(int[][] month, char[] weekdays) {
		// Print the month of January in calendar format
		System.out.println("January 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 4 && j > 3) || (i == 0 && j == 0)) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getFebruary(int[][] month, char[] weekdays) {
		// Print the month of February in calendar format
		System.out.println("February 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 4 && j > 3) || (i == 0 && (j >= 0 && j <= 3))) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getMarch(int[][] month, char[] weekdays) {
		// Print the month of March in calendar format
		System.out.println("March 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if (i == 0 && (j >= 0 && j <= 3)) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getApril(int[][] month, char[] weekdays) {
		// Print the month of April in calendar format
		System.out.println("April 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if (i == 4 && j > 1) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getMay(int[][] month, char[] weekdays) {
		// Print the month of May in calendar format
		System.out.println("May 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 4 && j > 4) || (i == 0 && (j >= 0 && j <= 1))) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getJune(int[][] month, char[] weekdays) {
		// Print the month of June in calendar format
		System.out.println("June 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if (i == 0 && (j >= 0 && j <= 4)) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getJuly(int[][] month, char[] weekdays) {
		// Print the month of July in calendar format
		System.out.println("July 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if (i == 4 && j > 2) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getAugust(int[][] month, char[] weekdays) {
		// Print the month of August in calendar format
		System.out.println("August 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 4 && j > 5) || (i == 0 && (j >= 0 && j <= 2))) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getSeptember(int[][] month, char[] weekdays) {
		// Print the month of September in calendar format
		System.out.println("September 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 5 && j > 0) || (i == 0 && (j >= 0 && j <= 5))) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getOctober(int[][] month, char[] weekdays) {
		// Print the month of October in calendar format
		System.out.println("October 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 4 && j > 3) || (i == 0 && j == 0)) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getNovember(int[][] month, char[] weekdays) {
		// Print the month of November in calendar format
		System.out.println("November 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 4 && j > 5) || (i == 0 && (j >= 0 && j <= 3))) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void getDecember(int[][] month, char[] weekdays) {
		// Print the month of December in calendar format
		System.out.println("December 2018 : ");
		getWeekdays(weekdays);
		System.out.println();
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if ((i == 5 && j > 1) || (i == 0 && (j >= 0 && j <= 5))) {
					System.out.print("   ");
				} else {
					System.out.printf("%3d", month[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
