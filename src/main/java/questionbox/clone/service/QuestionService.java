package questionbox.clone.service;

import org.springframework.stereotype.Service;
import questionbox.clone.entity.Question;

import java.util.List;

public interface QuestionService {

	List<Question> findAll();

}
