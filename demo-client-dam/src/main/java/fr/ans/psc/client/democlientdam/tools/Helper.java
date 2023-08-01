package fr.ans.psc.client.democlientdam.tools;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.javatuples.Triplet;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.ans.psc.client.democlientdam.model.BodyToken;
import fr.ans.psc.client.democlientdam.model.HeaderToken;
import fr.ans.psc.client.democlientdam.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

@Slf4j
public class Helper {
	// champs de la réponse tokenExchange
	public static final String EX_ACCESS_TOKEN = "access_token";
	public static final String EX_EXPIRES_IN = "expires_in";
	public static final String EX_REFRESH_EXPIRES_IN = "refresh_expires_in";
	public static final String EX_TOKEN_TYPE = "token_type";
	public static final String EX_NOT_BEFORE_POLICY = "not-before-policy";
	public static final String EX_SESSION_STATE = "session_state";
	public static final String EX_SCOPE = "scope";

	private Helper() {
	}

	public static String decodeBase64(String encoded) throws UnsupportedEncodingException {
		return new String(Base64.getDecoder().decode(encoded), "UTF-8");
	}

	public static void validateDataVersuJsonSchema(String jsonTokenExchangeResponse) {
//			return Base64.getEncoder().encodeToString(stringToEncode.getBytes("UTF-8"));

//		ObjectMapper mapper = new ObjectMapper();		
//		JsonSchema jsonSchema = //fichier local;
//		 Set<ValidationMessage> errors = jsonSchema.validate(mapper.readTree(wrapper.getBag()));
//         if (!errors.isEmpty()) {
//         	 log.error("Json-schema validation failed");
//             for (ValidationMessage validationMessage : errors) {
//             	 log.error(" -->  arguments {}, message {}", Arrays.toString(validationMessage.getArguments()), validationMessage.getMessage());
//				}
//             throw new PscSchemaException();
//         }
	}

	/*
	 * Extraction de l'accessToken de la réponse de la demande de tokenExchange
	 * 
	 */
	public static String extractExchangedToken(String jsonTokenExchangeResponse)
			throws JsonMappingException, JsonProcessingException {
		/*
		 * 
		 * { "access_token":
		 * "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjenFqa29SRkdfNktnNVlqdHVuWkRSem9BVTJreWYybkkwbzVrM3NYN0NrIn0.eyJleHAiOjE2ODkyNDMzNTMsImlhdCI6MTY4OTI0MDM1MywianRpIjoiOTAwOWZmYWQtNGIzOC00MDg5LWFlOTktYTZkNGJhMmRiODAyIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay5wb2NzLmhlbml4LmFzaXBzYW50ZS5mcjo4NDQzL3JlYWxtcy90b2tlbi1leGNoLXJlYWxtIiwiYXVkIjpbImFwaS1hIiwicHNjLXRvLWFwaSJdLCJzdWIiOiI1OWUxOWViNS1jNTFhLTQ1ODItYTlkYy0xYmUzZWQ3ZDE1ZjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwc2MtdG8tYXBpIiwic2Vzc2lvbl9zdGF0ZSI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9hdXRoMi1kZW1vLXJlYWxtIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIHBhdWwtc2VydmljZSBlbWFpbCIsInNpZCI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkJlbmphbWluIEJvbmNoZSIsInByZWZlcnJlZF91c2VybmFtZSI6ImFuczIwMjEwODEwMTA0NjUyIiwiZ2l2ZW5fbmFtZSI6IkJlbmphbWluIiwiZmFtaWx5X25hbWUiOiJCb25jaGUifQ.uN2nnuB1ebbw1OXCnBPafU-06LygdyrjoQsDVP4KUVGRHE45SSaamUyiqKJ4WOz-bF87IQAicVJon5h3ZabzItzS7V2ozYNFcDgIApu2sBfWZOSnw8tcip4-UstuP6UEMI3Re9xhR3HeEmPuGCrRP3RTiPNPEvo3HiQCW39dntlqjzIxyMnFQSM5ieQTzmRxCIfNRj43Y5nLZ7YZGmBiKD2ORrNSPdSWvzKMZFtuEkjHs75DhPa85o_H8BWG7uEmszaDMDwf9F6Xr-09m-Qy2KyfU-Pz1N7qHUdjmla3cZbKEx4OifoFyrmo4FkonsRCztTUDd54QySNLtRNIEbfyQ",
		 * "expires_in": 3000, "refresh_expires_in": 0, "token_type": "Bearer",
		 * "not-before-policy": 0, "session_state":
		 * "779cbac3-4e2a-4921-91cd-0e018f112ed9", "scope": "profile paul-service email"
		 * }
		 */
		ObjectMapper mapper = new ObjectMapper();
		JsonNode nameNode = mapper.readTree(jsonTokenExchangeResponse);
		// EchangeTokenResponse response = mapper.readValue(jsonTokenExchangeResponse,
		// EchangeTokenResponse.class);
		// return response.getAccesstoken();
		return (nameNode.get(EX_ACCESS_TOKEN).asText());
	}

