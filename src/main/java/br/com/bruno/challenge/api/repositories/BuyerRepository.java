package br.com.bruno.challenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bruno.challenge.api.entities.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

	@Transactional(readOnly = true)
	Buyer findByName(String name);

}