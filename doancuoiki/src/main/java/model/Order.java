package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order implements Serializable {
    private int order_id;
    private int customer_id;
    private  int total_amount;
    private int total_product_quantity;
    private String order_status;
    private String payment_method;
    private  String order_code;
    private  String fullname;
    private  String shipping_address;
    private String public_key;
    private int authenticated;
    private  String hashedValueOld;
    private List<Item> items;
    private int status;



    public Order(int order_id, int customer_id, int total_amount, int total_product_quantity, String order_status, String payment_method, String order_code, String fullname, String shipping_address, String public_key, int authenticated, String hashedValueOld) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.total_amount = total_amount;
        this.total_product_quantity = total_product_quantity;
        this.order_status = order_status;
        this.payment_method = payment_method;
        this.order_code = order_code;
        this.fullname = fullname;
        this.shipping_address = shipping_address;
        this.public_key = public_key;
        this.authenticated = authenticated;
        this.hashedValueOld = hashedValueOld;

    }



    public String getHashedValueOld() {
        return hashedValueOld;
    }

    public int getAuthenticated() {
        return authenticated;
    }

    public String getPublic_key() {
        return public_key;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public void setTotal_product_quantity(int total_product_quantity) {
        this.total_product_quantity = total_product_quantity;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public int getTotal_product_quantity() {
        return total_product_quantity;
    }

    public String getOrder_status() {
        return order_status;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public String getOrder_code() {
        return order_code;
    }

    public String getFullname() {
        return fullname;
    }

    public Order() {
        this.status = 0;
    }




    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return  order_id + customer_id + total_amount + total_product_quantity +order_status + payment_method + order_code + fullname + shipping_address ;
    }

    public long gettotal() {
        long t = 0;
        for (Item i : items)
            t += i.getQuantity() * i.getProduct().getPrice();
            return t;
        }
    public String numberFormat(int number) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(number).replace(",", ".");
    }
    public String generateOrderCode() {
        // Tạo mã đơn hàng ngẫu nhiên bằng cách sử dụng UUID
        String orderCode = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return orderCode;
    }

    }




