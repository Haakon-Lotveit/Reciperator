package no.haakon.begynnelse;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {
	
	public static void main(String[] args) {
		String error = "ERROR";
		System.out.println("Loading resources before spring is started:");
		
		System.out.println("Loading SQL files");
		String createRecipeSql = error;
		String createInstructionSql = error;
		String createIngredientSql = error;
		
		try {
		 createRecipeSql = loadFile("sql/create-recipe.sql");
		 System.out.println("[OK] loaded create recipe table script");
		 createInstructionSql = loadFile("sql/create-instruction.sql");
		 System.out.println("[OK] loaded create instruction table script");
		 createIngredientSql = loadFile("sql/create-ingredient.sql");
		 System.out.println("[OK] loaded create ingredient table script");
		} 
		catch(IOException ioe) {
			System.err.println("[FAIL] Couldn't load sql files. Throwing up.");
			throw new RuntimeException(ioe);
		}
		
		System.out.println("[OK] Loaded SQL files, DAO set up.");
		
		System.out.println("[OK] Starting Spring");
		SpringApplication.run(Demo1Application.class, args);
		
	}
	
	private static String loadFile(String fileDescriptor) throws IOException {
		ClassLoader classLoader = Demo1Application.class.getClassLoader();
		
		URL fileUrl = classLoader.getResource(fileDescriptor);
		if(null == fileUrl) {
			throw new IOException(String.format("Could not load file from file descriptor \"%s\", classLoader returned null on getResource. (Check file exists at the path and build)", fileDescriptor));
		}

		String fileName = fileUrl.getFile();
		if(fileName.equals("")) {
			throw new IOException(String.format("Classloader could get the resource from the filedescriptor, but the URL returned could not be turned into a file"));
		}
		
		File file = new File(fileName);
		try(Scanner reader = new Scanner(file)) {
			return reader.useDelimiter("\\Z").next();
		}
		
		
	}
}
