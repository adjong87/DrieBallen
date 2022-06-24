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
                .antMatchers("/members/profile").hasAnyRole("ADMIN", "MODERATOR", "USER")
                .antMatchers("/members/**").hasRole("ADMIN")
                .antMatchers("/members/delete/**").hasRole("ADMIN")
                .antMatchers("/scorecards/card").hasAnyRole("ADMIN", "USER", "MODERATOR")
                .antMatchers("/scorecards/**").hasRole("MODERATOR")
//                .antMatchers("/scorecards/referee").hasRole("MOD")
//                .antMatchers("/scorecards/fill").hasRole("MOD")
//                .antMatchers("/scorecards/delete").hasRole("ADMIN")
                .antMatchers("/playedGame/find").hasAnyRole("USER", "ADMIN", "MODERATOR")
                .antMatchers("/playedGame/createGame").hasRole("ADMIN")
                .anyRequest().denyAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}