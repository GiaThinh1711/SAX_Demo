package sax_demo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadHandle {
    public static void main(String[] args) throws IOException{
        String fileName = "spring-boot-starter-web-2.7.0.jar";
        String fileLink = "https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-starter-web/2.7.0/spring-boot-starter-web-2.7.0.jar";
        downloadFile(fileName,fileLink);
    }
    public static void downloadFile(String fileName, String fileLink){
        try{
            Connection.Response response = Jsoup.connect(fileLink).ignoreContentType(true).execute();
            FileOutputStream out = (new FileOutputStream(fileName));
            out.write(response.bodyAsBytes());
            out.close();
            System.out.printf("Download file %s success",fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
