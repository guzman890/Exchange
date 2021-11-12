package com.bcp.exchange.controller.impl;

import com.bcp.exchange.model.dto.AuthenticationRequest;
import com.bcp.exchange.model.dto.AuthenticationResponse;
import com.bcp.exchange.security.JWTUtil;
import com.bcp.exchange.service.impl.ExchangeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ExchangeUserDetailsService exchangeUserDetailsService;

	@Autowired
	private JWTUtil JWTUtils;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
		try{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
			UserDetails user = exchangeUserDetailsService.loadUserByUsername(request.getUsername());
			String jwt = JWTUtils.generateToken(user);
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
		}catch (BadCredentialsException e){
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

	}
}
