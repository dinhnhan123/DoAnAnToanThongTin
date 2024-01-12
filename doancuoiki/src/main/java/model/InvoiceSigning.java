package model;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

public class InvoiceSigning {
    // Tạo cặp khóa
    public static KeyPair generateKeyPair() {
        try {
            // Tạo cặp khóa
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024); // Độ dài khóa
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String signData(PrivateKey privateKey, String data) {
        try {
            // Ký hóa dữ liệu bằng private key
            Signature privateSignature = Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(privateKey);
            privateSignature.update(data.getBytes());
            byte[] signature = privateSignature.sign();
            return bytesToHex(signature); // Chuyển byte array sang dạng hex string
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean verifySignature(PublicKey publicKey, String data, String signature) {
        try {
            // Chuyển đổi chữ ký từ dạng hex string sang byte array
            byte[] signatureBytes = hexToBytes(signature);

            // Giải mã chữ ký bằng public key
            Signature publicSignature = Signature.getInstance("SHA256withRSA");
            publicSignature.initVerify(publicKey);
            publicSignature.update(data.getBytes());
            return publicSignature.verify(signatureBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    public static byte[] hexToBytes(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
    public static String privateKeyToBase64(PrivateKey privateKey) {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public static String publicKeyToBase64(PublicKey publicKey) {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public static PrivateKey privateKeyFromBase64(String privateKeyBase64) {
        try {
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            return keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PublicKey publicKeyFromBase64(String publicKeyBase64) {
        try {
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            return keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        // Generate key pair
        String data = "160278processingpayment-home04f3c20cf0Đinh Thành Nhân";
        KeyPair keyPair = InvoiceSigning.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        String privateKeyBase64 = InvoiceSigning.privateKeyToBase64(privateKey);
        String publicKeyBase64 = InvoiceSigning.publicKeyToBase64(publicKey);
        PrivateKey restoredPrivateKey = InvoiceSigning.privateKeyFromBase64(privateKeyBase64);
        PublicKey restoredPublicKey = InvoiceSigning.publicKeyFromBase64(publicKeyBase64);
        String signedInvoice = InvoiceSigning.signData(restoredPrivateKey, data);
        // Sample data to sign

        System.out.println("Data signed with signature: " + signedInvoice);

        // Verify the signature
        boolean isSignatureValid = InvoiceSigning.verifySignature(restoredPublicKey, data, signedInvoice);
        if (isSignatureValid) {
            System.out.println("Signature is valid.");
        } else {
            System.out.println("Signature is invalid.");
        }

    }
    }






