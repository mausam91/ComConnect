/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.persistence;

import com.mausamcon.comconnect.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@Service
public class DbSeeder implements CommandLineRunner {
    private OrdersRepository ordersRepository;

    private UsersRepository usersRepository;
    private SuperStoreRepository superStoreRepository;
    private ProductsRepository productsRepository;
    private MongoTemplate mongoTemplate;

    public DbSeeder(OrdersRepository ordersRepository, MongoTemplate mongoTemplate, UsersRepository usersRepository, SuperStoreRepository superStoreRepository, ProductsRepository productsRepository) {
        this.ordersRepository = ordersRepository;
        this.mongoTemplate = mongoTemplate;
        this.usersRepository = usersRepository;
        this.superStoreRepository = superStoreRepository;
        this.productsRepository = productsRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        this.ordersRepository.deleteAll();
        this.usersRepository.deleteAll();
        this.superStoreRepository.deleteAll();
        this.productsRepository.deleteAll();
        this.mongoTemplate.dropCollection(PaymentOptions.class);


        /*
        Payment Options
         */

        PaymentOptions creditCardPayment = new PaymentOptions(PaymentType.CreditCard, 0);
        PaymentOptions payPalPayment = new PaymentOptions(PaymentType.PayPal, 1);
        PaymentOptions cashPayment = new PaymentOptions(PaymentType.Cash, 10);
        this.mongoTemplate.insert(creditCardPayment);
        this.mongoTemplate.insert(payPalPayment);
        this.mongoTemplate.insert(cashPayment);


        Products p1 = new Products("1", "colgate", "Beauty", 15, 3);
        Products p2 = new Products("2", "Milk", "Beverage", 15, 5.68);
        Products p3 = new Products("3", "Bread", "Beverage", 15, 1.68);
        Products p4 = new Products("4", "Wafers", "Snacks", 15, 4.56);
        Products p5 = new Products("5", "Egg", "Beverage", 15, 6);
        Products p6 = new Products("6", "Salt", "Salt", 15, 3);
        Products p7 = new Products("7", "Sugar", "Sugar", 15, 7);
        Products p8 = new Products("8", "Coffee", "Coffee", 15, 10.7);
        Products p9 = new Products("9", "Tea", "Tea", 15, 13.3);
        Products p10 = new Products("10", "Popcorn", "snacks", 15, 12);
        Products p11 = new Products("11", "Soup", "Beauty", 15, 1.90);
        Products p12 = new Products("12", "Detergent", "Cloth Cleaners", 15, 9.76);
        Products p13 = new Products("13", "Tooth Brush", "Beauty", 15, 2);
        Products p14 = new Products("14", "Tomato", "Vegetables", 15, 3.4);
        Products p15 = new Products("15", "Chili", "vegetables", 15, 5.4);
        this.mongoTemplate.insert(p1);
        this.mongoTemplate.insert(p2);
        this.mongoTemplate.insert(p3);
        this.mongoTemplate.insert(p4);
        this.mongoTemplate.insert(p5);
        this.mongoTemplate.insert(p6);
        this.mongoTemplate.insert(p7);
        this.mongoTemplate.insert(p8);
        this.mongoTemplate.insert(p9);
        this.mongoTemplate.insert(p10);
        this.mongoTemplate.insert(p11);
        this.mongoTemplate.insert(p12);
        this.mongoTemplate.insert(p13);
        this.mongoTemplate.insert(p14);
        this.mongoTemplate.insert(p15);


        Address AddressSuperStore1 = new Address("123", "saskatoon", "Sk", "xyz");
        Address AddressWallmart = new Address("456", "Regina", "Sk", "abc");
        Address AddressCoup = new Address("789", "Montreal", "Quebec", "qwe");
        Address AddressSobeys = new Address("101", "Toronto", "Quebec", "asd");


        SuperStore walmart = new SuperStore("Walmart", AddressWallmart, Arrays.asList(p1, p2, p3, p4, p5, p6));
        SuperStore realCanadian = new SuperStore("Real Canadian Super Store", AddressSuperStore1, Arrays.asList(p1, p2, p3, p4, p5, p6));
        SuperStore coup = new SuperStore("Coup", AddressCoup, Arrays.asList(p1, p2, p3, p4, p5, p6));
        SuperStore sobeys = new SuperStore("Sobeys", AddressSobeys, Arrays.asList(p1, p2, p3, p4, p5, p6));

        this.mongoTemplate.insert(walmart);
        this.mongoTemplate.insert(realCanadian);
        this.mongoTemplate.insert(coup);
        this.mongoTemplate.insert(sobeys);

        DeliveryInfo dOrder1 = new DeliveryInfo(LocalDate.now().plusDays(10), 0.0);
        DeliveryInfo dOrder2 = new DeliveryInfo(LocalDate.now().plusDays(18), 0.0);
        DeliveryInfo dOrder3 = new DeliveryInfo(LocalDate.now().plusDays(5), 0.0);
        DeliveryInfo dOrder4 = new DeliveryInfo(LocalDate.now().plusDays(2), 0.0);
        DeliveryInfo dOrder5 = new DeliveryInfo(LocalDate.now().minusDays(10), 0.0);
        DeliveryInfo dOrder6 = new DeliveryInfo(LocalDate.now().minusDays(15), 0.0);

        Address addUser1 = new Address("123", "saskatoon", "SK", "xyz");
        Address addUser2 = new Address("456", "Regina", "SK", "abc");
        Address addUser3 = new Address("789", "Montreal", "Quebec", "qwe");
        Address addUser4 = new Address("101", "Toronto", "Ontario", "asd");
        Address addUser5 = new Address("102", "saskatoon", "SK", "qwe");
        Address addUser6 = new Address("103", "Toronto", "Ontario", "asd");

        Users user1 = new Users("Mausam", "Patel", addUser1, UserType.SEEKER,
                "mausampatel.91@gmail.com");
        Users user2 = new Users("Pinakin", "Patel", addUser2, UserType.VOLENTEER, "pinakin.page@gmail.com");
        Users user3 = new Users("Tom", "Cruise", addUser3, UserType.VOLENTEER, "12tom.cruise@gmail.com");
        Users user4 = new Users("Robert", "Downey", addUser4, UserType.SEEKER, "123robert.downey.gmail.com");
        Users user5 = new Users("Scarlett", "Johansson", addUser5, UserType.SEEKER, "1234scarlett.johansson@gmail.com");
        Users user6 = new Users("Chris", "Evans", addUser6, UserType.SEEKER, "12312chris.evans@hotmail.com");
        this.mongoTemplate.insert(user1);
        this.mongoTemplate.insert(user2);
        this.mongoTemplate.insert(user3);
        this.mongoTemplate.insert(user4);
        this.mongoTemplate.insert(user5);
        this.mongoTemplate.insert(user6);


        Orders or1 = new Orders(LocalDate.now(), Arrays.asList(p3, p6), cashPayment, walmart, OrderStatus.PENDING, dOrder1, user1, user2);
        Orders or2 = new Orders(LocalDate.now(), Arrays.asList(p1, p10, p7), creditCardPayment, realCanadian, OrderStatus.PENDING, dOrder2, user1, user3);
        Orders or3 = new Orders(LocalDate.now(), Arrays.asList(p3, p5, p13, p15, p1), payPalPayment, sobeys, OrderStatus.INPROCESS, dOrder3, user4, user2);
        Orders or4 = new Orders(LocalDate.now(), Arrays.asList(p9, p4, p5, p6), creditCardPayment, coup, OrderStatus.INPROCESS, dOrder4, user5, user3);
        Orders or5 = new Orders(LocalDate.now().minusMonths(1), Arrays.asList(p1, p9, p4, p2, p10, p11, p13), payPalPayment, sobeys, OrderStatus.DELIVERED, dOrder5, user6, user3);
        // Orders or6=new Orders();
//        Orders or7=new Orders();
//        Orders or8=new Orders();
//        Orders or9=new Orders();
//        Orders or10=new Orders();
//        Orders or11=new Orders();


        Collection<Orders> initialOrderrs = Arrays.asList(or1, or2, or3, or4, or5);
        this.ordersRepository.insert(initialOrderrs);
    }

}
