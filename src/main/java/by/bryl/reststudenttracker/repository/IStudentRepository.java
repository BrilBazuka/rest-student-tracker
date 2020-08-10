package by.bryl.reststudenttracker.repository;

import by.bryl.reststudenttracker.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Student}
 *
 * @author Andrew Bryl
 */

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
