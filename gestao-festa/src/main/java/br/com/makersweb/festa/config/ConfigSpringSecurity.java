/**
 * 
 */
package br.com.makersweb.festa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 *
 * @author anderson.aristides
 *
 */
@Configuration
public class ConfigSpringSecurity {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
			.withUser("admin").password("s3nh4").roles("USER");
	}

}
