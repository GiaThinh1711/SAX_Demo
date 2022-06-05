package sax_demo;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class SAXParserDemo {
    public static void main(String[] args){
        try{
            File inputFile = new File("input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            StudentHandle studentHandle = new StudentHandle();
            saxParser.parse(inputFile, studentHandle);
            List<Student> students = studentHandle.getStudents();
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}