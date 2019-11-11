package seleniumWrapper.Logger;

public class LogPieChart extends LogView{

	public LogPieChart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Cian
	 * @param int []
	 * @desc Displays test results in a "Pie chart" ;)
	 */
	@Override
	public void displayResults(int[] testStats) {
		System.out.println("THIS IS A BAR CHART");
		System.out.println("Total tests: "+testStats[0]);
		System.out.println("Passed tests: "+testStats[1]);
		System.out.println("Failed tests: "+testStats[2]);
		
	}

}
