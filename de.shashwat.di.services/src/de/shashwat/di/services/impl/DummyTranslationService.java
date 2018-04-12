package de.shashwat.di.services.impl;

import de.shashwat.di.services.ITranslationService;

/**
 * The Class DummyTranslationService.
 */
public class DummyTranslationService implements ITranslationService {

	/**
	 * Translate.
	 *
	 * @param language the language
	 * @param term the term
	 * @return the string[]
	 */
	@Override
	public String[] translate(String language, String... term) {
		if ("en".equals(language)) {
			return term;
		}
		if ("Hello".equals(term[0])) {
			if ("de".equals(language)) {
				return new String[] {"Hallo"};
			} else if ("fr".equals(language)) {
				return new String[] {"Bonjour"};
			}
		}
		
		return new String[] {term[0] + "(lang = " + language + ")"};
	}

	/**
	 * Gets the locales.
	 *
	 * @return the locales
	 */
	@Override
	public String[] getLocales() {
		return new String[] { "en","de","fr" };
	}


}
