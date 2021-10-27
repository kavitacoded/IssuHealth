package hp.care.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
	.antMatchers("/spec/**").hasAuthority(UsersRoles.Admin.name())
	.antMatchers("/doctor/**").hasAuthority(UsersRoles.Admin.name())
	.antMatchers("/appointment/register","/appointment/save","/appointment/all").hasAuthority(UsersRoles.Admin.name())
	.antMatchers("/appointment/view","/appoinemtnet/viewSlot").hasAuthority(UsersRoles.Patient.name())
	.antMatchers("/user/login","/login").permitAll()
	
	.anyRequest().authenticated()
	
	.and()
	.formLogin()
	.loginPage("/user/login")   //show login page
	.loginProcessingUrl("/login")	//post
	.defaultSuccessUrl("/spec/all",true)
	.defaultSuccessUrl("/user/setup",true)
	.failureUrl("/user/login?error=true") //If login is failed
		
	
	.and()
	.logout()
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	.logoutSuccessUrl("/user/login?logout=true")//on logout success
	;
	
	}
}
