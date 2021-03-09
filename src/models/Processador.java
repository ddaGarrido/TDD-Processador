package models;

import enums.MeioPagamento;

import java.util.Date;
import java.util.List;

public class Processador {
    public Pagamento processPayment(List<Boleto> boletos) {
        long total = boletos
                .stream()
                .mapToLong(boleto -> boleto.getValue())
                .reduce(0, (_total, value) -> _total + value);
        return new Pagamento(total, new Date(), MeioPagamento.BOLETO);
    }
}
