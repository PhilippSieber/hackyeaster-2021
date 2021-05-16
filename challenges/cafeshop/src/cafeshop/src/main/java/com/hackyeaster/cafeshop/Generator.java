package com.hackyeaster.cafeshop;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class Generator {
	
	
/*
11865457 Vanilla Cafe
f15bffb719f26892f17eea53dc7e3459cafe021bc0db2dce72429667d7aaee96
42640575 Cherry Cola
36bc94f7d7c3398319f2c01a9a9c583aed66d3a5e325aafa0652ceb2bdc271cf
80427209 Beef Jerky
ed734b4fc622d543774121dcfb573cf53d7ddef85ebebeef9fd7cbd8bf4363c9
18621173 Decaf Cola
2c7d9c65c1ba091c01aa2be99ca03aa188fbe7b4347ffb1d30f925decafee44f
57905151 Decaf Cola
dcf781efa081c48df4144cb6aa4e18c01a79b6631ce39a7abdecafd1a7641103
83763167 Decaf Cola
84a4de7d448f3b31cadb97d61cc9907c01a462dae2449bdecafceedeb487ed9d
97902805 Decaf Cola
9722f517decaf8fde16ec3ca107812da12c2e9ab84db0c01a691ecfa6341adbf
*/
	
	public static void main(String[] args) {

		for (int i = 70000000; i < 10000000 + 90000000; i++) {
			String id = i + " Decaf Cola";
			String hash = Hashing.sha256().hashString(id, StandardCharsets.UTF_8).toString();

			if (hash.contains("decaf") && hash.contains("c01a")) {
				System.out.println(id);
				System.out.println(hash);
			}

		}

	}
}
