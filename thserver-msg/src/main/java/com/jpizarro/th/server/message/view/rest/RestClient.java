package com.jpizarro.th.server.message.view.rest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jpizarro.th.lib.message.entity.MessageTO;

@Service
public class RestClient {
	private RestTemplate restTemplate;
	private Credentials credentials;
	
	private static final String mGet = "http://localhost:8070/thserver-message/app/messages/{id}";
	private static final String mPost = "https://twitter.com/statuses/update.xml";

    public RestClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestClient(RestTemplate restTemplate, Credentials credentials) {
		super();
		this.restTemplate = restTemplate;
		this.credentials = credentials;
	}

	public MessageTO getEntity(Long id) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("id", String.valueOf(id));
        return restTemplate.getForObject(mGet, MessageTO.class, vars);
    }
	
}
