package com.advantest.sha.assignment.tester;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.advantest.sha.assignment.tester.controller.ITesterToolController;
import com.advantest.sha.assignment.tester.controller.impl.TesterToolControllerImpl;

/**
 * The Class AdvantesttestertoolApplication.
 */
@SpringBootApplication
public class AdvantesttestertoolApplication implements CommandLineRunner {
	
	/** The log. */
	private static Logger LOG = LoggerFactory.getLogger(AdvantesttestertoolApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication app = new SpringApplication(AdvantesttestertoolApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
		LOG.info("APPLICATION FINISHED");
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");
		ITesterToolController controller = new TesterToolControllerImpl();
		controller.processArguments(args);
	}
}
