package questionbox.clone.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import questionbox.clone.entity.Question;
import questionbox.clone.service.QuestionService;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

	final QuestionService service;

	@GetMapping("/list")
	@ResponseBody
	public List<Question> getQuestionList(@RequestParam(name = "answer", defaultValue = "false") boolean answer,
			@RequestParam(name = "archived", defaultValue = "false") boolean archive) {
		// TODO 実装
		// var question = new Question(2, "質問", "回答", "やまざき", "きよた", true, true);
		// return Arrays.asList(question);
		return this.service.findAll();
	}

}
