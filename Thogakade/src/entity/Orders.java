package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    private String id;
    private LocalDate date;
    @ManyToOne
    private Customer CustomerID;

    public Orders(String id, LocalDate date, Customer customerID) {
        this.id = id;
        this.date = date;
        CustomerID = customerID;
    }

    @OneToMany(mappedBy = "Order")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    public Orders() {
    }

    public Orders(String id, LocalDate date, Customer customerID, List<OrderDetail> orderDetailList) {
        this.id = id;
        this.date = date;
        CustomerID = customerID;
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", CustomerID=" + CustomerID +
                ", orderDetailList=" + orderDetailList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Customer customerID) {
        CustomerID = customerID;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }


}
