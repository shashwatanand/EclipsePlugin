package de.shashwat.di.services.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import de.shashwat.di.services.ILanguageProviderService;

public class CmdLanguageProviderService implements ILanguageProviderService {

	@Override
	public String getLanguage() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter langauge : ");
			String language = reader.readLine();
			return language;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Locale.getDefault().getLanguage();
	}

}
