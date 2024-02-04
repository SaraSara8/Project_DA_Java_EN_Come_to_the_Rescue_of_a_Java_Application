package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	/**
	 * 
	 *  @param filepath               est le chemin complet et partieil vers le fichier resultat 
	 *                 sur lequle on ecrit ligne par ligne
	 */
	
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// TODO Auto-generated method stub
		
		if (filepath != null) {
			
			try {
				BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
				String line;
				
				for (Map.Entry mapentry : symptoms.entrySet()) {
					
					line =mapentry.getKey() + ":" + mapentry.getValue();
					writer.write(line);
					
				}
				
				writer.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}

