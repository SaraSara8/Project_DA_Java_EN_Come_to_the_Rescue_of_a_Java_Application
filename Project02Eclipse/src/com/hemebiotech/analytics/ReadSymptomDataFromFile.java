package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de interface ISymptomReader,
 * permet de lire un fichier de symptômes et met le résultant dans une liste non triée avec les doublons
 * 
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	final  String  filepath="./Project02Eclipse/symptoms.txt";
	
	
	/**
	 * 
	 * Constructeur de la classe ReadSymptomDataFromFile
	 */
	public ReadSymptomDataFromFile () {
		
	}
	
	
	/**************************
	 * 
	 * Lit les symptômes à partir du fichier symptômes et génère  une liste,
	 * si le fichier source est vide, on crée une liste vide
	 * @return Une liste de tous les symptômes lus du fichier d'entrée. Les doublons sont possibles
	 * 
	 ************************************/
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
