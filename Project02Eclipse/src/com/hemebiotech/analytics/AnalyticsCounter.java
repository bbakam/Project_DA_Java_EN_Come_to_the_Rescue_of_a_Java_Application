package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author bakarykamara
 * @version
 *
 *          AnalyticsCounter
 */
public class AnalyticsCounter implements ISymptomReader {
	private String inputFilePath;
	private String outputFilePath;
	Map<String, Integer> symptomsOccurence = new TreeMap<String, Integer>();

	/**
	 * 
	 * @see analyse
	 */
	public void analyze() {
		readSymptoms();
	}

	@Override
	public void saveResult() {
		try (FileWriter writer = new FileWriter(outputFilePath);) {
			for (Map.Entry<String, Integer> entry : symptomsOccurence.entrySet()) {
				writer.write(entry.getKey() + "," + entry.getValue() + "\n");
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de la sauvegarde du fichier " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param inputFilePath
	 * 
	 * @param outputFilePath
	 */
	public AnalyticsCounter(String inputFilePath, String outputFilePath) {
		super();
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
	}

	@Override
	public Map<String, Integer> readSymptoms() {
		try (BufferedReader reader = new BufferedReader(new FileReader(this.inputFilePath));) {
			String line = reader.readLine();
			while (line != null) {
				if (symptomsOccurence.containsKey(line)) {
					symptomsOccurence.put(line, symptomsOccurence.get(line) + 1);
				} else {
					symptomsOccurence.put(line, 1);
				}
				line = reader.readLine();
			}
		} catch (Exception e) {
			System.out.println("Le fichier n'a pas pu être lu " + e.getMessage());
		}
		return symptomsOccurence;
	}
}