package br.com.bruno.challenge.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.bruno.challenge.api.entities.ProductCategory;

@SpringBootTest
@ActiveProfiles("test")
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	private static final String NAME = "Categoria 1";

	@BeforeEach
	public void setUp() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName(NAME);
		this.productCategoryRepository.save(productCategory);
	}

	@AfterEach
	public final void tearDown() {
		this.productCategoryRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		ProductCategory productCategory = this.productCategoryRepository.findByName(NAME);

		assertEquals(NAME, productCategory.getName());
	}

}
