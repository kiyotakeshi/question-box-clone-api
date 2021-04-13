package questionbox.clone.controller.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 質問
 */
@Getter
@AllArgsConstructor
public class QuestionCommand {

	/**
	 * 質問者
	 */
	public String questioner;

	/**
	 * 質問内容
	 */
	public String post;

}
