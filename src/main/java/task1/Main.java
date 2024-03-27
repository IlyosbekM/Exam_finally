package task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream input=new FileInputStream("music.mp3");
        FileOutputStream writer=new FileOutputStream("music.txt");
        writer.write(encoding(input.readAllBytes()));
        writer.flush();

                //DECODE
//        FileInputStream input=new FileInputStream("music.txt");
//        FileOutputStream writer=new FileOutputStream("music.mp3");
//        writer.write(decoding(input.readAllBytes()));
//        writer.flush();



        System.out.println(new String(encoding(input.readAllBytes())));



    }


    private static byte[] encoding(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(bytes);
        return encode;
    }

    private static byte[] decoding(byte[] encodedText) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(encodedText);
        return  decode;
    }


}
