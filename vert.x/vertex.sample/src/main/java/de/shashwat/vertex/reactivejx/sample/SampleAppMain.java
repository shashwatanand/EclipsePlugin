package de.shashwat.vertex.reactivejx.sample;

import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;

public class SampleAppMain {
	public static void main(String[] args) {
		Vertx vertx = Vertx.factory.vertx();
		
		// creating server using vertx
		HttpServer server = vertx.createHttpServer();
		
		// creating router
		Router router = Router.router(vertx);
		
		/*router.route().handler(rContext -> {
			HttpServerResponse response = rContext.response();
			response.setChunked(true).write("Hello from Sample App").end();
		});*/
		/*router.route("/index").handler(rContext -> {
			HttpServerResponse response = rContext.response();
			response.setChunked(true).write("Hello from Sample App -> Index URL").end();
		});*/
		/*router.get("/getStartPage").handler(rContext -> {
			HttpServerResponse response = rContext.response();
			response.setChunked(true).write("Hello from Sample App -> Start Page").end();
		});*/
		/*router.get("/getStartPage").handler(rContext -> {
			HttpServerResponse response = rContext.response();
			response.setChunked(true).write("Hello from Sample App -> Start Page").end();
		});*/
		router.get("/getStudent").produces("*/json").handler(rContext -> {
			HttpServerResponse response = rContext.response();
			response.setChunked(true).end(Json.encodePrettily(new Student("22", "Shashwat")));
		});
		server.requestHandler(router::accept).listen(8081);
	}
}
