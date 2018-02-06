package selfstudy.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	private AccountDao accountDao;
	
	private static final Logger Log = LoggerFactory.getLogger(AccountController.class);

	@GetMapping("accounts/{id}")
	public String getAccountNameBy(@PathVariable final int id) {
		StopWatch sw = new StopWatch(Integer.toString(id));
		sw.start();
		
		String result = accountDao.getAccountNameBy(id);
		sw.stop();
		Log.info("Execution Time: {}.", sw);
		return result;
	}
	
	@GetMapping("accounts/{id}/evict")
	public String evictAccountIdFromCache(@PathVariable final int id) {
		accountDao.evictFromCache(id);
		return "evicted: " + id;
	}
}
