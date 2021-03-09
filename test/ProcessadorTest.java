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
        Boleto boletoA = new Boleto(new Date(), 9999);
        Boleto boletoB = new Boleto(new Date(), 1);

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
        Fatura fatura = new Fatura(new Date(), 3000, "Eduardo Lara");
        Boleto boletoA = new Boleto(new Date(), 500);
        Boleto boletoB = new Boleto(new Date(), 500);

        Fatura f = new Fatura(new Date(), 10000, "f2");
        Boleto boletoA = new Boleto(new Date(), 555);
        Boleto boletoB = new Boleto(new Date(), 111);

        List<Boleto> listBoleto = new ArrayList<Boleto>();

        listBoleto.add(bA);
        listBoleto.add(bB);

        Pagamento payment = processador.processPayment(listBoleto);
        f.makePayment(payment);
        Assertions.assertEquals(f.status, FaturaStatus.NAO_PAGO);
    }
}