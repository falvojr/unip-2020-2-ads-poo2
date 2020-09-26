package br.unip.ads.pim.controller.interesses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.unip.ads.pim.config.docs.OpenApiConfig;
import br.unip.ads.pim.controller.BaseRestController;
import br.unip.ads.pim.model.interesses.Interesse;
import br.unip.ads.pim.service.InteresseService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = OpenApiConfig.TAG_INTERESSE)
@CrossOrigin
@RestController
public class InteresseRestController extends BaseRestController {

	@Autowired
	private InteresseService camadaNegocio;
	
	@GetMapping("interesses")
	private ResponseEntity<Iterable<Interesse>> buscarTodos() {
		return ResponseEntity.ok(camadaNegocio.buscarTodos());
	}
	
	@GetMapping("interesses/{id}")
	public ResponseEntity<Interesse> buscarUm(@PathVariable Long id) {
		return ResponseEntity.ok(camadaNegocio.buscarUm(id));
	}

	@PostMapping("interesses")
	public ResponseEntity<Void> inserir(@RequestBody Interesse entidade) {
		camadaNegocio.inserir(entidade);
		return ResponseEntity.created(super.criarUri(entidade.getId())).build();
	}

	@PutMapping("interesses/{id}")
	public ResponseEntity<Void> alterar(@PathVariable Long id, @RequestBody Interesse entidade) {
		camadaNegocio.alterar(id, entidade);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("interesses/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		camadaNegocio.excluir(id);
		return ResponseEntity.ok().build();
	}

}