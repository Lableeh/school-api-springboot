package io.javabrains.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.javabrains.model.Section;

@Repository
public interface SectionRepository extends JpaRepository <Section,Integer>{


}
