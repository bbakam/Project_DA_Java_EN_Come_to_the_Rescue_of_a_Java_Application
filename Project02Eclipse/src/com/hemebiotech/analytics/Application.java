package com.hemebiotech.analytics;

/**
 * 
 * @author bakarykamara
 *
 */
public class Application {

	/**
	 * 
	 * @param args chemin des fichiers d'entrée et de destination
	 * 
	 */
	public static void main(String[] args) {
		String inputFilePath = "Project02Eclipse/symptoms.txt";
		String outputFilePath = "Project02Eclipse/results.out";

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(inputFilePath, outputFilePath);
		analyticsCounter.readSymptoms();
		analyticsCounter.saveResult();
		System.out.println("Analyse effectuée. Résultats disponibles dans le fichier suivant: " + outputFilePath);
	}

}