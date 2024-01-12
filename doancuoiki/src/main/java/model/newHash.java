package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class newHash {

        // Hàm để tính toán mã băm SHA-256 cho thông tin đơn hàng
        public static String calculateHash(String orderInfo) throws NoSuchAlgorithmException {
            try {
                // Tạo một đối tượng băm SHA-256
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                // Chuyển thông tin đơn hàng thành dạng byte trước khi băm
                byte[] encodedhash = digest.digest(orderInfo.getBytes());
                // Chuyển byte array thành dạng hex
                StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
                for (byte b : encodedhash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                throw e;
            }
        }

        public static void main(String[] args) {
            // Giả sử thông tin đơn hàng được cập nhật
            String updatedOrderInfo = "Mã đơn hàng: 12345, Tổng giá trị: 1200, Ngày đặt hàng: 2022-01-15";
            try {
                // Tính toán lại mã băm cho thông tin đơn hàng
                String updatedHashedValue = calculateHash(updatedOrderInfo);
                // In ra giá trị mã băm sau khi cập nhật
                System.out.println("Giá trị mã băm SHA-256 cho thông tin đơn hàng sau khi cập nhật: " + updatedHashedValue);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }


