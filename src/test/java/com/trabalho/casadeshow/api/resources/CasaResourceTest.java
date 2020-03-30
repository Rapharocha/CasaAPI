package com.trabalho.casadeshow.api.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.trabalho.casadeshow.api.services.CasaServices;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
public class CasaResourceTest {

	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@MockBean
	private CasaServices casaServices;
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		MockitoAnnotations.initMocks(this);
	}
	 
	@Test
	public void deveRetornarStatus200QuandoListar() throws Exception  {
	 String url = "/api/casas";
	 this.mockMvc.perform(get(url)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deveRetornarStatus201QuandoSalvar() throws Exception {
	 String url = "/api/casas";
	 this.mockMvc.perform(post(url).content("{\"nome\" : \"Avenue\", \"endereco\" : \"Rua Presidente Campo Salles\"}")
			 .contentType(MediaType.APPLICATION_JSON))
	 .andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void deveRetornar200QuandoBuscarUmaCasa() throws Exception {
	 String url = "/api/casas/1";
	 this.mockMvc.perform(get(url)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
