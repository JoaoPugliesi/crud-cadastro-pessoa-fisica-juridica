package io.github.joaopugliesi.projetomv.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.joaopugliesi.projetomv.models.entity.ContaPf;
import io.github.joaopugliesi.projetomv.repositories.ContaPfRepository;

@Service
public class ContaPfService {

	final ContaPfRepository contaPfRepository;

	public ContaPfService(ContaPfRepository contaPfRepository) {
		this.contaPfRepository = contaPfRepository;
	}

	@Transactional
	public ContaPf save(ContaPf contaPf) {
		return contaPfRepository.save(contaPf);
	}

	public List<ContaPf> findAll() {
		return contaPfRepository.findAll();
	}

	public Optional<ContaPf> findById(Integer id_conta) {
		return contaPfRepository.findById(id_conta);
	}

	@Transactional
	public void delete(ContaPf contaPf) {
		contaPfRepository.delete(contaPf);
	}
}
