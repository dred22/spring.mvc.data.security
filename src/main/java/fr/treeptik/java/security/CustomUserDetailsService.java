package fr.treeptik.java.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.java.models.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	{

		System.out.println("CustomUserDetailsService+??????????????+++++++++++");
	}
	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	public UserDetails loadUserByUsername(String ssoId) {
		System.out.println("ssoId +++++++++++++++++++++++++ " + ssoId);
		logger.info("ssoId : {}", ssoId);
		return null;
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		System.out.println("ssoId +++++++++++++++++++++++++ " + user);

		logger.info("UserProfile : {}", user);

		logger.info("authorities : {}", user);
		return null;
	}

}
