package com.devwook88.learn_spring_boot;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestClient extends RestTemplate {
    private RestClient() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();

        clientHttpRequestFactory.setConnectionRequestTimeout(5000);
        clientHttpRequestFactory.setReadTimeout(5000);
        new RestTemplate(clientHttpRequestFactory);
    }

    public static RestClient getInstance(){
        return new RestClient();
    }

    public static void main(String ar[]){
        RestClient restClient = RestClient.getInstance();
        restClient.getForEntity("http://www.naver.com", String.class);
        restClient.getForEntity("http://www.daum.net", String.class);
    }
}
