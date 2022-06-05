package sax_demo;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentHandle extends DefaultHandler {
    private List<Student> students = new ArrayList<>();
    private Student currentStudent;
    private boolean isFirstName = false;
    private boolean isLastName = false;
    private boolean isNickName = false;
    private boolean isMark = false;

    public List<Student> getStudents(){
        return students;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(qName.equals("student")){
            currentStudent = new Student();
        }else if(qName.equals("firstname")){
            isFirstName = true;
        }else if(qName.equals("lastname")) {
            isLastName = true;
        }else if(qName.equals("nickname")) {
            isNickName = true;
        }else if(qName.equals("mark")) {
            isMark = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("students")){
            students.add(currentStudent);
        }else if(qName.equals("firstname")){
            isFirstName = false;
        }else if(qName.equals("lastname")) {
            isLastName = false;
        }else if(qName.equals("nickname")) {
            isNickName = false;
        }else if(qName.equals("mark")) {
            isMark = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        if(isFirstName){
            currentStudent.setFirstName(content);
        }else if(isLastName){
            currentStudent.setLastName(content);
        }else if(isNickName){
            currentStudent.setNickName(content);
        }else if(isMark){
            currentStudent.setMarks(Integer.parseInt(content));
        }
        System.out.println("Day la noi dung trong the" + new String(ch, start, length));
    }
}
