package br.com.bruno.challenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bruno.challenge.api.entities.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

	@Transactional(readOnly = true)
	ProductCategory findByName(String name);

}