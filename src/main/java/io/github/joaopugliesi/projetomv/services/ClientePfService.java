package io.github.joaopugliesi.projetomv.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.joaopugliesi.projetomv.models.entity.ClientePf;
import io.github.joaopugliesi.projetomv.repositories.ClientePfRepository;

@Service
public class ClientePfService {

	final ClientePfRepository clientePfRepository;

	public ClientePfService(ClientePfRepository clientePfRepository) {
		this.clientePfRepository = clientePfRepository;
	}

	@Transactional
	public ClientePf save(ClientePf clientePf) {
		return clientePfRepository.save(clientePf);
	}

	public List<ClientePf> findAll() {
		return clientePfRepository.findAll();
	}

	public Optional<ClientePf> findById(Integer id) {
		return clientePfRepository.findById(id);
	}

	@Transactional
	public void delete(ClientePf clientePf) {
		clientePfRepository.delete(clientePf);
	}

}
