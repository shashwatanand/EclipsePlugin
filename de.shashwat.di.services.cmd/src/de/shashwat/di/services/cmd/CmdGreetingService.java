package de.shashwat.di.services.cmd;

import de.shashwat.di.services.IGreetingService;

/**
 * The Class CmdGreetingService.
 */
public class CmdGreetingService implements IGreetingService {

	/* (non-Javadoc)
	 * @see de.shashwat.di.services.GreetingService#greet(java.lang.String)
	 */
	@Override
	public void greet(final String text) {
		System.out.println(text);
	}

}
