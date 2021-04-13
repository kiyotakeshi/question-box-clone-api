package questionbox.clone.service;

import questionbox.clone.entity.Question;

import java.util.List;

public interface QuestionService {

	List<Question> findAll();

	Question findOneById(int id);

	Question add(Question question);

}
