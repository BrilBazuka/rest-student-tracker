package by.bryl.reststudenttracker.controller;

import by.bryl.reststudenttracker.exception.ServiceException;
import by.bryl.reststudenttracker.model.Student;
import by.bryl.reststudenttracker.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for {@link Student}'s pages.
 *
 * @author Andrew Bryl
 */

@RestController
@RequestMapping("/student/api")
public class StudentRestController {

    private IStudentService studentService;

    @Autowired
    public StudentRestController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/list/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/list")
    public Student saveStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/list")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/list/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudentById(id);
        return "Deleted employee id: " + id;
    }
}
