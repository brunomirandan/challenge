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

import br.com.bruno.challenge.api.entities.Buyer;
import br.com.bruno.challenge.api.entities.Product;
import br.com.bruno.challenge.api.entities.ProductCategory;
import br.com.bruno.challenge.api.entities.Sale;
import br.com.bruno.challenge.api.entities.Salesman;

@SpringBootTest
@ActiveProfiles("test")
public class SaleRepositoryTest {

	@Autowired
	private SalesmanRepository salesmanRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SaleRepository saleRepository;

	private static final String SALESMANNAME = "Vendedor A";
	private static final String BUYERNAME = "Comprador A";
	private static final String CATEGORYNAME = "Categoria A";
	private static final String PRODUCTNAME = "Produto A";
	private static final String DESCRIPTIONPRODUCT = "Descrição A";

	@BeforeEach
	public void setUp() throws Exception {
		Salesman salesman = this.salesmanRepository.save(getSalesmanData());

		Buyer buyer = this.buyerRepository.save(getBuyerData());

		ProductCategory productCategory = this.productCategoryRepository.save(getProductCategoryData());
		Product product = this.productRepository.save(getProductData(productCategory));

		Sale sale = new Sale();
		sale.setSalesman(salesman);
		sale.setBuyer(buyer);
		sale.setProduct(product);

		this.saleRepository.save(sale);
	}

	@AfterEach
	public final void tearDown() {
		this.saleRepository.deleteAll();
		this.salesmanRepository.deleteAll();
		this.buyerRepository.deleteAll();
		this.productRepository.deleteAll();
	}

	@Test
	public void testFindBySalesman() {
		Salesman salesman = this.salesmanRepository.findByName(SALESMANNAME);

		List<Sale> sales = this.saleRepository.findBySalesman(salesman);
		for (Sale s : sales) {
			assertEquals(SALESMANNAME, s.getSalesman().getName());
		}
	}

	@Test
	public void testFindByBuyer() {
		Buyer buyer = this.buyerRepository.findByName(BUYERNAME);

		List<Sale> sales = this.saleRepository.findByBuyer(buyer);
		for (Sale s : sales) {
			assertEquals(BUYERNAME, s.getBuyer().getName());
		}
	}

	@Test
	public void testFindByProduct() {
		Product product = this.productRepository.findByName(PRODUCTNAME);

		List<Sale> sales = this.saleRepository.findByProduct(product);
		for (Sale s : sales) {
			assertEquals(PRODUCTNAME, s.getProduct().getName());
		}
	}

	private Salesman getSalesmanData() {
		Salesman salesman = new Salesman();
		salesman.setName(SALESMANNAME);
		return salesman;
	}

	private Buyer getBuyerData() {
		Buyer buyer = new Buyer();
		buyer.setName(BUYERNAME);
		return buyer;
	}

	private ProductCategory getProductCategoryData() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName(CATEGORYNAME);
		return productCategory;
	}

	private Product getProductData(ProductCategory productCategory) {
		Product product = new Product();
		product.setName(PRODUCTNAME);
		product.setDescription(DESCRIPTIONPRODUCT);
		product.setCreationDate(new Date(System.currentTimeMillis()));
		product.setProductCategory(productCategory);
		return product;
	}

}
