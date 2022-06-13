package io.github.joaopugliesi.projetomv.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.joaopugliesi.projetomv.dto.ContaPfDto;
import io.github.joaopugliesi.projetomv.models.entity.ContaPf;
import io.github.joaopugliesi.projetomv.services.ContaPfService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/conta-pf")
public class ContaPfController {

	final ContaPfService contaPfService;

	public ContaPfController(ContaPfService contaPfService) {
		this.contaPfService = contaPfService;
	}

	@PostMapping
	public ResponseEntity<Object> saveContaPf(@RequestBody @Valid ContaPfDto contaPfDto) {
		ContaPf contaPf = new ContaPf();
		BeanUtils.copyProperties(contaPfDto, contaPf);
		contaPf.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(contaPfService.save(contaPf));

	}

	@GetMapping
	public ResponseEntity<List<ContaPf>> getAllClientePf() {
		return ResponseEntity.status(HttpStatus.OK).body(contaPfService.findAll());
	}

	@GetMapping("{id_conta}")
	public ResponseEntity<Object> getOneClientePf(@PathVariable(value = "id_conta") Integer id_conta) {
		Optional<ContaPf> contaPfOptional = contaPfService.findById(id_conta);
		if (!contaPfOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta Pessoa Física não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(contaPfOptional.get());
	}

	@DeleteMapping("{id_conta}")
	public ResponseEntity<Object> deleteContaPf(@PathVariable(value = "id_conta") Integer id_conta) {
		Optional<ContaPf> contaPfOptional = contaPfService.findById(id_conta);
		if (!contaPfOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta Pessoa Física não encontrada.");
		}
		contaPfService.delete(contaPfOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Conta Pessoa Física deletada.");
	}

	@PutMapping("{id_conta}")
	public ResponseEntity<Object> updateContaPf(@PathVariable(value = "id_conta") Integer id_conta,
			@RequestBody @Valid ContaPfDto contaPfDto) {
		Optional<ContaPf> contaPfOptional = contaPfService.findById(id_conta);
		if (!contaPfOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta Pessoa Física não encontrada.");
		}
		ContaPf contaPf = new ContaPf();
		BeanUtils.copyProperties(contaPfDto, contaPf);
		contaPf.setId_conta(contaPfOptional.get().getId_conta());
		contaPf.setDataRegistro(contaPfOptional.get().getDataRegistro());
		return ResponseEntity.status(HttpStatus.OK).body(contaPfService.save(contaPf));

	}
}
