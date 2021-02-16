package br.com.bruno.challenge.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.bruno.challenge.api.entities.Product;
import br.com.bruno.challenge.api.entities.ProductCategory;

@SpringBootTest
@ActiveProfiles("test")
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	private static final String NAMECATEGORY = "Categoria A";
	private static final String NAMEPRODUCT = "Produto 1";
	private static final String DESCRIPTION = "Descrição";

	@BeforeEach
	public void setUp() throws Exception {
		ProductCategory productCategory = this.productCategoryRepository.save(getProductCategoryData());

		Product product = getProductData(productCategory);

		this.productRepository.save(product);
	}

	@AfterEach
	public final void tearDown() {
		this.productRepository.deleteAll();
		this.productCategoryRepository.deleteAll();
	}

	@Test
	public void testFindByName() {
		Product product = this.productRepository.findByName(NAMEPRODUCT);

		assertEquals(NAMEPRODUCT, product.getName());
	}

	@Test
	public void testFindByCategory() {
		ProductCategory productCategory = this.productCategoryRepository.findByName(NAMECATEGORY);

		List<Product> products = this.productRepository.findByProductCategory(productCategory);
		for (Product p : products) {
			assertEquals(NAMECATEGORY, p.getProductCategory().getName());
		}
	}

	private ProductCategory getProductCategoryData() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName(NAMECATEGORY);
		return productCategory;
	}

	private Product getProductData(ProductCategory productCategory) {
		Product product = new Product();
		product.setName(NAMEPRODUCT);
		product.setDescription(DESCRIPTION);
		product.setCreationDate(new Date(System.currentTimeMillis()));
		product.setProductCategory(productCategory);
		return product;
	}
}