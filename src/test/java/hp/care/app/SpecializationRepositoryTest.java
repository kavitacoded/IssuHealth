package hp.care.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import hp.care.app.entity.Specialization;
import hp.care.app.repo.SpecializationRepository;

@DataJpaTest(showSql=true)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
public class SpecializationRepositoryTest {

	private SpecializationRepository repo;
	
	//1. Test save operation
	@Disabled
	@Test
	@Order(1)
	public void testSpecCreate() {
		Specialization spec=new Specialization(null, "CRDLS", "Cardiologists", "They’re experts on the heart and blood vessels.");
		
		spec=repo.save(spec);
		assertNotNull(spec.getId(),"spec is not created !");
	}
	
	
	//2. test display all operation
	@Test
	
	@Order(2)
	public void testSpeccFetchAll() {
		List<Specialization>list=repo.findAll();
		assertNotNull(list);
		assertThat(list.size()<=0);
		fail("no data exist in database");
	}
}
