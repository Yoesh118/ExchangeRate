package com.example.exchangeratecalculator.rate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="rat", catalog = "rate")
@XmlRootElement
public class Rate {
    private Long id;
    private String base_currency_code;
    private  String pair_currency_code;
    private String qoute;
    private Double unit_base_price;
    private Double zwlInterbank;


    public Rate() {
    }

    public Rate(Long id, String base_currency_code, String pair_currency_code, String qoute, Double unit_base_price, Double zwlInterbank) {
        this.id = id;
        this.base_currency_code = base_currency_code;
        this.pair_currency_code = pair_currency_code;
        this.qoute = qoute;
        this.unit_base_price = unit_base_price;
        this.zwlInterbank = zwlInterbank;
    }

    public Rate(String base_currency_code, String pair_currency_code, String qoute, Double unit_base_price, Double zwlInterbank) {
        this.base_currency_code = base_currency_code;
        this.pair_currency_code = pair_currency_code;
        this.qoute = qoute;
        this.unit_base_price = unit_base_price;
        this.zwlInterbank = zwlInterbank;
    }

    @Id
    @SequenceGenerator(
            name = "rate_sequence",
            sequenceName = "rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rate_sequence"
    )

    public String getBase_currency_code() {
        return base_currency_code;
    }

    public void setBase_currency_code(String base_currency_code) {
        this.base_currency_code = base_currency_code;
    }

    public String getPair_currency_code() {
        return pair_currency_code;
    }

    public void setPair_currency_code(String pair_currency_code) {
        this.pair_currency_code = pair_currency_code;
    }

    public String getQoute() {
        return qoute;
    }

    public void setQoute(String qoute) {
        this.qoute = qoute;
    }

    public Double getUnit_base_price() {
        return unit_base_price;
    }

    public void setUnit_base_price(Double unit_base_price) {
        this.unit_base_price = unit_base_price;
    }

    public Double getZwlInterbank() {
        return zwlInterbank;
    }

    public void setZwlInterbank(Double zwlInterbank) {
        this.zwlInterbank = zwlInterbank;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "base_currency_code='" + base_currency_code + '\'' +
                ", pair_currency_code='" + pair_currency_code + '\'' +
                ", qoute='" + qoute + '\'' +
                ", unit_base_price=" + unit_base_price +
                ", zwlInterbank=" + zwlInterbank +
                '}';
    }
}

