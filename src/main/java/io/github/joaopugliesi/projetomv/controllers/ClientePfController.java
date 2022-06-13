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

import io.github.joaopugliesi.projetomv.dto.ClientePfDto;
import io.github.joaopugliesi.projetomv.models.entity.ClientePf;
import io.github.joaopugliesi.projetomv.services.ClientePfService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente-pf")
public class ClientePfController {

	final ClientePfService clientePfService;

	public ClientePfController(ClientePfService clientePfService) {
		this.clientePfService = clientePfService;
	}

	@PostMapping
	public ResponseEntity<Object> saveClientePf(@RequestBody @Valid ClientePfDto clientePfDto) {
		ClientePf clientePf = new ClientePf();
		BeanUtils.copyProperties(clientePfDto, clientePf);
		clientePf.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(clientePfService.save(clientePf));

	}

	@GetMapping
	public ResponseEntity<List<ClientePf>> getAllClientePf() {
		return ResponseEntity.status(HttpStatus.OK).body(clientePfService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> getOneClientePf(@PathVariable(value = "id") Integer id) {
		Optional<ClientePf> clientePfOptional = clientePfService.findById(id);
		if (!clientePfOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Pessoa Física não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clientePfOptional.get());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteClientePf(@PathVariable(value = "id") Integer id) {
		Optional<ClientePf> clientePfOptional = clientePfService.findById(id);
		if (!clientePfOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Pessoa Física não encontrada.");
		}
		clientePfService.delete(clientePfOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente Pessoa Física deletada.");
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> updateClientePf(@PathVariable(value = "id") Integer id,
			@RequestBody @Valid ClientePfDto clientePfDto) {
		Optional<ClientePf> clientePfOptional = clientePfService.findById(id);
		if (!clientePfOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Pessoa Física não encontrada.");
		}
		ClientePf clientePf = new ClientePf();
		BeanUtils.copyProperties(clientePfDto, clientePf);
		clientePf.setId(clientePfOptional.get().getId());
		clientePf.setDataRegistro(clientePfOptional.get().getDataRegistro());
		clientePf.setCpf(clientePfOptional.get().getCpf());
		return ResponseEntity.status(HttpStatus.OK).body(clientePfService.save(clientePf));

	}

}
