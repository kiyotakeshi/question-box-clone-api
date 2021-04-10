package questionbox.clone.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class QuestionControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnQuestionList() throws Exception {
		this.mockMvc.perform(get("/list") //
				.accept(MediaType.APPLICATION_JSON)) //
				.andDo(print()) //
				.andExpect(status().isOk()) //
				.andDo(document("質問一覧", //
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