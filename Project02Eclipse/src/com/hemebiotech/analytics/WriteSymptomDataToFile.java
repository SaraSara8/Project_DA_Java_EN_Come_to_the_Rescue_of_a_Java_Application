package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;



/** 
 * Implémentation de l'interface ISymptomWriter,
 * écrit la liste des symptômes (Map) dans un fichier,
 * si la liste des symptômes est vide, le ficher sera crée vide
 *  
 *   
 */ 

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	final  String  filepath="./Project02Eclipse/result.out.txt";
	
	/**
	 * Constructeur de la classe WriteSymptomDataToFile
	 *
	 */
	
	
	
	 /*************************************************************************
		 * Lit une Map est écrit le résutlat dans fichier destination
		 * si la Map est vide , le fichier sera créé vide 
		 * @param symptoms Une Map composée de clé symptome et valeur : nombre d'occurence du symptôme
		 **************************************************************************/

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		
			
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
			
			String ligne;
				
			for (Map.Entry<String, Integer> objEncours : symptoms.entrySet()) {
					
				ligne =objEncours.getKey() + ":" + objEncours.getValue();
				
				writer.write(ligne);
				
				writer.write("\n");
			}
				
		writer.close();
				
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}

