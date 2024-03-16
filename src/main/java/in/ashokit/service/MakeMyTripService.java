package in.ashokit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;

@Service
public class MakeMyTripService {
	
	public Ticket bookTicket(Passenger p) {
		String apiUrl="http://localhost:8080/ticket";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> forEntity = rt.postForEntity(apiUrl, p, Ticket.class);
		Ticket body = forEntity.getBody();
		return body;
	}
	
	public List<Ticket> getAllTicket(){
		String apiUrl="http://localhost:8080/tickets";
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket[]> forEntity = rt.getForEntity(apiUrl, Ticket[].class);
		Ticket[] body = forEntity.getBody();
		List<Ticket> tickets = Arrays.asList(body);
		return tickets;
	}

}
