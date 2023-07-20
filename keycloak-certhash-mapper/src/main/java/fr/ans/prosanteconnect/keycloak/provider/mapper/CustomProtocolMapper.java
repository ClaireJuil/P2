package fr.ans.prosanteconnect.keycloak.provider.mapper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.keycloak.models.ClientSessionContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.ProtocolMapperModel;
import org.keycloak.models.UserSessionModel;
import org.keycloak.protocol.oidc.mappers.AbstractOIDCProtocolMapper;
import org.keycloak.protocol.oidc.mappers.OIDCAccessTokenMapper;
import org.keycloak.protocol.oidc.mappers.OIDCAttributeMapperHelper;
import org.keycloak.protocol.oidc.mappers.OIDCIDTokenMapper;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.representations.IDToken;

public class CustomProtocolMapper extends AbstractOIDCProtocolMapper
		implements OIDCAccessTokenMapper, OIDCIDTokenMapper {

	public static final String PROVIDER_ID = "custom-protocol-mapper";

	private static final List<ProviderConfigProperty> configProperties = new ArrayList<>();

	static {
		OIDCAttributeMapperHelper.addTokenClaimNameConfig(configProperties);
		OIDCAttributeMapperHelper.addIncludeInTokensConfig(configProperties, CustomProtocolMapper.class);
	}

	@Override
	public String getDisplayCategory() {
		return "Token Mapper";
	}

	@Override
	public String getDisplayType() {
		return "X509 thumbprint client certificate Mapper";
	}

	@Override
	public String getId() {
		return PROVIDER_ID;
	}

	@Override
	public String getHelpText() {
		return "Adds a Base64 encoded X509 thumbprint to the claim";
	}

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		return configProperties;
	}

	@Override
	protected void setClaim(IDToken token, ProtocolMapperModel mappingModel, UserSessionModel userSession,
			KeycloakSession keycloakSession, ClientSessionContext clientSessionCtx) {
		X509Certificate[] certs = keycloakSession.getContext().getHttpRequest().getClientCertificateChain();
		if (certs == null || certs.length == 0) {
			// No x509 client cert
			return;
		}
		try {
			String thumbprint = computeBase64SHA256Thumbprint(certs[0]);
			OIDCAttributeMapperHelper.mapClaim(token, mappingModel, thumbprint);
		} catch (CertificateEncodingException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String computeBase64SHA256Thumbprint(final X509Certificate cert)
			throws NoSuchAlgorithmException, CertificateEncodingException {
		byte[] derEncodedCert = cert.getEncoded();
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		return java.util.Base64.getEncoder().encodeToString(sha256.digest(derEncodedCert));
	}
}
