package KHS.controller;

import KHS.dto.DTO;
import KHS.dto.ListDTO;
import KHS.service.ListService;

public class ListController implements SubController

{
	ListService service = new ListService(); //집합 포함관계를 봐야한다.
	@Override
	public boolean execute(int num, DTO dto) {
		ListDTO adto  = (ListDTO) dto; //다운캐스팅
		if(num==1) { 
			return service.Select(adto);
		} else if(num==2) {
			return service.Insert(adto);
		}
		return false;
	}
	
}
