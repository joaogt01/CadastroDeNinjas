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
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarNinjas(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel ListarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.atualizarMissao(missaoAtualizada, id);
    }

    @DeleteMapping("/deletarID/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

}
