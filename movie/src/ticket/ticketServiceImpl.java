package ticket;

import java.util.ArrayList;

public class ticketServiceImpl implements ticketService {
	private ticketDaoImpl dao;
	
	public ticketServiceImpl(ticketDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public void addTicket(Ticket t) {
		// TODO Auto-generated method stub
		dao.insert(t);
	}

	@Override
	public ArrayList<Ticket> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
