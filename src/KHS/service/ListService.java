package KHS.service;

import KHS.domain.ListDAO;
import KHS.dto.ListDTO;

public class ListService {
	
	ListDAO dao = new ListDAO();
	
	public boolean Select(ListDTO bdto) {
		return dao.Select(bdto);
		
	}
	
	

}
