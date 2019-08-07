package io.javabrains.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.javabrains.model.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student,Integer>{
	

}
