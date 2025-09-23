package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarNinjas(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO ListarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        return missoesService.atualizarMissao(missaoAtualizada, id);
    }

    @DeleteMapping("/deletarID/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

}
