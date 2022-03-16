package com.api.devweek;

import com.api.devweek.entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DevweekApplicationTests {

	private final String URL_API = "/api/regioes";

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private Regiao conttroller;

	@Test
	void getControllerTest() throws Exception {
		mockMvc.perform(get(URL_API)).andExpect(status().isOk());
	}

	@Test
	public void getByIdControllerTest() throws Exception {
		mockMvc.perform(get(URL_API+"/1"))
				.andExpect(status().isOk()
				);
	}
	@Test
	public void addNewRegiaoTest() throws Exception {
		Long id = Long.valueOf(10);
		Regiao newRegiao = new Regiao(id,"Noroeste", 57);

		mockMvc.perform(post(URL_API+"/novo")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(newRegiao)))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteByIdRedgiaoTest() throws Exception {
		//delete("/api/foo/{id}", "")
		mockMvc.perform(delete(URL_API+"/remover/{id}","8")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
