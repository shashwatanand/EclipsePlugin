package de.shashwat.di.services;

/**
 * The Interface TranslationService.
 */
public interface ITranslationService {
	
	/**
	 * Translate.
	 *
	 * @param language the language
	 * @param term the term
	 * @return the string[]
	 */
	public String[] translate(String language, String... term);
	
	/**
	 * Gets the locales.
	 *
	 * @return the locales
	 */
	public String[] getLocales();
}
