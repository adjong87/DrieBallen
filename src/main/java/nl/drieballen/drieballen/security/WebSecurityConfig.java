package nl.drieballen.drieballen.security;

import nl.drieballen.drieballen.security.jwt.AuthEntryPointJwt;
import nl.drieballen.drieballen.security.jwt.AuthTokenFilter;
import nl.drieballen.drieballen.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().and().csrf().disable().formLogin().disable()
                .cors().and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/auth/signUp").hasRole("ADMIN")
                .antMatchers("/delete/**/photo").authenticated()
                .antMatchers("/upload/**").authenticated()
                .antMatchers("/upload/**/**").authenticated()
                .antMatchers("/download/**").permitAll()
                .antMatchers("/profiles/getUserData").authenticated()
                .antMatchers("/profiles/profile").hasAnyRole("ADMIN", "MODERATOR", "USER")
                .antMatchers("/profiles/**").hasAnyRole("ADMIN", "MODERATOR")
                .antMatchers("/profiles/**/photo").hasAnyRole("ADMIN", "MODERATOR", "USER")
                .antMatchers("/profiles/delete/**").hasRole("ADMIN")
                .antMatchers("/scorecards/card").hasAnyRole("ADMIN","MODERATOR")
                .antMatchers("/scorecards/donecard").hasAnyRole("ADMIN", "USER", "MODERATOR")
                .antMatchers("/scorecards/**").hasRole("MODERATOR")
                .antMatchers("/playedgame/find").hasAnyRole("USER", "ADMIN", "MODERATOR")
                .antMatchers("/playedgame/findbyid").hasAnyRole("USER", "ADMIN", "MODERATOR")
                .antMatchers("/playedgame/createGame").hasRole("ADMIN")
                .anyRequest().denyAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}