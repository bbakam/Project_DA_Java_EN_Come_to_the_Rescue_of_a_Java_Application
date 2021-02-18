package com.hemebiotech.analytics;

public class Application {

	public static void main(String[] args) {
		String inputFilePath = "Project02Eclipse/symptoms.txt";
		String outputFilePath = "Project02Eclipse/results.out";

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(inputFilePath, outputFilePath);
		System.out.println("La liste des symptomes et des occurences" + outputFilePath);

	}

}
