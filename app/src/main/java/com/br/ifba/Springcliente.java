package com.br.ifba;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


public class Springcliente {
    public static void main(String[]args){
        WebClient webClient = WebClient.builder().
		baseUrl("http://localhost:8080/Usuarios/").
		defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

		String response = webClient.get().uri("/findall").retrieve().bodyToMono(String.class).block();

    }

}
