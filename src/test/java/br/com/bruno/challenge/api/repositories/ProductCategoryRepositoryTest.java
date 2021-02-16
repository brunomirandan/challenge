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

import br.com.bruno.challenge.api.entities.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	private static final String NAME = "Categoria 1";

	@Before
	public void setUp() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName(NAME);
		this.productCategoryRepository.save(productCategory);
	}

	@After
	public final void tearDown() {
		this.productCategoryRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		ProductCategory productCategory = this.productCategoryRepository.findByName(NAME);

		assertEquals(NAME, productCategory.getName());
	}
	
}
