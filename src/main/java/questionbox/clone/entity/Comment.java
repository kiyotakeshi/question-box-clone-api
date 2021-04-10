package questionbox.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * ユーザによる質問または回答コメント
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Comment {

	String question;

	String answer;

}
