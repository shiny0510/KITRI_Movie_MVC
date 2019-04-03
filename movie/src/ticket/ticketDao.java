package ticket;

import java.util.ArrayList;

public interface ticketDao {
	void insert(Ticket t);
	ArrayList<Ticket> selectAll();
}
