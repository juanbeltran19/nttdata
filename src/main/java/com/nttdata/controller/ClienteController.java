package com.nttdata.controller;

import com.nttdata.modelo.Cliente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@PostMapping("/cliente/buscar")
	@ResponseBody
	public ResponseEntity<Cliente> buscarCliente(@RequestBody Cliente clientes) {
		try {	
			if(clientes.getNumeroDocumento().equals("1")) {
				Cliente cliente = new Cliente();
				cliente.setMensaje("Dato invalido");
				return new ResponseEntity<>(cliente, HttpStatus.BAD_REQUEST);
			}					
			if(clientes.getNumeroDocumento().equals("23445322")
					&&clientes.getTipoDocumento() == 'C'
					||clientes.getTipoDocumento() == 'P') {
				Cliente cliente = new Cliente();
				cliente.setNumeroDocumento("23445322");
				cliente.setTipoDocumento('C');
				cliente.setPrimerNombre("Juan");
				cliente.setSegundoNombre("Pablo");
				cliente.setPrimerApellido("Beltran");
				cliente.setSegundoApellido("Vega");
				cliente.setTelefono("3013807120");
				cliente.setDireccion("Calle 8 # 24-37");
				cliente.setCiudadResidencia("Medellin");				
				return new ResponseEntity<>(cliente, HttpStatus.OK);
			}else {
				Cliente clientem = new Cliente();
				clientem.setMensaje("No existe");
				return new ResponseEntity<>(clientem, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			Cliente cliente = new Cliente();
			cliente.setMensaje("Error");
			return new ResponseEntity<>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
