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

	@Embedded
	Comment comment;

	/**
	 * 質問者
	 */
	String questioner;

	/**
	 * 回答者
	 */
	String respondent;

	/**
	 * 回答済みフラグ
	 */
	boolean answered;

	/**
	 * 削除済み（アーカイブ済み）フラグ
	 */
	boolean archived;

}
