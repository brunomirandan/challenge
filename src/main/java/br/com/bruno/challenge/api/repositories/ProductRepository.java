package br.com.bruno.challenge.api.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.bruno.challenge.api.entities.Product;
import br.com.bruno.challenge.api.entities.ProductCategory;

@NamedQueries({
		@NamedQuery(name = "ProductRepository.findByProductCategory", query = "SELECT p FROM Product p WHERE p.productCategory = :productCategory") })
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);

	List<Product> findByProductCategory(@Param("productCategory") ProductCategory productCategory);

}