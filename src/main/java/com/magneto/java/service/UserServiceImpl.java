package com.magneto.java.service;

import com.magneto.java.constants.Constatns;
import com.magneto.java.model.UserinfoResponse;
import com.magneto.java.model.UserinforRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {

    }
    @Autowired
    Environment environment;

    public UserinfoResponse createUser(UserinforRequest request) {

        UserinfoResponse userinfoResponse = new UserinfoResponse();

        try {
            String errorMessage = validateUser(request);
            if (errorMessage != null && errorMessage.length() > 0) {
                userinfoResponse.setMessage(errorMessage);
                userinfoResponse.setStatus("ERROR IN SUBMITTING");
            } else {

                // using rest if it is supported formsubmit
                /*HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                map.add("firstname", request.getFirstName());
                if(request.middleName!=null && request.middleName.length()>0) {
                    map.add("middlename",request.getMiddleName());
                }
                        map.add("lastname",request.getLastName())  ;
                        map.add(" email",request.getEmailaddress());
                        map.add  ("password",request.getPassword())   ;
                        map.add("  confirmation",request.getConfirmationPassword());

                HttpEntity<MultiValueMap<String, String>> requestURI = new HttpEntity<MultiValueMap<String, String>>(map, headers);
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.postForEntity(environment.getProperty("magento.uri"), request, String.class);


                if (response.getStatusCode().is2xxSuccessful()) {
                    userinfoResponse.setStatus("SUCCESSFULLY SUBMITTED");
                } else {
                    userinfoResponse.setStatus("ERROR IN SUBMITTING");
                }
                */

                // calling from a java directly a ruby script

               /* url=ARGV[0]
                firstname=ARGV[1]
                lastname=ARGV[2]
                password=ARGV[3]
                confirmpassword=ARGV[4]
                email=ARGV[5]*/

               StringBuilder commandLine = new StringBuilder();
               commandLine.append(environment.getProperty("magento.uri")).append(" ").append(request.getFirstName()).append(" ").append(request.getLastName()).
                       append(" ").append(request.getPassword()).append(" ").append(request.getConfirmationPassword()).append(" ").append(request.getEmailaddress());
                if(request.middleName!=null && request.middleName.length()>0) {
                    commandLine.append(" ").append(request.getMiddleName());
                }

                Process process = Runtime.getRuntime().exec("ruby " + environment.getProperty("login.script.path")+ " "+commandLine);
                process.waitFor();

                BufferedReader processIn = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = processIn.readLine()) != null) {
                    System.out.println(line);
                }

                userinfoResponse.setStatus("SUCCESSFULLY SUBMITTED");

            }

        } catch (Exception e) {
            userinfoResponse.setMessage(e.getMessage());
            userinfoResponse.setStatus("ERROR IN SUBMITTING");
        }

        return userinfoResponse;
    }

    private String  validateUser(UserinforRequest request) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        StringBuilder errorMessage = new StringBuilder();
        Set<ConstraintViolation<UserinforRequest>> violations = validator.validate(request);
        for (ConstraintViolation<UserinforRequest> violation : violations) {
            errorMessage.append(violation.getMessage());
        }
        if(!request.getPassword().equals(request.getConfirmationPassword())) {
            errorMessage.append(Constatns.PASSWORD_MISMATCH);
        }
        return errorMessage.toString();
    }
}
