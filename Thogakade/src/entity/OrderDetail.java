package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class OrderDetail {
    @Id
    private String id;
    @ManyToOne
    private Orders Order;
    @ManyToOne
    private Item item;
    private int qty;
    private double unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(String id, Orders order, Item item, int qty, double unitPrice) {
        this.id = id;
        Order = order;
        this.item = item;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                ", Order=" + Order +
                ", item=" + item +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Orders getOrder() {
        return Order;
    }

    public void setOrder(Orders order) {
        Order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


}
