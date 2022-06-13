package io.github.joaopugliesi.projetomv.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.joaopugliesi.projetomv.models.entity.ClientePj;
import io.github.joaopugliesi.projetomv.repositories.ClientePjRepository;

@Service
public class ClientePjService {

	final ClientePjRepository clientePjRepository;

	public ClientePjService(ClientePjRepository clientePjRepository) {
		this.clientePjRepository = clientePjRepository;
	}

	public ClientePj save(ClientePj clientePj) {
		return clientePjRepository.save(clientePj);
	}

	public List<ClientePj> findAll() {
		return clientePjRepository.findAll();
	}

	public Optional<ClientePj> findById(Integer id) {
		return clientePjRepository.findById(id);
	}

	@Transactional
	public void delete(ClientePj clientePj) {
		clientePjRepository.delete(clientePj);
	}

}
