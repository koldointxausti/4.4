package com.zubiri.school;

public class Administrative extends Worker {
	
	private String[] languages = new String[5];
	
	private int numberOfLanguages = 0;
	
	private String administrativeID = "";
	
	public String[] getLanguages() {
		
		return languages;
		
	}
	
	public void setLanguages(String[] languages) {
		
		this.languages = languages;
		
	}
	
	public int getNumberOfLanguages() {
		
		return numberOfLanguages;
	}
	

	
	
 
}
