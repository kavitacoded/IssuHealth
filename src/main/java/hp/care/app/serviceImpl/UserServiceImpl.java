package hp.care.app.serviceImpl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hp.care.app.entity.User;
import hp.care.app.repo.UserRepository;
import hp.care.app.service.IUserService;


@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public Long saveUser(User user) {
		
		//read generated password
		String pwd=user.getPassword();
		//encode password
		String enPwd=passwordEncoder.encode(pwd);
		//set back to object
		user.setPassword(enPwd);
		return repo.save(user).getId();
		
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt=findByUsername(username);
		if(!opt.isPresent())
			throw new UsernameNotFoundException(username);
		else {
			User user=opt.get();
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					Collections.singletonList (new SimpleGrantedAuthority(user.getRole()
							)));
					
		}
		
	}

}
