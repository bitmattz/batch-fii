package com.bitmattz;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class BatchFiiApplication {

	public static void main(String[] args) {
		System.out.println("\n" +
				" ________  ________  _________  ________  ___  ___                             ________ ___  ___     \n" +
				"|\\   __  \\|\\   __  \\|\\___   ___\\\\   ____\\|\\  \\|\\  \\                           |\\  _____\\\\  \\|\\  \\    \n" +
				"\\ \\  \\|\\ /\\ \\  \\|\\  \\|___ \\  \\_\\ \\  \\___|\\ \\  \\\\\\  \\        ____________      \\ \\  \\__/\\ \\  \\ \\  \\   \n" +
				" \\ \\   __  \\ \\   __  \\   \\ \\  \\ \\ \\  \\    \\ \\   __  \\      |\\____________\\     \\ \\   __\\\\ \\  \\ \\  \\  \n" +
				"  \\ \\  \\|\\  \\ \\  \\ \\  \\   \\ \\  \\ \\ \\  \\____\\ \\  \\ \\  \\     \\|____________|      \\ \\  \\_| \\ \\  \\ \\  \\ \n" +
				"   \\ \\_______\\ \\__\\ \\__\\   \\ \\__\\ \\ \\_______\\ \\__\\ \\__\\                          \\ \\__\\   \\ \\__\\ \\__\\\n" +
				"    \\|_______|\\|__|\\|__|    \\|__|  \\|_______|\\|__|\\|__|                           \\|__|    \\|__|\\|__|\n" +
				"                                                                                                     \n" +
				"                                                                                                     \n" +
				"                                                                                                     \n");
		System.out.println("By bitmattz");
		SpringApplication.run(BatchFiiApplication.class, args);
	}

}
