package com.hemebiotech.analytics;

import java.util.HashMap;
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
		// TODO Auto-generated method stub
		
		

		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile();
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile();
		
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		
		// lire le fichier symptoms et le mettre dans une liste
		
		
	
		List<String> symptoms = counter.getSymptoms();
		
	

        // on compte les symptom et on crer dans la Map 
		//avec lés comme symptom et valeur comme compteur	
		
		Map<String, Integer> mapSymptoms = counter.countSymptoms(symptoms);
		
		
		
		// Trier la map
		
		
		Map<String, Integer> resultMap = counter.sortSymptoms(mapSymptoms);
		

		
		//ecrire dans le fihcier resultat
		
		counter.writeSymptoms(resultMap);
		

	}

}
