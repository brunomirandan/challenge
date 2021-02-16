package br.com.bruno.challenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bruno.challenge.api.entities.Salesman;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {

	@Transactional(readOnly = true)
	Salesman findByName(String name);

}