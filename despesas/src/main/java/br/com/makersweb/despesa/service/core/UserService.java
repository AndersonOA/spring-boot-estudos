/**
 * 
 */
package br.com.makersweb.despesa.service.core;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.despesa.domain.Role;
import br.com.makersweb.despesa.domain.User;
import br.com.makersweb.despesa.repository.IRoleRepository;
import br.com.makersweb.despesa.repository.IUserRepository;
import br.com.makersweb.despesa.service.IUserService;

/**
 *
 * @author anderson.aristides
 *
 */
@Service
@EnableTransactionManagement
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void salvar(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}
