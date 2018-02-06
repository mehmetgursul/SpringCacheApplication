package selfstudy.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {
	
	private static final Logger Log = LoggerFactory.getLogger(AccountDao.class);
	
	@Cacheable("accounts")
	public String getAccountNameBy(final int id)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex)
		{
			Log.info("Thread interrupted whilst sleeping", ex);
		}
		Log.info("ID {} is linked to XYZ", id);
		return "XYZ";
	}
	
	@CacheEvict("accounts")
	public void evictFromCache(final int id) {
		Log.info("Evicted key {} from cache.", id);
	}
}
