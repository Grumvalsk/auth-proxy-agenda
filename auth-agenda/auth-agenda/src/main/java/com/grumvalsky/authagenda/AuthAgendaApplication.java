package com.grumvalsky.authagenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AuthAgendaApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(AuthAgendaApplication.class, args);
		// Genera una coppia di chiavi RSA
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048); // Dimensione della chiave
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// Ottieni la chiave pubblica e privata
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		// Stampa la chiave pubblica
		System.out.println("Chiave pubblica:");
		System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

		// Stampa la chiave privata
		System.out.println("Chiave privata:");
		System.out.println(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
	}

}
