package helloworld;


/**
 * Handler for requests to Lambda function.
 */
public class App  {
	
	public Ticket getTicket(Payment payment) {
		Ticket ticket=null;
		System.out.println(payment);
		if(payment.getPayType().equals("D")) {
			ticket = new Ticket();
			ticket.setMovieName("Avatar");
			ticket.setTicketId(12345);
		}
		
		return ticket;
		
	}

   
}
