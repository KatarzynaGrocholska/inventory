package pl.project.inventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.project.inventory.service.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserDetailsService userDetailService;
@Bean
public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp();
    }

@Bean
        public DaoAuthenticationProvider authenticationProvider(){
            DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsService() );
            authProvider.setPasswordEncoder(passwordEncoder());

            return authProvider;
        }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/countries/add","/producers/add","/wines/add","/users/add" ).hasAnyRole("ADMIN","USER")
                .antMatchers("/countries/edit","/producers/edit","/wines/edit","/users/edit").hasRole("ADMIN")
                .antMatchers("/countries/form","/producers/form","/wines/form", "/users/form").hasRole("ADMIN")
                .antMatchers("/countries/formEdit","/producers/formEdit","/wines/formEdit","/users/formEdit").hasRole("ADMIN")
                .antMatchers("/users/list").hasRole("ADMIN")
                .antMatchers("countries/list","wines/list","producers/list").hasAnyRole("ADMIN","USER")
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                .antMatchers("/wines/addByUser").hasRole("USER")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .formLogin().permitAll();



    }


}
