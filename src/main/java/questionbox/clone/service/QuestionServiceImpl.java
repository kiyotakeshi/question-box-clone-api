package questionbox.clone.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import questionbox.clone.controller.commands.QuestionCommand;
import questionbox.clone.entity.Question;
import questionbox.clone.repository.QuestionRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	QuestionRepository repository;

	public List<Question> findAll() {
		return this.repository.findAll();
	}

	public Question findOneById(UUID id) {
		return this.repository.getOne(id);
	}

	@Override
	public Question add(QuestionCommand command) {
		// TODO: 回答者の情報を渡せるようにする(ユーザの概念ができた後)
		var question = new Question(command.getQuestioner(), command.getPost(), "回答者");
		return this.repository.save(question);
	}

	public Question archive(UUID id) {
		return this.repository.getOne(id);
	}

}
