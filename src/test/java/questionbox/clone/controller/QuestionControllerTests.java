package questionbox.clone.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import questionbox.clone.QuestionBoxCloneApplication;
import questionbox.clone.entity.Question;
import questionbox.clone.service.QuestionService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class QuestionControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QuestionService service;

	@Test
	void shouldReturnQuestionList() throws Exception {

		var question = new Question(1, "質問", "回答", "やまざき", "きよた", true, true);
		var question2 = new Question(2, "質問", "回答", "きよた", "やまざき", false, false);
		List<Question> questions = Arrays.asList(question, question2);

		when(service.findAll()).thenReturn(questions);
		//
		this.mockMvc.perform(get("/list") //
				.accept(MediaType.APPLICATION_JSON)) //
				.andDo(print()) //
				.andExpect(status().isOk()) //
				.andDo(document("question-list", //
						responseFields(fieldWithPath("[].id").description("投稿ID"), //
								fieldWithPath("[].questioner").description("質問者"), //
								fieldWithPath("[].post").description("質問内容"), //
								fieldWithPath("[].respondent").description("回答者"), //
								fieldWithPath("[].answer").description("回答内容"), //
								fieldWithPath("[].answered").description("回答フラグ"), //
								fieldWithPath("[].archived").description("アーカイブフラグ").optional() //
						)));
	}

}