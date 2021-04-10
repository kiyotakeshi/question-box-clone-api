package questionbox.clone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import questionbox.clone.entity.Question;

import java.util.Arrays;
import java.util.List;

@RestController
public class QuestionController {

	@GetMapping("/list")
	@ResponseBody
	public List<Question> list() {
		// TODO 実装
		var question = new Question(2, "質問", "回答", "やまざき", "きよた", true, true);
		return Arrays.asList(question);
	}

}
