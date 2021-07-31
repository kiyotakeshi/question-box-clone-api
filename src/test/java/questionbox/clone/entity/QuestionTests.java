package questionbox.clone.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class QuestionTests {

	@Autowired
	TestEntityManager em;

	@Test
	void mapping() {
		// for check DML
    // var newQuestion = new Question("質問", "回答", "やまざき", "きよた", true, true);
    // em.persistAndFlush(newQuestion);

    var role1 = new Role(ERole.ROLE_USER);
    var role2 = new Role(ERole.ROLE_ADMIN);
    var savedRoles1 = em.persistAndFlush(role1);
    var savedRoles2 = em.persistAndFlush(role2);

    Set<Role> roles = new HashSet<>();
    roles.add(savedRoles1);
    roles.add(savedRoles2);

    var newUser = new User("shigekazu", "test@example.com", "12345", roles);
    em.persistAndFlush(newUser);


//		var question = this.em.find(Question.class, UUID.fromString("16294490-5fe5-43b1-925e-2e60b75c1b26"));
//		assertThat(question.getAnswer()).isEqualTo("回答");
	}

}
