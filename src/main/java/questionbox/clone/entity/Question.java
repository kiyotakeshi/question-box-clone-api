package questionbox.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ユーザへの質問
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

	@Id
	private int id;

	/**
	 * 質問者
	 */
	String questioner;

	String post;

	/**
	 * 回答者
	 */
	String respondent;

	String answer;

	/**
	 * 回答済みフラグ
	 */
	boolean answered;

	/**
	 * 削除済み（アーカイブ済み）フラグ
	 */
	boolean archived;

}
