package pl.project.inventory.entity;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String country_name;

    @NotNull
    private String currency;

    @NotNull
    private int days_delivery;

    public Country(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDays_delivery() {
        return days_delivery;
    }

    public void setDays_delivery(int days_delivery) {
        this.days_delivery = days_delivery;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country_name='" + country_name + '\'' +
                ", currency='" + currency + '\'' +
                ", days_delivery=" + days_delivery +
                '}';
    }
}
