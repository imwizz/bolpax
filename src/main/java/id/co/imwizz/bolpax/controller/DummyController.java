package id.co.imwizz.bolpax.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dummy")
@CrossOrigin
public class DummyController {
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
	public ResponseEntity<String> dummy() {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        return new ResponseEntity<String>("Keluarlah!!!", headers, HttpStatus.OK);
	}

}
