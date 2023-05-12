package lk.blacky.ihungrypos.db;

import lk.blacky.ihungrypos.model.Customer;
import lk.blacky.ihungrypos.model.Order;

public class DataBase {
    public static Customer[] customerArray = new Customer[0];
    public static Order[] orderArray = new Order[0];
    public static Customer[] customerIncrement( Customer customer) {
        try {
            Customer[] temp = new Customer[customerArray.length + 1];
            for (int i = 0; i < customerArray.length; i++) {
                temp[i] = customerArray[i];
            }

            customerArray = temp;
            customerArray[customerArray.length - 1] = customer;
            return customerArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Order[] orderIncrement(Order order) {
        try{
            Order[] temp = new Order[orderArray.length + 1];
            for (int i = 0; i < orderArray.length; i++) {
                temp[i] = orderArray[i];
            }
            orderArray = temp;
            orderArray[orderArray.length - 1] = order;
            return orderArray;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;


    }

}
