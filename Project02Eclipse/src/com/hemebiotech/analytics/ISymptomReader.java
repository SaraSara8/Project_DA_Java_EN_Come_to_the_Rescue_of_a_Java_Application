package com.hemebiotech.analytics;

import java.util.List;

/**
 * Lit les données à partir d'une source donnée,
 * elle retourne une liste de chaines pouvant contenir des doublons,
 * l'implémentation n'a pas besoin d'ordonner la liste 
 * 
 * 
 * 
 */
public interface ISymptomReader {
	/**
	 * Si le fichier est vide , la Liste sera vide
	 * 
	 * @return une liste de sympômes obtenue à partir du fichier source les doublons sont possible
	 * 
	 */
	List<String> GetSymptoms ();
}
