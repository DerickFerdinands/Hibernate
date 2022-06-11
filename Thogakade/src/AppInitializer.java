import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfigurations;

import java.time.LocalDate;

public class AppInitializer {
    public static void main(String[] args) {
        Session session = FactoryConfigurations.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Customer("C001", "Derick Andrew Ferdinands", "Colombo ", 100000));
        session.save(new Customer("C002", "Derick Andrew Ferdinands", "Colombo ", 100000));
        session.save(new Customer("C003", "Derick Andrew Ferdinands", "Colombo ", 100000));
        Customer c002 = session.get(Customer.class, "C002");
        c002.setAddress("Colombo 7");
        session.delete(session.get(Customer.class,"C003"));
        session.update(c002);

        session.save(new Item("I001","Coca Cola",200,10));
        session.save(new Item("I002","Coca Cola",200,10));
        session.save(new Item("I003","Coca Cola",200,10));

        Item i002 = session.get(Item.class, "I002");
        i002.setDescription("Sprite");
        session.update(i002);

        session.delete(session.get(Item.class,"I003"));

        session.save(new Orders("O001", LocalDate.now(),session.get(Customer.class,"C001")));
        session.save(new Orders("O002", LocalDate.now(),session.get(Customer.class,"C001")));
        session.save(new Orders("O003", LocalDate.now(),session.get(Customer.class,"C002")));

        Orders o002 = session.get(Orders.class, "O002");
        o002.setCustomerID(session.get(Customer.class,"C002"));
        session.update(o002);

        session.delete(session.get(Orders.class, "O003"));

        Orders o001 = session.get(Orders.class, "O001");
        Item i001 = session.get(Item.class, "I001");
        session.save(new OrderDetail(o001.getId()+" 1",o001,i001,3,i001.getUnitPrice()));
        Item i003 = session.get(Item.class, "I002");
        session.save(new OrderDetail(o001.getId()+" 2",o001,i003,3,i002.getUnitPrice()));
        session.save(new OrderDetail(o001.getId()+" 3",o001,i001,3,i001.getUnitPrice()));

        OrderDetail o003 = session.get(OrderDetail.class, "O001 2");
        o003.setQty(5);
        session.update(o003);

        session.delete(session.get(OrderDetail.class, "O001 3"));

        transaction.commit();
        session.close();
    }
}
