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
    public String criarMissao(){
        return "Missao Criada";
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarNinjas(){
        return MissoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel ListarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesId(id);
    }

    @PutMapping("/alterarID")
    public String alterarMissoesPorId(){
        return "Alterar Missoes Por Id";
    }

    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId(){
        return "Deletar Missao Por Id";
    }

}
