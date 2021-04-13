package questionbox.clone.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
	public Question add(Question question) {
		return this.repository.save(question);
	}

	public Question archive(UUID id) {
		return this.repository.getOne(id);
	}

}
