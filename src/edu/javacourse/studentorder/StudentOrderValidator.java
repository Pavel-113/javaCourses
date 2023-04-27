package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.validator.*;
import edu.javacourse.studentorder.domain.wedding.StudentOrder;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private StudentValidator studentVal;
    private ChildrenValidator childrenVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        studentVal = new StudentValidator();
        childrenVal = new ChildrenValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {
        List<StudentOrder> soList = readStudentOrders();
//        for(int i = 0; i < soList.size(); i++) {
//            System.out.println();
//            checkOneOrder(soList.get(i));
//        }
        for(StudentOrder so : soList) {
            System.out.println();
            checkOneOrder(so);
        }

    }

    public void checkOneOrder(StudentOrder studentOrder) {
        AnswerCityRegister cityAnswer = checkCityRegister(studentOrder);
//        AnswerWedding wedAnswer = checkWedding(studentOrder);
//        AnswerChildren childAnswer = checkChildren(studentOrder);
//        AnswerStudent studentAnswer = checkStudent(studentOrder);
//        sendMail(studentOrder);
    }

    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            soList.add(SaveStudentOrder.buildStudentOrder(i));
        }
        return soList;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        return cityRegisterVal.checkCityRegister(studentOrder);
    }

    public AnswerWedding checkWedding(StudentOrder studentOrder) {
        return weddingVal.checkWedding(studentOrder);
    }

    public AnswerChildren checkChildren(StudentOrder studentOrder) {
        return childrenVal.checkChildren(studentOrder);
    }

    public AnswerStudent checkStudent(StudentOrder studentOrder) {
        return studentVal.checkStudent(studentOrder);
    }

    public void sendMail(StudentOrder studentOrder) {
        mailSender.sendMail(studentOrder);
    }
}
