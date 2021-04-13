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

	/**
	 * 質問の登録処理を行います。
	 * @param question 登録しようとする質問
	 * @return 登録済された質問
	 */
	public Question add(Question question) {
		// TODO 質問を登録する処理
		return findOneById(question.getId());
	}

}
