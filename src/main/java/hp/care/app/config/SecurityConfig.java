package hp.care.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hp.care.app.constants.UsersRoles;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsservice;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsservice).
		passwordEncoder(passwordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/patient/register","/patient/save").permitAll()
		.antMatchers("/patient/all").hasAuthority(UsersRoles.Admin.name())
		.antMatchers("/doctor/**").hasAnyAuthority(UsersRoles.Admin.name())
		.antMatchers("/spec/**").hasAnyAuthority(UsersRoles.Admin.name())
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/spec/all",true)
		.and()
		.logout();
		
	}
}
