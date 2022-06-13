package io.github.joaopugliesi.projetomv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.joaopugliesi.projetomv.models.entity.ClientePf;

@Repository
public interface ClientePfRepository extends JpaRepository<ClientePf, Integer> {

}
