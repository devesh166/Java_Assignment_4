package com.assignment.kyc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class KycDate {

	public static Date[] getRange(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		Date d[] = new Date[2];
		int diff = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
		startCal.add(Calendar.YEAR, diff);
		startCal.add(Calendar.DATE, -30);
		d[0] = startCal.getTime();
		startCal.add(Calendar.DATE, 60);
		Date temp = startCal.getTime();
		Date endtemp = endCal.getTime();
//		 System.out.println(endtemp+" "+temp);
		d[1] = endtemp.before(temp) ? endCal.getTime() : temp;

		return d;
	}

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		String[] inputDates = new String[count];
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		for (int j = 0; j < count; j++) {
			inputDates[j] = sc.nextLine();
		}

		for (int i = 0; i < count; i++) {
			String dates[] = inputDates[i].split(" ");
			Date startDate = null, endDate = null;
			startDate = dateformat.parse(dates[0]);
			endDate = dateformat.parse(dates[1]);

			if (endDate.before(startDate)) {
				System.out.println("No Range");
			} else {
				Date d[] = getRange(startDate, endDate);
				for (Date output : d) {
					System.out.print(dateformat.format(output) + " ");
				}
				System.out.println(" ");
			}

		}

	}

}
