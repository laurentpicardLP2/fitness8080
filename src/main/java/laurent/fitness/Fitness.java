/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package laurent.fitness;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Fitness implements CommandLineRunner {
    public boolean someLibraryMethod() {
        return true;
    }
    

	public static void main(String[] args) throws Exception, MalformedURLException, IOException, ClassNotFoundException, SQLException {
		SpringApplication.run(Fitness.class, args);
	}

	@Override
	public void run(String... args)
			throws Exception,  MalformedURLException, IOException, ClassNotFoundException, SQLException {
	}
    
}
