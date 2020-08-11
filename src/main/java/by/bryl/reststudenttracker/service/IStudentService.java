package by.bryl.reststudenttracker.service;

import by.bryl.reststudenttracker.exception.ServiceException;
import by.bryl.reststudenttracker.model.Student;

import java.util.List;

/**
 * Service interface for {@link Student}
 *
 * @author Andrew Bryl
 */

public interface IStudentService {
    List<Student> getStudents();
    Student getStudentById(int id) throws ServiceException;
    Student addStudent(Student student);
    Student updateStudent(Student student) throws ServiceException;
    void deleteStudentById(int id) throws ServiceException;
    boolean isExistById(int id);
}
