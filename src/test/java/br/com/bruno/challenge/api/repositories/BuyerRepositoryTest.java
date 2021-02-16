package br.com.bruno.challenge.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.bruno.challenge.api.entities.Buyer;

@SpringBootTest
@ActiveProfiles("test")
public class BuyerRepositoryTest {

	@Autowired
	private BuyerRepository buyerRepository;

	private static final String NAME = "Comprador 1";

	@BeforeEach
	public void setUp() throws Exception {
		Buyer buyer = new Buyer();
		buyer.setName(NAME);
		this.buyerRepository.save(buyer);
	}

	@AfterEach
	public final void tearDown() {
		this.buyerRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		Buyer buyer = this.buyerRepository.findByName(NAME);

		assertEquals(NAME, buyer.getName());
	}

}
