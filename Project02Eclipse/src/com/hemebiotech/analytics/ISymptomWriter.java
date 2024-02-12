package com.hemebiotech.analytics;

import java.util.Map;


/**
 *  Ecrit la liste des symptômes (Map) dans un fichier,
 *  si la liste des symptômes est vide, le ficher sera crée vide
 *  
 *   
 */

public interface ISymptomWriter {
	
	 /*************************************************************************
		 * Lit une Map et écrit le resutlat dans fichier destination
		 * si la Map est vide , le fichier sera crée vide 
		 * @param symptoms une Map composée de clé symptôme et valeur nombre d'occurence du symptôme
		 **************************************************************************/
	public void writeSymptoms(Map<String, Integer> symptoms);

}

