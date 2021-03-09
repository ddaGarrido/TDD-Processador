package models;

import enums.MeioPagamento;

import java.util.Date;

public class Pagamento {
    private Date date;
    private double value;
    private MeioPagamento MP;

    public Pagamento(double total, Date date, MeioPagamento MP) {
        this.value = total;
        this.date = date;
        this.MP = MP;
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

    public MeioPagamento getMP() {
        return MP;
    }

    public void setMP(MeioPagamento MP) {
        this.MP = MP;
    }
}
