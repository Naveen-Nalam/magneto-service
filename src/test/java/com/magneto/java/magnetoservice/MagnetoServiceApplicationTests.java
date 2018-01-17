package com.magneto.java.magnetoservice;

import com.magneto.java.model.UserinforRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { MagnetoServiceApplication.class })
@ComponentScan(value = "com.magneto.*")
public class MagnetoServiceApplicationTests {

	final String BASE_URL = "http://localhost:8080/service/api/user/create";


	@Test
	public void contextLoads() {

		UserinforRequest request=new UserinforRequest();
		request.setFirstName("same");
		request.setLastName("miamiga");
		request.setEmailaddress("miamia@ku.com");
		request.setPassword("sample12");
		request.setMiddleName("middlename");
		request.setConfirmationPassword("sample12");
		RestTemplate template = new RestTemplate();

		String result = template.postForObject(BASE_URL, request,String.class);
	}

}
