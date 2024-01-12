package Dao;

import DBConnect.DBcontext;
import model.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    Connection conn = null; // kết nối đến mysql
    PreparedStatement ps = null; // ném câu lệnh query sang mysql
    ResultSet rs = null;// trả về kết quả

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM `products`";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT*FROM category";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));

            }

        } catch (Exception e) {

        }
        return list;
    }

    public Product getLast() { // lấy ra sản phẩm mới nhất mà sp new = id lớn nhất ,mà id lớn nhất lại nằm cuối
        String query = "SELECT * FROM `products`\n" +
                "ORDER BY id DESC\n" +
                "LIMIT 1";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));

            }

        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> getProductByCID(String cid) { // về bản chất là kiểu  int nhưng vì kiểu int hay string thì
        // sql vẫn hiểu nên mình dùng kiểu string để tí nữa đỡ ép kiểu
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM `products`\n" +
                "WHERE cateID = ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, cid); // truyền cid vào dấu chấm hỏi
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    public Product getProductByID(String id) { // về bản chất là kiểu  int nhưng vì kiểu int hay string thì
        // sql vẫn hiểu nên mình dùng kiểu string để tí nữa đỡ ép kiểu
        String query = "SELECT * FROM `products`\n" +
                "WHERE id = ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, id); // truyền id vào dấu chấm hỏi thứ nhất
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
            }

        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> SearchByName(String txtSearch) { // về bản chất là kiểu  int nhưng vì kiểu int hay string thì
        // sql vẫn hiểu nên mình dùng kiểu string để tí nữa đỡ ép kiểu
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM  products\n" +
                "WHERE name LIKE ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, "%" + txtSearch + "%"); // truyền cid vào dấu chấm hỏi
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    public Account login(String user, String pass) {
        String query = "SELECT * FROM `account` WHERE `user` = ? AND `pass` = ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, user); // truyền user vào dấu chấm hỏi thứ nhất
            ps.setString(2, pass); // truyền pass vào dấu chấm hỏi thứ hai
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                );


            }

        } catch (Exception e) {

        }
        return null;
    }

    public Account CheckUserExist(String user) {
        String query = "SELECT * FROM `account`\n" +
                "WHERE user = ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, user); // truyền user vào dấu chấm hỏi thứ nhất
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)

                );


            }

        } catch (Exception e) {

        }
        return null;
    }

    public void signUp(String user, String pass) {
        String query = "INSERT INTO account(`user`,pass,isSell,isAdmin)\n" +
                "VALUES(?,?,0,0);";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, user);
            ps.setString(2, pass);
            // truyền user vào dấu chấm hỏi thứ nhất
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

    public int signUp(String user, String pass, String email) {
        String query = "INSERT INTO `account`(`user`, `pass`, `email`, `isSell`, `isAdmin`)" +
                " VALUES (?,?,?,0,0) ";


        int generatedId = -1; // Giá trị mặc định nếu không thể lấy được ID

        try {
            conn = new DBcontext().getConnection(); // Mở kết nối với MySQL
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // Trả về ID được sinh ra

            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1); // Lấy ID của khách hàng vừa được thêm
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
        } finally {
            // Đóng kết nối và tài nguyên
            // ...
        }

        return generatedId; // Trả về ID của khách hàng vừa được thêm
    }

    public int insertOder(int id_customer, int total_amount, int total_product_quantity, String payment_method, String address, String order_code, String fullname) {
        String query = "INSERT INTO `order`(`customer_id`, `total_amount`, `total_product_quantity`, `payment_method`, `order_code`, `fullname`, `shipping _address`) " +
                "VALUES (?,?,?,?,?,?,?)";

        int generatedId = -1; // Giá trị mặc định nếu không thể lấy được ID

        try {
            conn = new DBcontext().getConnection(); // Mở kết nối với MySQL
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // Trả về ID được sinh ra

            ps.setInt(1, id_customer);
            ps.setInt(2, total_amount);
            ps.setInt(3, total_product_quantity);
            ps.setString(4, payment_method);
            ps.setString(5, order_code);
            ps.setString(6, fullname);
            ps.setString(7, address);


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1); // Lấy ID của khách hàng vừa được thêm
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
        } finally {
            // Đóng kết nối và tài nguyên
            // ...
        }

        return generatedId; // Trả về ID của khách hàng vừa được thêm
    }

    public int insert_customer(String fullname, String email, String address, String num_phone, String note) {
        String query = "INSERT INTO `customer`(`fullname`, `email`, `address`, `num_phone`, `note`) " +
                "VALUES (?,?,?,?,?)";

        int generatedId = -1; // Giá trị mặc định nếu không thể lấy được ID

        try {
            conn = new DBcontext().getConnection(); // Mở kết nối với MySQL
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // Trả về ID được sinh ra

            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, num_phone);
            ps.setString(5, note);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1); // Lấy ID của khách hàng vừa được thêm
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
        } finally {
            // Đóng kết nối và tài nguyên
            // ...
        }

        return generatedId; // Trả về ID của khách hàng vừa được thêm
    }


    public void insert_order_item(int order_id, int product_id, int quantity, int total_price) {
        String query = "INSERT INTO `order_item`( `order_id`, `product_id`, `quantity`, `price`) " +
                "VALUES (?,?,?,?)";

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setInt(1, order_id);
            ps.setInt(2, product_id);
            ps.setInt(3, quantity);
            ps.setInt(4, total_price);
            // truyền user vào dấu chấm hỏi thứ nhất
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

    public List<Product> getProductBySellID(int id) { // về bản chất là kiểu  int nhưng vì kiểu int hay string thì
        // sql vẫn hiểu nên mình dùng kiểu string để tí nữa đỡ ép kiểu
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM `products`\n" +
                "WHERE sell_ID = ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setInt(1, id); // truyền id vào dấu chấm hỏi
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)));
            }

        } catch (Exception e) {

        }
        return list;
    }

    public void delete(String id) {
        String query = "DELETE  FROM `products`\n" +
                "WHERE id = ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, id); // truyền id vào dấu chấm hỏi
            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        } catch (Exception e) {

        }

    }

    public void insertProduct(String name, String image, int price, String title, String description,
                              int category, int sellid) {
        String query = "INSERT INTO products\n" +
                "(name,image,price,title,description,cateID,sell_ID)\n" +
                "VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, category);
            ps.setInt(7, sellid);
            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        } catch (Exception e) {

        }

    }


    public List<Order> getListOrder(){
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM `order`;";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)
                ));
            }

        }catch (Exception e){

        }
        return list;
    }

    public List<Customer> getListCustomer(){
        List<Customer> list = new ArrayList<>();
        String query = "SELECT * FROM `customer`" ;
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)

                ));
            }

        }catch (Exception e){

        }
        return list;
    }

    public void editProduct(String name, String image, int price , String title, String description,
                              int category, int pid){
        String query = "UPDATE  products\n" +
                "SET name =?,\n" +
                "image = ?,\n" +
                "price = ?,\n" +
                "title = ?,\n" +
                "description = ?,\n" +
                "cateID = ?\n" +
                "WHERE id = ?";
        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, category);
            ps.setInt(7, pid);
            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }

    }
    public  Order getOrderById(String id){ // về bản chất là kiểu  int nhưng vì kiểu int hay string thì
        // sql vẫn hiểu nên mình dùng kiểu string để tí nữa đỡ ép kiểu
        String query = "SELECT * FROM `order` WHERE `order_id` = ?";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1,id); // truyền id vào dấu chấm hỏi thứ nhất
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                return new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)
                );
            }

        }catch (Exception e){

        }
        return null;
    }
    public List<Order_item> getListProductByOrderId(String cid) {
        List<Order_item> list = new ArrayList<>();
        String query = "SELECT * FROM `order_item` WHERE `order_id` = ?;" ;
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1,cid);
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Order_item(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }

        }catch (Exception e){

        }
        return list;
    }

    public void signedInvoice(String signedInvoice,String cid) {
        String query = "UPDATE `order` SET  `signature` = ? WHERE `order_id` = ?" ;

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, signedInvoice);
            ps.setString(2, cid);

            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }
    }
    public Customer getCustomerByOrderId(int customer_id) {
        String query = "SELECT * FROM `customer` WHERE `customer_id` = ? ";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setInt(1,customer_id); // truyền id vào dấu chấm hỏi thứ nhất
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }

        }catch (Exception e){

        }
        return null;
    }
    public  Order getOrderByID(int id){ // về bản chất là kiểu  int nhưng vì kiểu int hay string thì
        // sql vẫn hiểu nên mình dùng kiểu string để tí nữa đỡ ép kiểu
        String query = "SELECT * FROM `order` WHERE `order_id` = ?";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setInt(1,id); // truyền id vào dấu chấm hỏi thứ nhất
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                return new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)
                ) ;
            }

        }catch (Exception e){

        }
        return null;
    }
    public void public_key(String publickey, int order_id) {
        String query = "UPDATE `order` SET  `public_key` = ? WHERE `order_id` = ?" ;

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, publickey);
            ps.setInt(2, order_id);

            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }
    }
    public void updateAuthenticated(String active,String cid) {
        String query = "UPDATE `order` SET`authenticated`=? WHERE `order_id` = ?" ;

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, active);
            ps.setString(2, cid);


            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }
    }

    public List<Order> getListOrderAuthenticated(){
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM `order` WHERE `authenticated` = \"1\";";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)
                ));
            }

        }catch (Exception e){

        }
        return list;
    }
    public List<Order> getListOrderNotYetAuthenticated(){
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM `order` WHERE `authenticated` = \"0\";";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)));
            }

        }catch (Exception e){

        }
        return list;
    }
    public void  hashedValueOld(String hashedValueOld, int order_id){
        String query = "UPDATE `order` SET  `hashedValueOld` = ? WHERE `order_id` = ?" ;

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, hashedValueOld);
            ps.setInt(2, order_id);

            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }
    }
    public void insertPublickey(String publicKeyBase64, String cid) {
        String query = "UPDATE `account` SET  `public_key` = ? WHERE `id` = ?" ;

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, publicKeyBase64);
            ps.setString(2, cid);

            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }
    }
    public void update_data(String data, String cid) {
        String query = "UPDATE `account` SET  `data` = ? WHERE `id` = ?" ;

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, data);
            ps.setString(2, cid);

            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }
    }
    public boolean insertSignatureAccount(String signedInvoice, String cid) {
        String query = "UPDATE `account` SET  `signature` = ? WHERE `id` = ?";
        boolean isSuccess = false;

        try {
            conn = new DBcontext().getConnection(); // Mở kết nối với MySQL
            ps = conn.prepareStatement(query);

            ps.setString(1, signedInvoice);
            ps.setString(2, cid);

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                isSuccess = true; // Nếu có ít nhất một dòng được cập nhật, coi như thành công
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
        } finally {
            // Đóng kết nối và tài nguyên
            // ...
        }

        return isSuccess;
    }

    public void update_account_authenticated(String account_authenticated, String cid) {
        String query = "UPDATE `account` SET  `account_authenticated` = ? WHERE `id` = ?" ;

        try {
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setString(1, account_authenticated);
            ps.setString(2, cid);

            ps.executeUpdate(); // như vậy nó sẽ chạy câu lệnh query này
        }catch (Exception e){

        }
    }

    public List<Account> getListAccount() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM `account`";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                ));
            }

        }catch (Exception e){

        }
        return list;
    }
    public List<Account> getListAccountTheOwner() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM `account` WHERE `account_authenticated` = \"1\"; ";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                ));
            }

        }catch (Exception e){

        }
        return list;
    }
    public List<Account> getListAccountNotTheOwner() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM `account` WHERE `account_authenticated` = \"0\"; ";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ thực thi  câu lệnh query này và sẽ trả về kết quả đó la rs
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                list.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                ));
            }

        }catch (Exception e){

        }
        return list;
    }
    public Account getSignatureOld(int id) {
        String query = "SELECT * FROM `account` WHERE `id` = ?";
        try{
            conn = new DBcontext().getConnection();// mở kết nối với mysql
            ps = conn.prepareStatement(query); // ném câu lệnh query sang mysq
            // cuối cùng mình sẽ chạy câu lệnh query này và sẽ trả về kết quả đó la rs
            ps.setInt(1,id); // truyền user vào dấu chấm hỏi thứ nhất// truyền pass vào dấu chấm hỏi thứ hai
            rs = ps.executeQuery(); // như vậy nó sẽ chạy câu lệnh query này
            while (rs.next()){
                return  new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                );


            }

        }catch (Exception e){

        }
        return null;
    }
    public static void main(String[] args) {
        Dao dao = new Dao();
//        List<Product> list = dao.getAllProduct();
//        for (Product o:list){
//            System.out.println(o);
//        }
//        List<Category> listC = dao.getAllCategory();
//        for (Category o:listC){
//            System.out.println(o);
//        }
//        Product p = dao.getLast();
//        System.out.println(p);


//        List<Product> list = dao.getProductByCID("1");
//        for (Product o:list){
//            System.out.println(o);
//        }
//        Product pro = dao.getProductByID("1");
//        System.out.println(pro);
//        List<Product> list = dao.SearchByName("adidas");
//        for (Product o:list){
//            System.out.println(o);
//        }
//        Account account = dao.login("dinhnhan","654321");
//        System.out.println(account);
                List<Product> list = dao.getProductBySellID(1);
//        for (Product o:list){
//            System.out.println(o);
//        }
       dao.delete("19");
    }



}
