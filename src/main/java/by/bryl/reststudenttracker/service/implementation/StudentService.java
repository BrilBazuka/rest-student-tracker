package by.bryl.reststudenttracker.service.implementation;

import by.bryl.reststudenttracker.model.Student;
import by.bryl.reststudenttracker.repository.IStudentRepository;
import by.bryl.reststudenttracker.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public Student getStudentById(int id) {
        return studentRepository.getOne(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
