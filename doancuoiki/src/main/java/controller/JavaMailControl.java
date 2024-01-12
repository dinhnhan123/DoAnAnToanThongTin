//package controller;
//
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Properties;
//
//@WebServlet(name = "mail", value = "/mail")
//public class JavaMailControl extends HttpServlet {
//    String name , email, subject,msg;
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        name = request.getParameter("name");
//        email = request.getParameter("email");
//        subject = request.getParameter("subject");
//        msg = request.getParameter("message");
//
//        final String username = "20130344@st.hcmuaf.edu.vn";//your email id
//        final String password = "midshxoozgpbogwe";// your password
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", true);
//        props.put("mail.smtp.starttls.enable", true);
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        Session session = Session.getInstance(props,
//                new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(email));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
//            MimeBodyPart textPart = new MimeBodyPart();
//            Multipart multipart = new MimeMultipart();
//            String final_Text = "Name: " + name + "    " + "Email: " + email + "    " + "Subject: " + subject + "    " + "Mesaage: " + msg;
//            textPart.setText(final_Text);
//            message.setSubject(subject);
//            multipart.addBodyPart(textPart);
//            message.setContent(multipart);
//            message.setSubject("Contact Details");
//            //out.println("Sending");
//            Transport.send(message);
//            response.sendRedirect("SendEmail.jsp");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//}

