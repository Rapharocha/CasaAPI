package com.trabalho.casadeshow.api.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.trabalho.casadeshow.api.builders.CasasBuilders;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
public class CasaResourceTest {

	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mockMvc;
	
    @Mock
	public CasaResources casaResources;
		
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		
	}
	 
	@Test
	public void deveRetornarStatus200QuandoListar() throws Exception  {
	 String url = "/api/casas";
	 this.mockMvc.perform(get(url)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}

