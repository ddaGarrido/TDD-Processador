package models;

import java.util.Date;

public class Boleto {
    private Date data;
    private long value;

    public Boleto(Date data, long value) {
        this.data = data;
        this.value = value;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
