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

import br.com.bruno.challenge.api.entities.Buyer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BuyerRepositoryTest {

	@Autowired
	private BuyerRepository buyerRepository;

	private static final String NAME = "Comprador 1";

	@Before
	public void setUp() throws Exception {
		Buyer buyer = new Buyer();
		buyer.setName(NAME);
		this.buyerRepository.save(buyer);
	}

	@After
	public final void tearDown() {
		this.buyerRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		Buyer buyer = this.buyerRepository.findByName(NAME);

		assertEquals(NAME, buyer.getName());
	}

}
