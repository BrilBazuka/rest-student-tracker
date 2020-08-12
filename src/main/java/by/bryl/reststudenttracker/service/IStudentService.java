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
    Student getStudentById(int id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudentById(int id);
    boolean isExistById(int id);
}
