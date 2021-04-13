package questionbox.clone.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class QuestionTests {

	@Autowired
	TestEntityManager em;

	@Test
	void mapping() {
		// for check DML
		// var newQuestion = new Question(100, "質問", "回答", "やまざき", "きよた", true, true);
	 	// em.persistAndFlush(newQuestion);

		var question = this.em.find(Question.class, 1);
		assertThat(question.getAnswer()).isEqualTo("回答");
	}
}
