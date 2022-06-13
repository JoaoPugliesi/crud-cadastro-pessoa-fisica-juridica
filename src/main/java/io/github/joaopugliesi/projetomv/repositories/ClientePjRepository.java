package io.github.joaopugliesi.projetomv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.joaopugliesi.projetomv.models.entity.ClientePj;

@Repository
public interface ClientePjRepository extends JpaRepository<ClientePj, Integer> {

}
