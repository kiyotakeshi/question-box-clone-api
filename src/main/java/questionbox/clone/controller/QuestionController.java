package questionbox.clone.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import questionbox.clone.controller.commands.QuestionCommand;
import questionbox.clone.entity.Question;
import questionbox.clone.service.QuestionService;

import java.util.List;

@RestController
@AllArgsConstructor
@ResponseBody
public class QuestionController {

	final QuestionService service;

	@GetMapping("/list")
	public List<Question> getQuestionList(@RequestParam(name = "answer", defaultValue = "false") boolean answer,
			@RequestParam(name = "archived", defaultValue = "false") boolean archive) {
		// TODO 実装
		// var question = new Question(2, "質問", "回答", "やまざき", "きよた", true, true);
		// return Arrays.asList(question);
		return this.service.findAll();
	}

	@PostMapping(value = "/q", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Question postQuestion(@RequestBody QuestionCommand command) {
		// TODO 実装
		// TODO command から Question に値の貼り替え
		// TODO command ではなく 登録された結果を返却するよう修正
		return new Question();
		// return this.service.add(question);
	}

}
