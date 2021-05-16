# solution
- note that sha256 hashes of the existing items, contain "co1a", "beef", and "cafe"
- calculate a sha256 hash containing "decaf" and "c01a"
- product ID must match format

````
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
```

```
18621173 Decaf Cola
2c7d9c65c1ba091c01aa2be99ca03aa188fbe7b4347ffb1d30f925decafee44f

57905151 Decaf Cola
dcf781efa081c48df4144cb6aa4e18c01a79b6631ce39a7abdecafd1a7641103

83763167 Decaf Cola
84a4de7d448f3b31cadb97d61cc9907c01a462dae2449bdecafceedeb487ed9d

97902805 Decaf Cola
9722f517decaf8fde16ec3ca107812da12c2e9ab84db0c01a691ecfa6341adbf
```