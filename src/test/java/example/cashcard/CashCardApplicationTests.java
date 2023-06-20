package example.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnACashWhenDataIsSaved() {
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);

		/**asserts that the request succeeded by checking for a 200 OK response status*/
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();

		/**test that the response contains the correct values*/
		/* DocumentContext documentContext = JsonPath.parse(response.getBody());

		Number id = documentContext.read("$.id");
		
		assertThat(id).isEqualTo(99);

		Double amount = documentContext.read("$.amount");

		assertThat(amount).isEqualTo(123.45); */
	}
}
