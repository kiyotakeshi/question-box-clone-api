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
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.*;
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

	/**
	 * 質問の一覧を取得する事ができるテスト
	 */
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

	/**
	 * 特定の質問をアーカイブする事ができるテスト
	 */
	@Test
	void shouldSuccessDelete() throws Exception {
		// fixme 永続化できるようになったら新規作成後に一度永続化したあとアーカイブするなど、意味のあるテストとして修正するべき
		var question = new Question("やまざき", "アザラシは電気うなぎの夢をみるか", "きよた", "みません", true, true);
		when(this.service.archive(any())).thenReturn(question);
		this.mockMvc.perform(patch("/q/{UUID}", UUID.randomUUID().toString()) //
				.accept(MediaType.APPLICATION_JSON)) //
				.andDo(print()) //
				.andExpect(status().isOk()) //
				.andDo(document("question-archive", //
						pathParameters(parameterWithName("UUID").description("アーカイブ対象質問の UUID")),
						responseFields(fieldWithPath("id").description("投稿ID"), //
								fieldWithPath("questioner").description("質問者"), //
								fieldWithPath("post").description("質問内容"), //
								fieldWithPath("respondent").description("回答者"), //
								fieldWithPath("answer").description("回答内容"), //
								fieldWithPath("answered").description("回答フラグ"), //
								fieldWithPath("archived").description("アーカイブフラグ").optional() //
						)));
	}

}
