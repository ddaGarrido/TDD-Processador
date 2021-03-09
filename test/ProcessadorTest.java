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

        listBoleto.add(bA);
        listBoleto.add(bB);

        Pagamento payment = processador.processPayment(listBoleto);
        f.makePayment(payment);
        Assertions.assertEquals(f.status, FaturaStatus.PAGO);
    }

    @Test
    @DisplayName("Validate if fatura get payed correctly when boletos values are more then fatura")
    void TestaFaturaPagaMaiorBoletos() {
        Fatura f = new Fatura(new Date(), 1, "f2");
        Boleto bA = new Boleto(new Date(), 9999);
        Boleto bB = new Boleto(new Date(), 1);

        List<Boleto> listBoleto = new ArrayList<Boleto>();

        listBoleto.add(bA);
        listBoleto.add(bB);

        Pagamento payment = processador.processPayment(listBoleto);
        f.makePayment(payment);
        Assertions.assertEquals(f.status, FaturaStatus.PAGO);
    }

    @Test
    @DisplayName("Validate if fatura gets not payed if boletos value are lower then fatura")
    void TestaFaturaPagaParaValoresMenores() {
        Fatura f = new Fatura(new Date(), 10000, "f3");
        Boleto bA = new Boleto(new Date(), 555);
        Boleto bB = new Boleto(new Date(), 111);

        List<Boleto> listBoleto = new ArrayList<Boleto>();

        listBoleto.add(bA);
        listBoleto.add(bB);

        Pagamento payment = processador.processPayment(listBoleto);
        f.makePayment(payment);
        Assertions.assertEquals(f.status, FaturaStatus.NAO_PAGO);
    }

    @Test
    @DisplayName("Validate if payment get corret MP")
    void TestaTipoDePagamento() {
        Fatura f = new Fatura(new Date(), 10000, "f4");
        Boleto bA = new Boleto(new Date(), 555);

        List<Boleto> listBoleto = new ArrayList<Boleto>();

        listBoleto.add(bA);

        Pagamento payment = processador.processPayment(listBoleto);

        Assertions.assertEquals(payment.getMP(), MeioPagamento.BOLETO);
        Assertions.assertNotEquals(payment.getMP(), MeioPagamento.CARTAO);
    }
}