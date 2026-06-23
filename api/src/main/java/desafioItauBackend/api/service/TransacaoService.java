package desafioItauBackend.api.service;

import desafioItauBackend.api.dto.TransacaoRequest;
import desafioItauBackend.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    public void validarTransacao(TransacaoRequest transacaoRequest){

        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("Valor Da Transação incorreto");
        }
        if(transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Data Da transação Incorreta");
        }

    }



}
