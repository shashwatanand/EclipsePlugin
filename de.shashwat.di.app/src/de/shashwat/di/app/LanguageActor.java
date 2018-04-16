package de.shashwat.di.app;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;

import de.shashwat.di.services.ILanguageProviderService;

// TODO: Auto-generated Javadoc
/**
 * The Class LanguageActor.
 */
public class LanguageActor {
	
	/** The language service. */
	private final ILanguageProviderService languageService;
	
	/**
	 * Instantiates a new language actor.
	 *
	 * @param languageService the language service
	 */
	@Inject
	public LanguageActor(final ILanguageProviderService languageService) {
		this.languageService = languageService;
	}
	
	/**
	 * Gets the request language.
	 *
	 * @return the request language
	 */
	@Execute
	public String getRequestLanguage() {
		return this.languageService.getLanguage();
	}

}
