package questionbox.clone.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jt on 6/13/20.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests(authorize -> {
        authorize.antMatchers(HttpMethod.GET, "/", "/login").permitAll();
//        authorize.antMatchers(HttpMethod.POST, "/api/todo").permitAll();
      } )
      .authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .formLogin().and()
      .httpBasic()
      .and()
      .csrf().disable();
  }
}
