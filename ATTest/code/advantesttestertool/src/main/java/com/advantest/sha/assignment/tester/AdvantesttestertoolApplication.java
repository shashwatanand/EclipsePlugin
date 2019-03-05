package com.advantest.sha.assignment.tester;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;


@SpringBootApplication
public class AdvantesttestertoolApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(AdvantesttestertoolApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication app = new SpringApplication(AdvantesttestertoolApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}

}
