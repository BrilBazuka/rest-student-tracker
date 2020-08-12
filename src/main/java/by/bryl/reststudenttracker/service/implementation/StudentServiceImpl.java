package by.bryl.reststudenttracker.service.implementation;

import by.bryl.reststudenttracker.exception.ServiceException;
import by.bryl.reststudenttracker.model.Student;
import by.bryl.reststudenttracker.repository.IStudentRepository;
import by.bryl.reststudenttracker.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link IStudentService} interface.
 *
 * @author Andrew Bryl
 */

@Service
public class StudentServiceImpl implements IStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private IStudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public List<Student> getStudents() {
        LOGGER.info("Getting all students");
        List<Student> students = studentRepository.findAll();
        LOGGER.info("Students found: " + students.size());
        return students;
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        LOGGER.info("Trying to get student with id: " + id);
        if (id < 1) throw new ServiceException("Can't get student. No student with id: " + id);
        Optional<Student> tempStudent = studentRepository.findById(id);
        if (tempStudent.isEmpty()) {
            throw new ServiceException("Can't get student. No student with id: " + id);
        }
        Student foundStudent = tempStudent.get();
        LOGGER.info("Student found: " + foundStudent);
        return foundStudent;
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        LOGGER.info("Trying to add student: " + student);
        student.setId(0);
        Student addedStudent = studentRepository.save(student);
        LOGGER.info("Student has been successfully added: " + addedStudent);
        return addedStudent;
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        LOGGER.info("Trying to update student: " + student);
        int studentId = student.getId();
        if (studentId < 1 || !isExistById(studentId)) throw new ServiceException("Can't update student. No student with id: " + studentId);
        Student updatedStudent = studentRepository.save(student);
        LOGGER.info("Student has been successfully updated: " + updatedStudent);
        return updatedStudent;
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        LOGGER.info("Trying to delete student with id " + id);
        if (id < 1 || !isExistById(id)) throw new ServiceException("Can't delete student. No student with id: " + id);
        studentRepository.deleteById(id);
        LOGGER.info("Student has been successfully deleted: " + id);
    }

    @Override
    @Transactional
    public boolean isExistById(int id) {
        LOGGER.info("Trying to check whether the user exists: " + id);
        boolean isExists = studentRepository.existsById(id);
        LOGGER.info("User with id " + id + " exists: " + isExists);
        return isExists;
    }
}
