package hp.care.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hp.care.app.entity.User;
import hp.care.app.repo.UserRepository;
import hp.care.app.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public Long saveUser(User user) {
		return repo.save(user).getId();
		
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return repo.findByUsername(username);
	}

}
