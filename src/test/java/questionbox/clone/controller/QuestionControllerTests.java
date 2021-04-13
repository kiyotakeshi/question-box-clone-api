package questionbox.clone.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import questionbox.clone.entity.Question;
import questionbox.clone.service.QuestionService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
		var question = new Question("質問", "回答", "やまざき", "きよた", true, true);
		List<Question> questions = Arrays.asList(question);
		when(service.findAll()).thenReturn(questions);

		this.mockMvc.perform(get("/list") //
				.param("answer", "true").param("archive", "true").accept(MediaType.APPLICATION_JSON)) //
				.andDo(print()) //
				.andExpect(status().isOk()) //
				.andDo(document("question-list", //
						requestParameters(parameterWithName("answer").description("回答済みとしてマークされた質問のみを抽出する場合 True"),
								parameterWithName("archive").description("アーカイブ済みとしてマークされた質問のみを抽出する場合 True")),
						responseFields(fieldWithPath("[].id").description("投稿ID"), //
								fieldWithPath("[].questioner").description("質問者"), //
								fieldWithPath("[].post").description("質問内容"), //
								fieldWithPath("[].respondent").description("回答者"), //
								fieldWithPath("[].answer").description("回答内容"), //
								fieldWithPath("[].answered").description("回答フラグ"), //
								fieldWithPath("[].archived").description("アーカイブフラグ").optional() //
						)));
	}

	@Test
	void shouldSuccessAddQuestion() throws Exception {
		// TODO テスト修正
		var question = new Question("質問", "回答", "やまざき", "きよた", true, true);
		List<Question> questions = Arrays.asList(question);
		when(service.findAll()).thenReturn(questions);
		// var question = new Question(2, "やまざき", "アザラシは電気うなぎの夢を見るか", null, null, false,
		// false);
		// when(service.add(any())).thenReturn(question);

		this.mockMvc.perform(get("/list") //
				.param("answer", "true").param("archive", "true").accept(MediaType.APPLICATION_JSON)) //
				.andDo(print()) //
				.andExpect(status().isOk()) //
				.andDo(document("question-list", //
						requestParameters(parameterWithName("answer").description("回答済みとしてマークされた質問のみを抽出する場合 True"),
								parameterWithName("archive").description("アーカイブ済みとしてマークされた質問のみを抽出する場合 True")),
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
