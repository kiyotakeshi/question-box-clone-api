package questionbox.clone.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionbox.clone.entity.Question;
import questionbox.clone.repository.QuestionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	QuestionRepository repository;

	public List<Question> findAll() {
		return this.repository.findAll();
	}

}
