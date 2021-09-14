package hp.care.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import hp.care.app.entity.Specialization;
import hp.care.app.repo.SpecializationRepository;

@DataJpaTest(showSql=true)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class SpecializationRepositoryTest {

	private SpecializationRepository repo;
	
	//1. Test save operation
	@Test
	@Order(1)
	public void testSpecCreate() {
		Specialization spec=new Specialization(null, "CRDLS", "Cardiologists", "They’re experts on the heart and blood vessels.");
		
		spec=repo.save(spec);
		assertNotNull(spec.getId(),"spec is not created !");
	}
	
	
	
	
	//2. test display all operation
}
