package com.hemebiotech.analytics;

import java.util.Map;


/**
 *  Ecrit des données dans un fichier
 *   
 */

public interface ISymptomWriter {
	/**
	 *  Si la Map est vide, on créé pas de fichier
	 * 
	 * lire la collection et mettre le resutlat dans un fichier
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);

}

