package loom.structured_concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import jdk.incubator.concurrent.*;

public class StructuredConcurrency {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
			Future<String> firstTask = scope.fork(() -> {
				Thread.sleep(1000);
				System.out.println("first task finished");
				return "first";

			});
			Future<String> secondTask = scope.fork(() -> {
				Thread.sleep(500);
				System.out.println("second task finished");
				return "second";
			});
			scope.join();
			System.out.println(scope.result());
		}
		System.out.println("---");
		try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
			Future<String> firstTask = scope.fork(() -> {
				Thread.sleep(1000);
				System.out.println("first task finished");
				return "first";

			});
			Future<String> secondTask = scope.fork(() -> {
				Thread.sleep(500);
				System.out.println("second task finished");
				return "second";
			});
			scope.join();
			scope.throwIfFailed();
		}
	}
}
