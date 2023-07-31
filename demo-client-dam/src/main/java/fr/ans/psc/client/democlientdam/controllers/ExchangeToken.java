package fr.ans.psc.client.democlientdam.controllers;

import javax.servlet.http.HttpServletRequest;

import org.javatuples.Triplet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import fr.ans.psc.client.democlientdam.tools.Helper;



@Controller
public class ExchangeToken {

	private final static String AUTHORIZATION =  "authorization";
	/*
	 * Appel Post echange de jeton par Apache
	 * Demande d'échange de token
	 */
	@GetMapping("/exchange")
	public String getApiToken(Model model, HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
		System.out.println("Ctrl POst Demande de page d'échange de token par Apache");		
		//header
		System.out.println("lecture des headers.. ");
		MultiValueMap map = Helper.logRequestHeaders(request);
		model.addAttribute("mapHeaders",map);
		//TODO recup du token d'API et affichage
		
		//todo demande et echnage de token PSC
		//String reponseExchangeToken ="{\"access_token\":\"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjenFqa29SRkdfNktnNVlqdHVuWkRSem9BVTJreWYybkkwbzVrM3NYN0NrIn0.eyJleHAiOjE2ODkyNDMzNTMsImlhdCI6MTY4OTI0MDM1MywianRpIjoiOTAwOWZmYWQtNGIzOC00MDg5LWFlOTktYTZkNGJhMmRiODAyIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay5wb2NzLmhlbml4LmFzaXBzYW50ZS5mcjo4NDQzL3JlYWxtcy90b2tlbi1leGNoLXJlYWxtIiwiYXVkIjpbImFwaS1hIiwicHNjLXRvLWFwaSJdLCJzdWIiOiI1OWUxOWViNS1jNTFhLTQ1ODItYTlkYy0xYmUzZWQ3ZDE1ZjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwc2MtdG8tYXBpIiwic2Vzc2lvbl9zdGF0ZSI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9hdXRoMi1kZW1vLXJlYWxtIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIHBhdWwtc2VydmljZSBlbWFpbCIsInNpZCI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkJlbmphbWluIEJvbmNoZSIsInByZWZlcnJlZF91c2VybmFtZSI6ImFuczIwMjEwODEwMTA0NjUyIiwiZ2l2ZW5fbmFtZSI6IkJlbmphbWluIiwiZmFtaWx5X25hbWUiOiJCb25jaGUifQ.uN2nnuB1ebbw1OXCnBPafU-06LygdyrjoQsDVP4KUVGRHE45SSaamUyiqKJ4WOz-bF87IQAicVJon5h3ZabzItzS7V2ozYNFcDgIApu2sBfWZOSnw8tcip4-UstuP6UEMI3Re9xhR3HeEmPuGCrRP3RTiPNPEvo3HiQCW39dntlqjzIxyMnFQSM5ieQTzmRxCIfNRj43Y5nLZ7YZGmBiKD2ORrNSPdSWvzKMZFtuEkjHs75DhPa85o_H8BWG7uEmszaDMDwf9F6Xr-09m-Qy2KyfU-Pz1N7qHUdjmla3cZbKEx4OifoFyrmo4FkonsRCztTUDd54QySNLtRNIEbfyQ\",\"expires_in\":3000,\"refresh_expires_in\":0,\"token_type\":\"Bearer\",\"not-before-policy\":0,\"session_state\":\"779cbac3-4e2a-4921-91cd-0e018f112ed9\",\"scope\":\"profile paul-service email\"}";
		//String extoken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjenFqa29SRkdfNktnNVlqdHVuWkRSem9BVTJreWYybkkwbzVrM3NYN0NrIn0.eyJleHAiOjE2ODkyNDMzNTMsImlhdCI6MTY4OTI0MDM1MywianRpIjoiOTAwOWZmYWQtNGIzOC00MDg5LWFlOTktYTZkNGJhMmRiODAyIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay5wb2NzLmhlbml4LmFzaXBzYW50ZS5mcjo4NDQzL3JlYWxtcy90b2tlbi1leGNoLXJlYWxtIiwiYXVkIjpbImFwaS1hIiwicHNjLXRvLWFwaSJdLCJzdWIiOiI1OWUxOWViNS1jNTFhLTQ1ODItYTlkYy0xYmUzZWQ3ZDE1ZjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwc2MtdG8tYXBpIiwic2Vzc2lvbl9zdGF0ZSI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9hdXRoMi1kZW1vLXJlYWxtIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIHBhdWwtc2VydmljZSBlbWFpbCIsInNpZCI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkJlbmphbWluIEJvbmNoZSIsInByZWZlcnJlZF91c2VybmFtZSI6ImFuczIwMjEwODEwMTA0NjUyIiwiZ2l2ZW5fbmFtZSI6IkJlbmphbWluIiwiZmFtaWx5X25hbWUiOiJCb25jaGUifQ.uN2nnuB1ebbw1OXCnBPafU-06LygdyrjoQsDVP4KUVGRHE45SSaamUyiqKJ4WOz-bF87IQAicVJon5h3ZabzItzS7V2ozYNFcDgIApu2sBfWZOSnw8tcip4-UstuP6UEMI3Re9xhR3HeEmPuGCrRP3RTiPNPEvo3HiQCW39dntlqjzIxyMnFQSM5ieQTzmRxCIfNRj43Y5nLZ7YZGmBiKD2ORrNSPdSWvzKMZFtuEkjHs75DhPa85o_H8BWG7uEmszaDMDwf9F6Xr-09m-Qy2KyfU-Pz1N7qHUdjmla3cZbKEx4OifoFyrmo4FkonsRCztTUDd54QySNLtRNIEbfyQ";
		Boolean bExisteToken = map.containsKey(AUTHORIZATION);
		if (bExisteToken) {
		String token = request.getHeader(AUTHORIZATION);
		token = token.substring("Bearer ".length());
		model.addAttribute("token",token);
		Triplet<String, String, String> tmp = Helper.splitAndDecodeToken(token);	
		model.addAttribute("tokenHeader", tmp.getValue0());
		String bodyToken = tmp.getValue1();
		model.addAttribute("tokenBody",bodyToken);
	 System.out.println("tokenbody: "+ bodyToken);
		String exp = Helper.valueOfIntFieldLocalDateTime("exp",bodyToken);
		System.out.println("exp extrait json:" + exp);
		String iat = Helper.valueOfIntFieldLocalDateTime("iat",bodyToken);
		System.out.println("iat extrait json:" + iat);
		model.addAttribute("expDate",Helper.convertTimeStampToLocalDateTime(exp));
		model.addAttribute("iatDate",Helper.convertTimeStampToLocalDateTime(iat));
		}		
		return "exchanged-token";
	}

	
}
