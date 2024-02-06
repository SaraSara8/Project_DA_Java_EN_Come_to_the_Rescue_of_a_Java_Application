package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	/*******************************************

	 * Constructeur qui prend deux bojets ISymptomReader et  ISymptomWriter
	 
	*******************************************/
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	
	
	/*******************************************

	 *  méthode getSymptoms qui récupère la liste des entrées 
	 *  dans le fichier en utilisant l’instance de ISymptomReader
	 
	*******************************************/
	
	 public List<String> getSymptoms() { 
		 
		 return reader.GetSymptoms();
	 }
	
	 /*****************
	  * countSymptoms qui compte les occurrences
	  * de chaque symptôme existant
	  *****************************/
	 
	 public Map<String, Integer> countSymptoms(List<String> symptoms) { 
	
		 Map<String, Integer> result= new HashMap<String,Integer>();
		 
		 for (String s : symptoms){ 
			 
			 if (result.get(s) != null){
				 
			// le symptom existe dans la map
				 
				result.put(s, result.get(s) + 1);
				 
			 }else {
				 // symptom n'existe pas
				 
				 result.put(s, 1);
				 
			 }
			
		 }
		 
		 return result;
	 }
	 
	 /**********************
	  *  méthode sortSymptoms qui trie la liste de symptômes
	  *  et d’occurrences par ordre alphabétique ;
	  * @param symptoms
	  * @return map
	  */
	 
	 public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		 
		 Map<String, Integer> map= new TreeMap<String, Integer>(symptoms);
		 
		 
		 
		 return map;
	 }
	
	
	 
	 
	/*************
	 * écrit le résultat dans le fichier de sortie en utilisant 
	 * l’instance de ISymptomWriter déjà créée.
	 */
	 
	 public void writeSymptoms(Map<String, Integer> symptoms) { 
		 
		 writer.writeSymptoms(symptoms);
		 
	 }
	 
	 
	 
	 
	public static void main(String args[]) throws Exception {
		
	
		
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("./Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();
		int i = 0;	
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
