package desafioItauBackend.api.controller;

import desafioItauBackend.api.dto.TransacaoRequest;
import desafioItauBackend.api.repository.TransacaoRepository;
import desafioItauBackend.api.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {


    private TransacaoRepository transacaoRepository;
    private TransacaoService transacaoService;

    public TransacaoController(TransacaoRepository transacaoRepository,
                               TransacaoService transacaoService) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> novaTrasacao(@Valid @RequestBody TransacaoRequest transacaoRequest){

        try {
        transacaoService.validarTransacao(transacaoRequest);
        transacaoRepository.add(transacaoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (IllegalArgumentException IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping
    public ResponseEntity<Void> limpar(){
        transacaoRepository.limpar();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
