package io.javabrains.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.javabrains.model.Adviser;

@Repository
public interface AdviserRepo extends JpaRepository<Adviser,Integer>{


	
}
