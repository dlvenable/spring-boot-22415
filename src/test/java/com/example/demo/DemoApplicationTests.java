package com.example.demo;

import com.example.demo.model.BrokenModel;
import com.example.demo.model.OkModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests
{
	@LocalServerPort
	private int port;

    @Test
    void GET_broken()
    {
    	TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<BrokenModel> getEntity = testRestTemplate.getForEntity(
				"http://localhost:{port}/broken", BrokenModel.class, port);

		assertThat(getEntity.getStatusCode(), equalTo(HttpStatus.OK));

		BrokenModel body = getEntity.getBody();
		assertThat(body, notNullValue());
		assertThat(body.getDemoId(), notNullValue());

		assertThat(body.getMyMap(), notNullValue());
		assertThat(body.getMyMap().size(), equalTo(1));
	}

    @Test
    void GET_broken_as_string()
    {
    	TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> getEntity = testRestTemplate.getForEntity(
				"http://localhost:{port}/broken", String.class, port);

		assertThat(getEntity.getStatusCode(), equalTo(HttpStatus.OK));

		System.out.println(getEntity.getBody());
	}

    @Test
    void GET_ok()
    {
    	TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<OkModel> getEntity = testRestTemplate.getForEntity(
				"http://localhost:{port}/ok", OkModel.class, port);

		assertThat(getEntity.getStatusCode(), equalTo(HttpStatus.OK));

		OkModel body = getEntity.getBody();
		assertThat(body, notNullValue());
		assertThat(body.getDemoId(), notNullValue());

		assertThat(body.getListOfNodes(), notNullValue());
		assertThat(body.getListOfNodes().size(), equalTo(1));
		assertThat(body.getListOfNodes().get(0), notNullValue());
	}
}
