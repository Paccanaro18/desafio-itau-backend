package desafioItauBackend.api.service;

import desafioItauBackend.api.dto.TransacaoRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoServiceTest {

        private TransacaoService transacaoService = new TransacaoService();

        @Test
        void deve_rejeitar_valor_negativo() {
            TransacaoRequest request = new TransacaoRequest();
            request.setValor(BigDecimal.valueOf(-1));
            request.setDataHora(OffsetDateTime.now().minusSeconds(10));

            assertThrows(IllegalArgumentException.class, () -> {
                transacaoService.validarTransacao(request);
            });
        }

        @Test
        void deve_rejeitar_data_futura() {
            TransacaoRequest request = new TransacaoRequest();
            request.setValor(BigDecimal.valueOf(100));
            request.setDataHora(OffsetDateTime.now().plusHours(1));

            assertThrows(IllegalArgumentException.class, () -> {
                transacaoService.validarTransacao(request);
            });
        }

        @Test
        void deve_aceitar_transacao_valida() {
            TransacaoRequest request = new TransacaoRequest();
            request.setValor(BigDecimal.valueOf(100));
            request.setDataHora(OffsetDateTime.now().minusSeconds(10));

            assertDoesNotThrow(() -> {
                transacaoService.validarTransacao(request);
            });
        }
    }

