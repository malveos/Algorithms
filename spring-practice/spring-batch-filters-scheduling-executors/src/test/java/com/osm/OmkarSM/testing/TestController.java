package com.osm.OmkarSM.testing;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.osm.OmkarSM.Controller;
import com.osm.OmkarSM.testing.controller.ControllerJunit;
import com.osm.OmkarSM.testing.repos.SampleRepository;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(Controller.class)
public class TestController {

	/**
	 * ControllerJunit is controller to test so we are mocking SampleRepository.
	 * MockMvc is used to perform api calls to test apis.
	 * 
	 */

	@Autowired
	MockMvc mvc;

	@Mock
	SampleRepository repos;

	@InjectMocks
	ControllerJunit tc;

	@Before
    public void setup() {
        /*
         *  MockMvc standalone approach
         *  We can configure exceptionhandler, filters here for testing.
         */
		
        mvc = MockMvcBuilders.standaloneSetup(tc)
                //.setControllerAdvice(new SuperHeroExceptionHandler())
                //.addFilters(new SuperHeroFilter())
                .build();
    }

	@Test
	public void testControllerCallReturningString() throws Exception {
		when(repos.getStringMessage()).thenReturn("OmkarMAne");

		// setup rest api call
		//MockHttpServletResponse response = 
				mvc.perform(
				get("/get")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("OmkarMAne"));


        // then check output response
        /*assertEquals(response.getStatus(), HttpStatus.OK.value());
        assertEquals(response.getContentAsString(),("OmkarMAne"));*/
	}

	@Test
	public void testControllerCallWithMVC() throws Exception {
		when(repos.getStringMessage()).thenReturn("OSM");
		mvc.perform(MockMvcRequestBuilders.get("/get")
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("OSM"));
	}

	@Test
	public void testWithJsonOutputMVC() throws Exception {
		mvc.perform(post("/getJson")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$['name']", is("Omkar")))
		.andExpect(jsonPath("$.id", is(15)));
	}

	@Test
	public void testWithJsonOutputResponse() throws Exception {

		// setup rest api call
        MockHttpServletResponse response = mvc.perform(
                post("/getJson")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
 
        // then check output response
        assertEquals(response.getStatus(), HttpStatus.OK.value());
        assertEquals(response.getContentAsString(),("{\"id\":15,\"name\":\"Omkar\"}"));
	}
}
