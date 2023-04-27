package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.wedding.Child;
import edu.javacourse.studentorder.domain.wedding.Person;
import edu.javacourse.studentorder.domain.wedding.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {

    public static final String IN_CODE = "NO_GRN";
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(studentOrder.getHusband()));
        ans.addItem(checkPerson(studentOrder.getWife()));
        for (Child child : studentOrder.getChildren()) {
            ans.addItem(checkPerson(child));
        }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;

        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            if (tmp != null) {
            status = tmp.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
            }
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }  catch (Exception ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }
        AnswerCityRegisterItem and =
                new AnswerCityRegisterItem(status, person, error);
        return and;
    }
}



//        } catch (Exception ex) {
////        } catch (CityRegisterException | TransportException ex) {
//            ex.printStackTrace(System.out);
//            status = AnswerCityRegisterItem.CityStatus.ERROR;
//            if (ex instanceof TransportException) {
//                CityRegisterException e = (CityRegisterException) ex;
//                error = new AnswerCityRegisterItem.CityError(e.getCode(), ex.getMessage());
//            }
//            if (ex instanceof TransportException) {
//                CityRegisterException e = (CityRegisterException) ex;
//                error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
//            }