	/*
	 * Décodage et découpage d'un accesToken
	 */
//	public static Triplet<String, String, String> splitAndDecodeTokenFromResponse(String jsonTokenExchangeResponse)
//			throws JsonMappingException, JsonProcessingException {
//
//		String accessTokenBase64 = extractExchangedToken(jsonTokenExchangeResponse);
//	    return splitAndDecodeToken(accessTokenBase64);
//	}

	/*
	 * Décodage et découpage d'un accesToken
	 */
	public static Triplet<String, String, String> splitAndDecodeToken(String token)
			throws JsonMappingException, JsonProcessingException {
		String[] chunks = token.split("\\.");
		String headerToken = null;
		String bodyToken = null;
		String signature = chunks[2];
		try {
			headerToken = decodeBase64(chunks[0]);
			bodyToken = decodeBase64(chunks[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Triplet<String, String, String> splitedDecodedToken = Triplet.with(headerToken, bodyToken, signature);
		return splitedDecodedToken;
	}

	
	public static Token extractTokenObjectFromDecodedSplitedToken(Triplet<String, String, String> splitedDecodedToken)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		HeaderToken headerToken = mapper.readValue(splitedDecodedToken.getValue0(), HeaderToken.class);
		BodyToken bodyToken = mapper.readValue(splitedDecodedToken.getValue1(), BodyToken.class);
		return new Token(headerToken, bodyToken, splitedDecodedToken.getValue2());
	}

//	public static Token extractTokenObject(String jsonTokenExchangeResponse)
//			throws JsonMappingException, JsonProcessingException {
//		Triplet<String, String, String> tmp = splitAndDecodeTokenFromResponse(jsonTokenExchangeResponse);
//		return extractTokenObjectFromDecodedSplitedToken(tmp);
//	}

	public static LocalDateTime convertTimeStampToLocalDateTime(String timestampInSecond) {
		Instant instant = Instant.ofEpochSecond(Long.valueOf(timestampInSecond));
		LocalDateTime date = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Paris"));
		System.out.println("Helper date:" + date);
		return date;
	}

	public static MultiValueMap<String,String> logRequestHeaders(HttpServletRequest request) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		Enumeration<String> headersName = request.getHeaderNames();
		Iterator<String> iHeaderNames = headersName.asIterator();
		while (iHeaderNames.hasNext()) {
			String tmp = iHeaderNames.next();
			String value = request.getHeader(tmp);
			map.add(tmp, value);
			System.out.println("\t" + tmp + ": " + value);
		}
		System.out.println("...fin de lecture des headers");
		return map;
	}
	
	/*
	 * EXtrait la valeur d'un champ IN d'un json
	 */
	public static String valueOfIntFieldLocalDateTime (String fieldName, String json) {
		 JSONObject jsonObj = new JSONObject(json);
	      return Integer.toString(jsonObj.getInt(fieldName));
	      }
	
  public static MultiValueMap<String, String> filtredMap (MultiValueMap<String,String> map) {
	  MultiValueMap<String, String> filteredMap = new LinkedMultiValueMap<String, String>();
	  
	  for (Entry<String, List<String>> data : map.entrySet()) {
	      if(data.getKey().startsWith("oidc_claim") 
	    		  || data.getKey().startsWith("x-") 
	    		  || data.getKey().startsWith("oidc_access")
	    		  || data.getKey().startsWith("authorization")
	    		  ){
	    	  filteredMap.put(data.getKey(), data.getValue());
	      }
	  }
	  return filteredMap;
  }
}
