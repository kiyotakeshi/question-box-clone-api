package questionbox.clone.shigesankiyota.co.jp.questionboxClone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Content {

	String question;

	String answer;

}
