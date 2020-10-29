package handlers;

import com.typesafe.config.Config;
import play.Environment;
import play.api.OptionalSourceMapper;
import play.api.UsefulException;

import play.api.routing.Router;
import play.http.DefaultHttpErrorHandler;

import play.mvc.Http.RequestHeader;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.Results.*;

@Singleton
public class ErrorHandler extends DefaultHttpErrorHandler {

	@Inject
	private ErrorHandler(Config configuration,
                         Environment environment,
                         OptionalSourceMapper sourceMapper,
                         Provider<Router> routes) {
		super(configuration, environment, sourceMapper, routes);
	}

	@Override
	protected CompletionStage<Result> onDevServerError(RequestHeader request, UsefulException exception) {
		System.out.println("Inside Custom OnDevServerError");
		//TODO: Do something with the error and return something accordingly
		return CompletableFuture.completedFuture(ok(""));
	}

	@Override
	protected CompletionStage<Result> onProdServerError(RequestHeader request, UsefulException exception) {
		System.out.println("Inside Custom OnProdServerError");
		//TODO: Do something with the error and return something accordingly
		return CompletableFuture.completedFuture(ok(""));
	}
}