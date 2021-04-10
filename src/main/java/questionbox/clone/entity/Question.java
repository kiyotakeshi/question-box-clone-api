package questionbox.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

	@Id
	private int id;

	@Embedded
	Content content;

	String questioner;

	String respondent;

	boolean answered;

	boolean archived;

}
