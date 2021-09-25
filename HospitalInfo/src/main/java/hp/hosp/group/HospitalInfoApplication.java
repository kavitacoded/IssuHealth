package hp.hosp.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalInfoApplication.class, args);
		System.out.println("Hospital Info!!");
	}

}
