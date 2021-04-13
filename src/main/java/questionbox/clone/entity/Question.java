package questionbox.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * ユーザへの質問
 */
@Getter
@NoArgsConstructor
@Entity
public class Question {

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;

	/**
	 * 質問者
	 */
	String questioner;

	/**
	 * 質問内容
	 */
	String post;

	/**
	 * 回答者
	 */
	String respondent;

	/**
	 * 回答内容
	 */
	String answer;

	/**
	 * 回答済みフラグ
	 */
	boolean answered;

	/**
	 * 削除済み（アーカイブ済み）フラグ
	 */
	boolean archived;

	public Question(String questioner, String post, String respondent, String answer, boolean answered, boolean archived) {
		this.questioner = questioner;
		this.post = post;
		this.respondent = respondent;
		this.answer = answer;
		this.answered = answered;
		this.archived = archived;
	}

}
