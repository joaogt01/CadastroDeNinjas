package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel ListarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasId(id);
    }

    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja Por Id";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletar Ninja Por Id";
    }
}
