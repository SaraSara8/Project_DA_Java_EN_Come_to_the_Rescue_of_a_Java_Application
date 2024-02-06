package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	final  String  filepath="./Project02Eclipse/result.out.txt";
	
	/**
	 * 
	 *  @param filepath est le chemin complet et partieil vers le fichier resultat 
	 *                 sur lequle on ecrit ligne par ligne
	 */
	
	public WriteSymptomDataToFile () {
		
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// TODO Auto-generated method stub
		
			
		try {
			BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
			String line;
				
			for (Map.Entry<String, Integer> objEncours : symptoms.entrySet()) {
					
				line =objEncours.getKey() + ":" + objEncours.getValue();
				writer.write(line);
				writer.write("\n");
			}
				
		writer.close();
				
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}

