package com.rikkei.ss10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/booking")
    public String showBookingForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "bookingForm";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@ModelAttribute Ticket ticket, Model model) {
        double totalAmount = bookingService.calculateTotalAmount(ticket.getSeats());
        ticket.setTotalAmount(totalAmount);

        bookingService.saveTicket(ticket);

        model.addAttribute("bookedTicket", ticket);

        return "ticketConfirmation";
    }
}
