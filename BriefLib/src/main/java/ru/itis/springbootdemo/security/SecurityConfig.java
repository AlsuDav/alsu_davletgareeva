package ru.itis.springbootdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier(value = "customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/users/**").hasAuthority("ADMIN")  //стр юзерс получает только роль админ
                .antMatchers("/").permitAll()
                .antMatchers("/profile").authenticated()//only to authorized users
                .antMatchers("/changepassword").authenticated()
                .antMatchers("/bookmarks").authenticated()
                .antMatchers("/signUp").permitAll() //access to all users
                .antMatchers("/index").permitAll()
                .antMatchers("/confirm/**").permitAll()
                .antMatchers("/profile/edit").authenticated()
                .antMatchers("/editProfile").authenticated()
                .antMatchers("/notes").authenticated()
                .antMatchers("/newNote").authenticated()
                .antMatchers("note/**").authenticated()
                .antMatchers("/deleteNote/**").authenticated()
                .antMatchers("/files").permitAll()
                .antMatchers("/search/**").permitAll()
                .and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository());

        http.formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/")
                .failureUrl("/signIn?error")
                .usernameParameter("email")  //def-username, but in our form отпр.email
                .permitAll();

        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/signIn")
                .deleteCookies("SESSION", "remember-me")
                .invalidateHttpSession(true);
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}

