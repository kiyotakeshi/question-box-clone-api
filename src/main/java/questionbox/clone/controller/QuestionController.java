package questionbox.clone.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import questionbox.clone.controller.commands.QuestionCommand;
import questionbox.clone.entity.Question;
import questionbox.clone.service.QuestionService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class QuestionController {

	final QuestionService service;

	/**
	 * 質問の一覧を返却します。
	 * @param answer 回答済みの質問に絞る場合 true
	 * @param archive アーカイブ済みの質問に絞る場合 true
	 * @return 該当する質問の一覧
	 */
	@GetMapping("/list")
	public List<Question> getQuestionList(@RequestParam(name = "answer", defaultValue = "false") boolean answer,
			@RequestParam(name = "archived", defaultValue = "false") boolean archive) {
		// TODO 実装
		// var question = new Question(2, "質問", "回答", "やまざき", "きよた", true, true);
		// return Arrays.asList(question);
		return this.service.findAll();
	}

	@PostMapping(value = "/q")
	@ResponseStatus(HttpStatus.CREATED)
	public Question postQuestion(@RequestBody QuestionCommand command) {
		// TODO: 回答者の情報を渡せるようにする
		var question = new Question(command.getQuestioner(), command.getPost(), "回答者");
		return this.service.add(question);
	}

	/**
	 * 質問をアーカイブ（削除）し、アーカイブした質問を返却します。
	 * @param id アーカイブする対象の質問の ID
	 * @return アーカイブされた質問
	 */
	@PatchMapping("/q/{questionId}")
	@ResponseBody
	public Question archive(@PathVariable(value = "questionId", required = true) String id) {
		// TODO 実装
		return this.service.archive(UUID.fromString(id));
	}

}
