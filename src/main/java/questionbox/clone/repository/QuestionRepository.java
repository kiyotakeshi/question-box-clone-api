package questionbox.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questionbox.clone.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
