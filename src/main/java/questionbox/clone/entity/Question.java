package questionbox.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Embedded;
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

// generator の指定がなくても uuid で作られる
// 2021-04-13 19:05:05.408 TRACE 9033 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [7] as [BINARY] - [0bb353f0-4c77-42cb-a8c3-bd67570243ca]
//	@GeneratedValue( generator = "uuid2" )
//	@GenericGenerator( name = "uuid2", strategy = "uuid2" )
	@GeneratedValue
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
