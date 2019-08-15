package src;

import org.automationtesting.excelreport.Xl;

import com.sun.jna.platform.unix.X11.XLeaveWindowEvent;

public class GenerateReport {

	public static void main(String[] args) throws Exception {
		Xl.generateReport("ExcelReport.xlsx");

	}

}
