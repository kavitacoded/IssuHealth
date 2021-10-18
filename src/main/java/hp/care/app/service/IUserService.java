package hp.care.app.service;



import java.util.Optional;

import hp.care.app.entity.User;

public interface IUserService {

	
	Long saveUser(User user);
	
	Optional <User> findByUsername(String username);
	
}
