package questionbox.clone.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
public class Question {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
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
	String answer = null;

	/**
	 * 回答済みフラグ
	 */
	boolean answered = false;

	/**
	 * 削除済み（アーカイブ済み）フラグ
	 */
	boolean archived = false;

	public Question(String questioner, String post, String respondent) {
		this.questioner = questioner;
		this.post = post;
		this.respondent = respondent;
	}

}
