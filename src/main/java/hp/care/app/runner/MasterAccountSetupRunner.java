//package hp.care.app.runner;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import hp.care.app.constants.UsersRoles;
//import hp.care.app.entity.User;
//import hp.care.app.service.IUserService;
//import hp.care.app.util.UserUtil;
//@Component
//public class MasterAccountSetupRunner implements CommandLineRunner {
//
//	@Value("${master.user.name}")
//	private String displayName;
//	
//	@Value("${master.user.email}")
//	private String username;
//	
//	@Autowired
//	private IUserService userService;
//	
//	@Autowired
//	private UserUtil userUtil;
//	
//	public void run(String... args) throws Exception {
//		if(!userService.findByUsername(username).isPresent()) {
//			User user = new User();
//			user.setDispalyName(displayName);
//			user.setUsername(username);
//			user.setPassword(userUtil.genPwd());
//			user.setRole(UsersRoles.Admin.name());
//			userService.saveUser(user);
//			//TODO : EMAIL SERVICE
//		}
//	}	
//
//}
