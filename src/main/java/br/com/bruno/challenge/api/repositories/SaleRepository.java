package br.com.bruno.challenge.api.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.bruno.challenge.api.entities.Buyer;
import br.com.bruno.challenge.api.entities.Product;
import br.com.bruno.challenge.api.entities.Sale;
import br.com.bruno.challenge.api.entities.Salesman;

@NamedQueries({
		@NamedQuery(name = "SaleRepository.findBySalesman", query = "SELECT s from Sale s WHERE s.salesman = :salesman"),
		@NamedQuery(name = "SaleRepository.findByBuyer", query = "SELECT s from Sale s WHERE s.buyer = :buyer"),
		@NamedQuery(name = "SaleRepository.findByProduct", query = "SELECT s from Sale s WHERE s.product = :product") })
public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Transactional(readOnly = true)
	List<Sale> findBySalesman(@Param("salesmanId") Salesman salesman);

	@Transactional(readOnly = true)
	List<Sale> findByBuyer(@Param("buyerId") Buyer buyer);

	@Transactional(readOnly = true)
	List<Sale> findByProduct(@Param("productId") Product product);

}