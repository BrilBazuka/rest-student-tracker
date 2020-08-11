package by.bryl.reststudenttracker.service.implementation;

import by.bryl.reststudenttracker.exception.ServiceException;
import by.bryl.reststudenttracker.exception.StudentNotFoundException;
import by.bryl.reststudenttracker.model.Student;
import by.bryl.reststudenttracker.repository.IStudentRepository;
import by.bryl.reststudenttracker.service.IStudentService;
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
public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student getStudentById(int id) throws ServiceException {
        if (id < 1) throw new ServiceException("Can't get student. No student with id: " + id, new StudentNotFoundException("Student not found id: " + id));
        Optional<Student> tempStudent = studentRepository.findById(id);
        if (tempStudent.isEmpty()) {
            throw new ServiceException("Can't get student. No student with id: " + id, new StudentNotFoundException("Student not found id: " + id));
        }
        return tempStudent.get();
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        student.setId(0);
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) throws ServiceException {
        int studentId = student.getId();
        if (studentId < 1 || !isExistById(studentId)) throw new ServiceException("Can't update student. No student with id: " + studentId, new StudentNotFoundException("Student not found id: " + studentId));
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) throws ServiceException {
        if (id < 1 || !isExistById(id)) throw new ServiceException("Can't delete student. No student with id: " + id, new StudentNotFoundException("Student not found id: " + id));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean isExistById(int id) {
        return studentRepository.existsById(id);
    }
}
