package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<String> ListarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninjasID = ninjaService.listarNinjasId(id);
        if (ninjasID != null){
            return ResponseEntity.ok("Ninja encontrado: " + ninjasID.getNome());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + id + " não existe nos nossos registros");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        if (ninjaService.listarNinjasId(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("Ninja com ID" + id + " Alterado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjasId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não encontrado");
        }
    }
}
