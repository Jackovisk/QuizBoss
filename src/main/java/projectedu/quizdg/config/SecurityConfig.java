package projectedu.quizdg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita a proteção CSRF temporariamente para facilitar testes em APIs REST
                .csrf(csrf -> csrf.disable())
                // Permite que qualquer requisição passe sem exigir login
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }
}