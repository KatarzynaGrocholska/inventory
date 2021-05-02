package pl.project.inventory.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wines")
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int amount;

    private Date date_last_delivery;

    private double inventory_turnover;

    @ManyToOne
    private Producer producer;

    public Wine (){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate_last_delivery() {
        return date_last_delivery;
    }

    public void setDate_last_delivery(Date date_last_delivery) {
        this.date_last_delivery = date_last_delivery;
    }

    public double getInventory_turnover() {
        return inventory_turnover;
    }

    public void setInventory_turnover(double inventory_turnover) {
        this.inventory_turnover = inventory_turnover;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
