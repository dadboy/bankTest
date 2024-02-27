package om.example.banktest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.banktest.BanktestApplication;
import com.example.banktest.config.RegexProperties;
import com.example.banktest.dto.LoginResponse;

@EnableConfigurationProperties(value = RegexProperties.class)
@SpringBootTest(classes = BanktestApplication.class, 
				webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, 
				properties = {"spring.config.name=application", "spring.config.location=classpath:application.yml" })
@ActiveProfiles("test")
public class AuthControllerTest {

	@LocalServerPort
	private int port;

    private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private RegexProperties regexProperties;

	@Test
	public void testLoginApi() {
		// Cambia estos valores según tus necesidades
		String username = "david";
		String password = "asdasdasd";
		String url = "http://localhost:" + port + "/banktest/api/v1/login";

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("user", username);
        formData.add("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        ResponseEntity<LoginResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, LoginResponse.class);

        assertEquals(200, response.getStatusCodeValue());

        LoginResponse loginResponse = response.getBody();
        assertNotNull(loginResponse);
        assertNotNull(loginResponse.getToken());

    }
}