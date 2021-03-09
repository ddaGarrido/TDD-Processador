package models;

import enums.FaturaStatus;

import java.util.Date;

public class Fatura {
    private FaturaStatus status;
    private Date date;
    private double value;
    private String cliente;

    public Fatura(Date date, double value, String cliente) {
        this.date = date;
        this.value = value;
        this.cliente = cliente;
    }

    public void makePayment(Pagamento pagamento) {
        this.status = FaturaStatus.PAGO;
    }

    public FaturaStatus getStatus() {
        return status;
    }

    public void setStatus(FaturaStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
