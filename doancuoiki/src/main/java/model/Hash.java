package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    // Hàm để tạo mã băm SHA-256 cho thông tin đơn hàng
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
        // Giả sử thông tin đơn hàng là một chuỗi
        String orderInfo = "Mã đơn hàng: 12345, Tổng giá trị: 1000, Ngày đặt hàng: 2022-01-15";
        try {
            // Tính toán mã băm cho thông tin đơn hàng
            String hashedValue = calculateHash(orderInfo);
            // In ra giá trị mã băm
            System.out.println("Giá trị mã băm SHA-256 cho thông tin đơn hàng: " + hashedValue);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
