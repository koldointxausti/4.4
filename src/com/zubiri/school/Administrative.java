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

	public String getAdministrativeID() {

		return administrativeID;

	}

	public void setAdministrativeID(String administrativeID) {

		this.administrativeID = administrativeID;
	}

	public boolean repeatedLanguage(String language) {
		if(numberOfLanguages>0) {
			for (int i = 0; i < languages.length; i++)
				if (languages[i].equals(language)) {
					return false;
				}
		}
		
		return true;
	}

	public void addLanguages(String language) {
			languages[numberOfLanguages] = language;
			numberOfLanguages++;
	}

	public void removeLanguage(int index) {

		languages[index] = "";
	}

	public int findLanguage(String language) {

		for (int i = 0; i < languages.length; i++) {

			if (languages[i].matches(language))

				return i;
		}

		return -1;

	}
}
