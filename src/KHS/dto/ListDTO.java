package KHS.dto;

public class ListDTO extends DTO{
	private String List_Name;
	private String List_Member_Id;
	
	public ListDTO(String list_Name, String list_Member_Id) {
		super();
		List_Name = list_Name;
		List_Member_Id = list_Member_Id;
	}
	
	public ListDTO(String list_Member_Id) {
		super();
		List_Member_Id = list_Member_Id;
		
	}

	public String getList_Name() {
		return List_Name;
	}

	public void setList_Name(String list_Name) {
		List_Name = list_Name;
	}

	public String getList_Member_Id() {
		return List_Member_Id;
	}

	public void setList_Member_Id(String list_Member_Id) {
		List_Member_Id = list_Member_Id;
	}
	
	
	

	
	
	
	
	
	
}
