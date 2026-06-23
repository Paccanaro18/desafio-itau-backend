package desafioItauBackend.api.repository;

import desafioItauBackend.api.dto.TransacaoRequest;
import desafioItauBackend.api.dto.EstatisticaRequest;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

@Repository
public class TransacaoRepository {


    private final List<TransacaoRequest> transacoes = new ArrayList<>();


    public void add(TransacaoRequest transacaoRequest) {
        transacoes.add(transacaoRequest);
    }

    public void limpar(){
        transacoes.clear();
    }


    public EstatisticaRequest buscarEstatistica(OffsetDateTime dataInicial){
        if(transacoes.isEmpty()){
            return new EstatisticaRequest();
        } else {
            final BigDecimal[] valoresFiltrados = transacoes.stream()
                    .filter(t -> t.getDataHora().isAfter(dataInicial) || t.getDataHora().equals(dataInicial))
                    .map(t -> t.getValor()).toArray(BigDecimal[]::new);
            DoubleStream doubleStream = Arrays.stream(valoresFiltrados).mapToDouble(BigDecimal::doubleValue);
            return new EstatisticaRequest(doubleStream.summaryStatistics());
        }
    }

}
