package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.wedding.Address;
import edu.javacourse.studentorder.domain.wedding.Adult;
import edu.javacourse.studentorder.domain.wedding.Child;
import edu.javacourse.studentorder.domain.wedding.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder
{
    public static void main(String[] args) {
//        buildStudentOrder(10);
//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 100;
        System.out.println("StudentOrder is running ...");
        return answer;
    }

    static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7,4));
        so.setMarriageOffice("Отдел ЗАГС");

        Address address = new Address("195000", "Заневский пр.", "12", "", "142");

        //Муж
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Отдел милиции №" + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        //Жена
        Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Отдел милиции №" + id);
        wife.setStudentId("" + (200000 + id));
        //Ребенок
        Child child = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child.setCertificateNumber("" + (300000 + id));
        child.setIssueDate(LocalDate.of(2018,7,19));
        child.setIssueDepartment("Отдел ЗАГС №" + id);
        child.setAddress(address);
        //Ребенок
        Child child1 = new Child("Петрова", "Арина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (400000 + id));
        child1.setIssueDate(LocalDate.of(2018,7,19));
        child1.setIssueDepartment("Отдел ЗАГС №" + id);
        child1.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child);
        so.addChild(child1);

        return so;
    }
}