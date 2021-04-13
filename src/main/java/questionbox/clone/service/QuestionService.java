package questionbox.clone.service;

import questionbox.clone.controller.commands.QuestionCommand;
import questionbox.clone.entity.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionService {

	List<Question> findAll();

	Question findOneById(UUID id);

	Question add(QuestionCommand command);

	Question archive(UUID id);

}
