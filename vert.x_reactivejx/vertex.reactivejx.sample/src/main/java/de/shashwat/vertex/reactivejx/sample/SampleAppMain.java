package de.shashwat.vertex.reactivejx.sample;

import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class SampleAppMain {
	public static void main(String[] args) {
		Vertx vertx = Vertx.factory.vertx();
		
		// creating server using vertx
		HttpServer server = vertx.createHttpServer();
		
		// creating router
		Router router = Router.router(vertx);
		
		router.route().handler(rContext -> {
			HttpServerResponse response = rContext.response();
			response.setChunked(true).write("Hello from Sample App").end();
		});
		server.requestHandler(router::accept).listen(8081);
	}
}
