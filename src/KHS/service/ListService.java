package KHS.service;

import KHS.domain.ListDAO;
import KHS.dto.ListDTO;

public class ListService {
	
	ListDAO dao = new ListDAO();
	
	public boolean Select(ListDTO bdto) {
		return dao.Select(bdto);
		
	}
	public boolean Insert(ListDTO bdto) {
		return dao.Insert(bdto);
	}
	public boolean Delete(ListDTO bdto) {
		return dao.Delete(bdto);
	}
	public boolean SelectList(ListDTO bdto) {
		return dao.SelectList(bdto);
	}
	

}
