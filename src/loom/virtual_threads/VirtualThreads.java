package loom.virtual_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {
	public static void main(String[] args) throws InterruptedException {
		Thread virtualThread = Thread
				.ofVirtual()
				.name("virtual thread")
				.start(() -> System.out.println(Thread.currentThread().getName()));
		try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
			executorService.submit(() -> System.out.println("Running from an ExecutorService"));
		}
	}
}
