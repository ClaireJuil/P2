package fr.ans.psc;




import java.time.Duration;
import java.util.Base64;

import org.junit.jupiter.api.Test;

import com.celi.apia.controller.TokenExchangeFilterFunction;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Slf4j
public class Todelete {
			
		@Test
		public void monoMap() {
			log.error("test azerty");
		Mono<String> data = Mono.just("toto");
				
		System.out.print("out: " + data.block() + "\n");
		
		Flux<Integer> squared =Flux.range(1, 5).map(x-> x+10);
		//squared.subscribe(x -> System.out.print(x + ","));
		squared.subscribe(System.out::println);
		}
		
		@Test
		public void logTesting() {
			 Tuple2<Long, String> h = Mono.delay(Duration.ofMillis(3000))
	                 .log("timecccccccccccc1")
	                 .map(z -> "Spring winsXXXXXXXX")
	                 .or(Mono.delay(Duration.ofMillis(2000)).log("timeddddddd2").map(d -> "Spring Reactivesss"))
	                 .flatMap(t -> Mono.just(t+ " world"))
	                 .elapsed()
	                 .block();
	//  assertThat("Alternate mono not seen", h.getT2(), is("Spring Reactive world"));
	  System.out.println("syso" + h.getT1() +", " + h.getT2());
		}
		
		@Test
		public void monoMapaussi() {
			log.error("monoMapaussi");
		String data = Mono.just("toto").block();				
		System.out.print("out: " + data + "\n");
		
		}
		
		
		@Test
		public void parseJWT() {
			
		//référence = https://www.baeldung.com/java-jwt-token-decode
		System.out.println("test découdage token");
		String token="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjenFqa29SRkdfNktnNVlqdHVuWkRSem9BVTJreWYybkkwbzVrM3NYN0NrIn0.eyJleHAiOjE2ODkyNDMzNTMsImlhdCI6MTY4OTI0MDM1MywianRpIjoiOTAwOWZmYWQtNGIzOC00MDg5LWFlOTktYTZkNGJhMmRiODAyIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay5wb2NzLmhlbml4LmFzaXBzYW50ZS5mcjo4NDQzL3JlYWxtcy90b2tlbi1leGNoLXJlYWxtIiwiYXVkIjpbImFwaS1hIiwicHNjLXRvLWFwaSJdLCJzdWIiOiI1OWUxOWViNS1jNTFhLTQ1ODItYTlkYy0xYmUzZWQ3ZDE1ZjIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwc2MtdG8tYXBpIiwic2Vzc2lvbl9zdGF0ZSI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiLyoiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9hdXRoMi1kZW1vLXJlYWxtIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIHBhdWwtc2VydmljZSBlbWFpbCIsInNpZCI6Ijc3OWNiYWMzLTRlMmEtNDkyMS05MWNkLTBlMDE4ZjExMmVkOSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IkJlbmphbWluIEJvbmNoZSIsInByZWZlcnJlZF91c2VybmFtZSI6ImFuczIwMjEwODEwMTA0NjUyIiwiZ2l2ZW5fbmFtZSI6IkJlbmphbWluIiwiZmFtaWx5X25hbWUiOiJCb25jaGUifQ.uN2nnuB1ebbw1OXCnBPafU-06LygdyrjoQsDVP4KUVGRHE45SSaamUyiqKJ4WOz-bF87IQAicVJon5h3ZabzItzS7V2ozYNFcDgIApu2sBfWZOSnw8tcip4-UstuP6UEMI3Re9xhR3HeEmPuGCrRP3RTiPNPEvo3HiQCW39dntlqjzIxyMnFQSM5ieQTzmRxCIfNRj43Y5nLZ7YZGmBiKD2ORrNSPdSWvzKMZFtuEkjHs75DhPa85o_H8BWG7uEmszaDMDwf9F6Xr-09m-Qy2KyfU-Pz1N7qHUdjmla3cZbKEx4OifoFyrmo4FkonsRCztTUDd54QySNLtRNIEbfyQ";
		//découpage du token
		String[] chunks = token.split("\\.");
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String header = new String(decoder.decode(chunks[0]));
		String payload = new String(decoder.decode(chunks[1]));	
		System.out.print("header: " + header);
		System.out.print("payload: " + payload);
		
		//pour vérif JWT:
//		<dependency>
//	    <groupId>io.jsonwebtoken</groupId>
//	    <artifactId>jjwt</artifactId>
//	    <version>0.7.0</version>
//	</dependency>
//		SignatureAlgorithm sa = SignatureAlgorithm.HS256;
//		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), sa.getJcaName());
//		
//		
		
		}
}