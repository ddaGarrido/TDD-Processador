import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ProcessadorTest {

    private Processador processador;

    @BeforeEach()
    public void init() {
        processador = new Processador();
    }

    @Test
    @DisplayName("Validate if fatura get payed correctly when boletos has same value then fatura")
    void TestaFaturaPagaParaValoresIguais() {
        Fatura f = new Fatura(new Date(), 10000, "f1");
        Boleto bA = new Boleto(new Date(), 9999);
        Boleto bB = new Boleto(new Date(), 1);

        List<Boleto> listBoleto = new ArrayList<Boleto>();

        Pagamento payment = processador.processPayment(listBoleto);
        f.makePayment(payment);
        Assertions.assertEquals(f.status, FaturaStatus.PAGO);
    }
}