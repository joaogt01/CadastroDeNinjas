package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //listar missoes por id
    public MissoesModel listarMissoesId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    //Criar missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Deletar Missao por ID
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
