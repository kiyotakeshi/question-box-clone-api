package questionbox.clone.shigesankiyota.co.jp.questionboxClone.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class QuestionTests {

	@Autowired
	TestEntityManager em;

	@Test
	void mapping() {
		var content = new Content("回答", "質問内容");
		var question = new Question(1, content, "やまざき", "きよた", true, true);
		em.persistAndFlush(question);
		// this.manager.find(Question.class, 1);
	}

}
