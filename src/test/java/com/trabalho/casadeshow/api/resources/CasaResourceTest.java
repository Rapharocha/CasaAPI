package com.trabalho.casadeshow.api.resources;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.trabalho.casadeshow.api.builders.CasasBuilders;
import com.trabalho.casadeshow.api.model.Cadastrocasa;
import com.trabalho.casadeshow.api.repository.Cadastroshow;

@SpringBootTest
@AutoConfigureMockMvc
public class CasaResourceTest {

	@Autowired
	public WebApplicationContext context;
	private MockMvc mockMvc;
	
	@MockBean
	public Cadastroshow cadastroshow;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void deveRetornarStatus200QuandoListar() throws Exception {
	 List<Cadastrocasa> casas = Arrays.asList(CasasBuilders.umaCasa().retona(),
			                                  CasasBuilders.umaCasa().comCodigo(2l).comNome("Arena").retona());
	 
	 Mockito.when(cadastroshow.findAll()).thenReturn(casas);
	 String url = "/api/casas";
	 this.mockMvc.perform(get(url)).andExpect(MockMvcResultMatchers.status().isOk());
	  
	}
}

