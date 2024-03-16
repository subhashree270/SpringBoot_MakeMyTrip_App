package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.bindings.Passenger;
import in.ashokit.bindings.Ticket;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	@Autowired
	private MakeMyTripService service;
	
	@PostMapping("/book-ticket")
	public String bookingTicket(@ModelAttribute("p")Passenger p,Model model) {
		Ticket bookTicket = service.bookTicket(p);
		model.addAttribute("msg","Your ticket is booked , ID :"+bookTicket.getTicketNum());
		return "ticket";
	}
	
	
	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		model.addAttribute("p", new Passenger());
		return "ticket";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Ticket> allTicket = service.getAllTicket();
		model.addAttribute("tickets",allTicket);
		return "index";
		
	}

}
