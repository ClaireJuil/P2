package fr.ans.psc.client.democlientdam.tools;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class HelperTest {

//	@Test
//	public void getTokenObjectFromKeycloackResponse() throws JsonMappingException, JsonProcessingException {
//
//		String jsonKeycloakResponse = "{\"access_token\":\"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjenFqa29SRkdfNktnNVlqdHVuWkRSem9BVTJreWYybkkwbzVrM3NYN0NrIn0.eyJleHAiOjE2ODkyNDMzNTMsImlhdCI6MTY4OTI0MDM1MywianRpIjoiOTAwOWZmYWQtNGIzOC00MDg5LWFlOTktYTZkNGJhMmRiODAyIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay5wb2NzLmhlbml4LmFzaXBzYW50ZS5mcjo4NDQzL3JlYWxtcy90b2tlbi1leGNoLXJlYWxtIiwiYXVkIjpbImFwaS1hIiwicHNjLXRvLWFwaSJdLCJzdWIiOiI1OWUxOWViNS1jNTFhLTQ1ODItYTlkYy0xYmUzZWQ3ZDE1ZjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwc2MtdG8tYXBpIiwic2Vzc2lvbl9zdGF0ZSI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9hdXRoMi1kZW1vLXJlYWxtIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIHBhdWwtc2VydmljZSBlbWFpbCIsInNpZCI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkJlbmphbWluIEJvbmNoZSIsInByZWZlcnJlZF91c2VybmFtZSI6ImFuczIwMjEwODEwMTA0NjUyIiwiZ2l2ZW5fbmFtZSI6IkJlbmphbWluIiwiZmFtaWx5X25hbWUiOiJCb25jaGUifQ.uN2nnuB1ebbw1OXCnBPafU-06LygdyrjoQsDVP4KUVGRHE45SSaamUyiqKJ4WOz-bF87IQAicVJon5h3ZabzItzS7V2ozYNFcDgIApu2sBfWZOSnw8tcip4-UstuP6UEMI3Re9xhR3HeEmPuGCrRP3RTiPNPEvo3HiQCW39dntlqjzIxyMnFQSM5ieQTzmRxCIfNRj43Y5nLZ7YZGmBiKD2ORrNSPdSWvzKMZFtuEkjHs75DhPa85o_H8BWG7uEmszaDMDwf9F6Xr-09m-Qy2KyfU-Pz1N7qHUdjmla3cZbKEx4OifoFyrmo4FkonsRCztTUDd54QySNLtRNIEbfyQ\",\"expires_in\":3000,\"refresh_expires_in\":0,\"token_type\":\"Bearer\",\"not-before-policy\":0,\"session_state\":\"779cbac3-4e2a-4921-91cd-0e018f112ed9\",\"scope\":\"profile paul-service email\"}";
//		Token token = Helper.extractTokenObject(jsonKeycloakResponse);
//		BodyToken body = token.getBody();
//		assertEquals(body.getIssuer(), "https://keycloak.pocs.henix.asipsante.fr:8443/realms/token-exch-realm");
//	}
	
	@Test
	public void todelete() {
		
        String sDate = "1689243353";
        Instant instant = Instant.ofEpochSecond(Long.valueOf(sDate));
		System.out.println(instant);
		
		LocalDateTime date = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Paris"));
		System.out.println(date);
	}
	

//	@Test
	public void todeleteAussi() throws JSONException {
		
//	String jsonTxt= "{\"exp\":1689243353,\"iat\":1689240353,\"jti\":\"9009ffad-4b38-4089-ae99-a6d4ba2db802\",\"iss\":\"https://keycloak.pocs.henix.asipsante.fr:8443/realms/token-exch-realm\",\"aud\":[\"api-a\",\"psc-to-api\"],\"sub\":\"59e19eb5-c51a-4582-a9dc-1be3ed7d15f2\",\"typ\":\"Bearer\",\"azp\":\"psc-to-api\",\"session_state\":\"779cbac3-4e2a-4921-91cd-0e018f112ed9\",\"acr\":\"1\",\"allowed-origins\":[\"/*\"],\"realm_access\":{\"roles\":[\"offline_access\",\"uma_authorization\",\"default-roles-oauth2-demo-realm\"]},\"resource_access\":{\"account\":{\"roles\":[\"manage-account\",\"manage-account-links\",\"view-profile\"]}},\"scope\":\"profile paul-service email\",\"sid\":\"779cbac3-4e2a-4921-91cd-0e018f112ed9\",\"email_verified\":false,\"name\":\"Benjamin Bonche\",\"preferred_username\":\"ans20210810104652\",\"given_name\":\"Benjamin\",\"family_name\":\"Bonche\"}\r\n"
//			+ "		}";
//	  JSONObject jsonObj = new JSONObject(jsonTxt);
//      String exp = jsonObj.getString("exp");
//      String iat = jsonObj.getString("iat");
//	//JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonTxt);    
//      System.out.println(exp);
//      System.out.println(iat);
	}
}
