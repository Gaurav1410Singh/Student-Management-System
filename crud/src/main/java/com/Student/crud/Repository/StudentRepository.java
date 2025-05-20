package com.Student.crud.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Student.crud.Entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findByName (String name);

}