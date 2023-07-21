package fr.ans.prosanteconnect.keycloak.provider.mapper;

import org.junit.jupiter.api.Test;

public class X509ThumbprintProtocolMapperTest {
	
    private static final String CLAIM_START = "{\"x5t#S256\": \"";
	
	private static final String CLAIM_END = "\"}";

	@Test
	public void test() {
		StringBuilder thumbprint = new StringBuilder();
		thumbprint.append(CLAIM_START).append("12345").append(CLAIM_END);
		System.out.println(thumbprint.toString());
	}
}
