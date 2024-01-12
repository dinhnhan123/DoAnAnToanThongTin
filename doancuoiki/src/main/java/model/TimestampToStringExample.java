package model;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TimestampToStringExample {

    public static void main(String[] args) {
        String updatedAtStr = "2022-01-25 15:30:00"; // Giả sử đây là giá trị của trường updated_at
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Timestamp updatedAt = new Timestamp(dateFormat.parse(updatedAtStr).getTime());
            System.out.println("Updated_at as Timestamp: " + updatedAt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    }


