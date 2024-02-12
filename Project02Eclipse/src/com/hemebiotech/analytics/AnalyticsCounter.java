package com.hemebiotech.analytics;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/******
 * Lit la liste des symptômes et compte le nombre d'occurence par symptôme 
 * et le résutat est écrit dans une Map triée 
 */

public class AnalyticsCounter {
			
	
	private ISymptomReader reader;
	private ISymptomWriter writer;

	
	/*************************************************************************

	 * Constructeur qui prend deux objets 
	 @param reader objet  ISymptomReader
	 @param writer objet  ISymptomWriter
	 
	**************************************************************************/
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	
	
	/**************************
	 * 
	 * Appel la méthode GetSymptoms de ISymptomReader qui lit les symptômes à partir du fichier source et génère  une liste, 
	 * si le fichier source est vide, on crée une liste vide
	 * @return Une liste de tous les symptômes lus du fichier d'entrée. Les doublons sont possibles
	 * 
	 ************************************/
	
	 public List<String> getSymptoms() { 
		 
		 return reader.GetSymptoms();
	 }
	
	 /*************************************************************************
	  
	  * Parcours une liste de symptômes, 
	  * compte le nombre de fois qu'un symptôme est présent dans la liste, 
	  * puis alimente une Map dont la clé (String) ==>le sympôme et la valeur (Integer) ==> nombre d'occurance du symptôme dans la liste source
	  * @param symptoms Liste des symptômes
	  * @return Une Map non triée dont la clé correspond au symptôme et la  valeur correspond au nombre d'occurence du symptôme
	  
	  **************************************************************************/
	 
	 public Map<String, Integer> countSymptoms(List<String> symptoms) { 
	
		 Map<String, Integer> result= new HashMap<String,Integer>();
		 
		 for (String s : symptoms){ 
			 
			 if (result.get(s) != null){
				 
			// le symptom existe dans la map : c'est une modification
				 
				result.put(s, result.get(s) + 1);
				 
			 }else {
				 // symptom n'existe pas : c'est une création 
				 
				 result.put(s, 1);
				 
			 }
			
		 }
		 
		 return result;
	 }
	 
	 /*************************************************************************
	  * Trie une Map à partir de la clé par ordre alphabétique
	  * @param symptoms une Map composée de clé symptôme et valeur : nombre d'occurence du symptôme
	  * @return une TreeMap clonée à partir de la map source.
	  **************************************************************************/
	 
	 public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		 
		 Map<String, Integer> map= new TreeMap<String, Integer>(symptoms);
		 
		 
		 
		 return map;
	 }
	
	
	 
	 
	 /*************************************************************************
	 * Fait appel à la méthode writeSymptoms de ISymptomWriter,
	 * lit une Map triée et écrit ligne par ligne dans le fichier de sortie
	 * la ligne est formatée comme suit "clé : valeur" 
	 * @param symptoms une Map composée de clé symptôme et valeur nombre d'occurence du symptôme
	 **************************************************************************/
	 
	 public void writeSymptoms(Map<String, Integer> symptoms) { 
		 
		 writer.writeSymptoms(symptoms);
		 
	 }
	 
	 
	 
	
}
