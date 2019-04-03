package ticket;

import java.util.ArrayList;

public interface ticketService {
	void addTicket(Ticket t);
	ArrayList<Ticket> getAll();
}
