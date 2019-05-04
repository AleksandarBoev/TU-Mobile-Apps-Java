package app.repository;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import app.domain.entities.Student;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM students")
    List<Student> getAllStudents();

    @Query("SELECT * FROM students s WHERE s.id = :id")
    Student getStudentById(int id);

    @Insert
    void insertStudent(Student student);
}
