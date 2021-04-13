package questionbox.clone.service;

import questionbox.clone.entity.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionService {

	List<Question> findAll();

	Question findOneById(UUID id);

	Question add(Question question);

}
