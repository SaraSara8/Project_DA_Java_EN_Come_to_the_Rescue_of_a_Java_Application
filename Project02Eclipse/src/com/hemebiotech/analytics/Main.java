package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;

/********
 * Lance les étapes successives de l'application
 */

public class Main {

	/*******
	 * Méthode main
	 * @param args arguments de la méthode main
	 */
	
	public static void main(String[] args) {
		
		
		System.out.println("lancement du programme");

		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile();
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile();
		
		AnalyticsCounter analyseCounter = new AnalyticsCounter(reader, writer);
		
		// lire le fichier symptoms et le mettre dans une liste
		
		
	
		List<String> symptoms = analyseCounter.getSymptoms();
		
	

        // On compte les symptômes et on crée dans la Map 
		//avec clés comme symptom et valeur comme compteur	
		
		Map<String, Integer> mapSymptoms = analyseCounter.countSymptoms(symptoms);
		
		
		
		// Trier la map
		
		
		Map<String, Integer> resultMap = analyseCounter.sortSymptoms(mapSymptoms);
		

		
		//écrire dans le fichier résultat
		
		analyseCounter.writeSymptoms(resultMap);
		System.out.println("fin  du programme ");
		

	}

}
