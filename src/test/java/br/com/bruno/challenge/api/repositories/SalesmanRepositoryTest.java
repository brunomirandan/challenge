package br.com.bruno.challenge.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.bruno.challenge.api.entities.Salesman;

@SpringBootTest
@ActiveProfiles("test")
public class SalesmanRepositoryTest {

	@Autowired
	private SalesmanRepository salesmanRepository;

	private static final String NAME = "Comprador 1";

	@BeforeEach
	public void setUp() throws Exception {
		Salesman salesman = new Salesman();
		salesman.setName(NAME);
		this.salesmanRepository.save(salesman);
	}

	@AfterEach
	public final void tearDown() {
		this.salesmanRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		Salesman salesman = this.salesmanRepository.findByName(NAME);

		assertEquals(NAME, salesman.getName());
	}

}
