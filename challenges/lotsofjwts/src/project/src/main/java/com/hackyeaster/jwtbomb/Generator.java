package com.hackyeaster.jwtbomb;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

public class Generator {

	static String[] PARTS = new String[] { "he202", "1{pl3", "nty_0", "f_js0", "n_t0k", "k3nZ}" };
	static String[] NOPE = new String[] { "no{flag}" };

	public static void main(String[] args) {

		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048);
			KeyPair kp = kpg.generateKeyPair();
			Algorithm algo = Algorithm.RSA256((RSAPublicKey) kp.getPublic(), (RSAPrivateKey) kp.getPrivate());

			String[] t1 = new String[128];
			for (int i = 0; i < t1.length; i++) {
				t1[i] = generate(NOPE, algo, i);
			}
			String[] t2 = new String[64];
			for (int i = 0; i < t2.length; i++) {
				String[] payloads = new String[] { t1[i * 2], t1[i * 2 + 1] };
				t2[i] = generate(payloads, algo, -1);
			}
			String[] t3 = new String[16];
			for (int i = 0; i < t3.length; i++) {
				String[] payloads = new String[] { t2[i * 4], t2[i * 4 + 1], t2[i * 4 + 2], t2[i * 4 + 3] };
				t3[i] = generate(payloads, algo, -1);
			}
			String[] t4 = new String[4];
			for (int i = 0; i < t4.length; i++) {
				String[] payloads = new String[] { t3[i * 4], t3[i * 4 + 1], t3[i * 4 + 2], t3[i * 4 + 3] };
				t4[i] = generate(payloads, algo, -1);
			}
			String[] payloads = new String[] { t4[0], t4[1], t4[2], t4[3] };
			String master = generate(payloads, algo, -1);

			Files.write(Paths.get("jwts.txt"), master.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String generate(String[] payloads, Algorithm algorithm, int nr) {
		Builder j = JWT.create();
		j = j.withClaim("iss", "he");
		for (int i = 0; i < payloads.length; i++) {
			j = j.withClaim("ct" + (i + 1), payloads[i]);
		}
		switch (nr) {
		case 12:
			j = j.withClaim("iv", PARTS[3]);
			break;
		case 18:
			j = j.withClaim("v", PARTS[4]);
			break;
		case 20:
			j = j.withClaim("iii", PARTS[2]);
			break;
		case 33:
			j = j.withClaim("i", PARTS[0]);
			break;
		case 69:
			j = j.withClaim("ii", PARTS[1]);
			break;
		case 126:
			j = j.withClaim("vi", PARTS[5]);
			break;
		}
		return j.sign(algorithm);
	}

}
