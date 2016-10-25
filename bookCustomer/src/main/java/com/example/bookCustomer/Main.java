package com.example.bookCustomer;
//package com.app.cust;
//
////package com.app.springboot;
//import com.app.cust.rest.Customer;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.boot.SpringApplication;
////import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////
////@Configuration
////@EnableAutoConfiguration
////@RestController
////public class Main {
////
////  @Value("${config.name}")
////  String name = "World";
////
////  @RequestMapping("/")
////  public String home() {
////    return "Hello " + name;
////  }
////
////  public static void main(String[] args) {
////    SpringApplication.run(Application.class, args);
////  }
////
////}
//public class Main {
//
//    Map<Long, Customer> map = new HashMap<>();
//
//    public static void main(String args[]) {
//
//        Main m = new Main();
//        m.save();
//        System.out.println(m.getList());
//        m.remove(1L);
//        System.out.println(m.getList());
//
//    }
//
//    private List<Customer> getList() {
//
//        Collection<Customer> values = map.values();
//        List<Customer> uniCastMessageList = new ArrayList<>(values);
//        return uniCastMessageList;
//    }
//
//    private void save() {
//        Customer c = new Customer(1, "a", "m");
//        Customer c1 = new Customer(2, "b", "n");
//        map.put(c.getId(), c);
//        map.put(c1.getId(), c1);
//        
//    }
//
//    private void remove(Long id) {
//        System.out.println("uniCastMessageList.SIZE:" + map.size());
//        map.remove(id);
//        System.out.println("uniCastMessageList.SIZE1:" + map.size());
//    }
//}
