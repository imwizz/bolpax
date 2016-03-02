package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.model.Merchant;
import id.co.imwizz.bolpax.util.JsonMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Sangbas
*/
@RestController
@RequestMapping("/merchant")
public class MerchantController {
	
	@Autowired private MerchantDao merchantDao;

	/**
	 * Returns all merchants except user login
	 * @param userid
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "list")
    @ResponseBody
	public ResponseEntity<String> findUserByPhone(@RequestParam("userid") long userId) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Merchant> merchants = merchantDao.findMerchantsExceptMe(userId);
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(merchants), headers, HttpStatus.OK);
	}

}
