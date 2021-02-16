package br.com.bruno.challenge.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bruno.challenge.api.entities.Salesman;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SalesmanRepositoryTest {

	@Autowired
	private SalesmanRepository salesmanRepository;

	private static final String NAME = "Comprador 1";

	@Before
	public void setUp() throws Exception {
		Salesman salesman = new Salesman();
		salesman.setName(NAME);
		this.salesmanRepository.save(salesman);
	}

	@After
	public final void tearDown() {
		this.salesmanRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		Salesman salesman = this.salesmanRepository.findByName(NAME);

		assertEquals(NAME, salesman.getName());
	}
	
}
