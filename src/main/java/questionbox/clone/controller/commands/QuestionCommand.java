package questionbox.clone.controller.commands;

import lombok.Getter;

import java.io.Serializable;

/**
 * 質問
 */
@Getter
public class QuestionCommand implements Serializable {

	/**
	 * 質問者
	 */
	public String questioner;

	/**
	 * 質問内容
	 */
	public String post;

}
