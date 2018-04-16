package de.shashwat.di.app;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import de.shashwat.di.services.IGreetingService;
import de.shashwat.di.services.ITranslationService;

// TODO: Auto-generated Javadoc
/**
 * The Class GreetingActor.
 */
public class GreetingActor {
	
	/** The person name. */
	private final String personName;
	
	/** The greeting service. */
	private IGreetingService greetingService;
	
	/** The language. */
	private String language;
	
	/**
	 * Instantiates a new greeting actor.
	 *
	 * @param personName the person name
	 */
	@Inject
	public GreetingActor(@Named("Name") final String personName) {
		this.personName = personName;
	}
	
	/**
	 * Inits the.
	 *
	 * @param greetingService the greeting service
	 */
	@PostConstruct
	private void init(final IGreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	@Inject
	public void setLanguage(@Named("Language") final String language) {
		this.language = language;
	}
	
	/**
	 * Greet.
	 *
	 * @param translationService the translation service
	 */
	public void greet(ITranslationService translationService) {
		this.greetingService.greet(translationService.translate(this.language, 
				"Hello")[0] + " ' " + this.personName + " '!");
	}
}
