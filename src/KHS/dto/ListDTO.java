package KHS.dto;

public class ListDTO extends DTO{
	
	private String List_Name;
	private String List_Member_Id;
	private String List_Index;
	private String List_Music_Code;
	public ListDTO(String list_Name, String list_Member_Id, String list_Index, String list_Music_Code) {
		super();
		List_Name = list_Name;
		List_Member_Id = list_Member_Id;
		List_Index = list_Index;
		List_Music_Code = list_Music_Code;
	}
	public ListDTO(String list_Member_Id) {
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
	public String getList_Index() {
		return List_Index;
	}
	public void setList_Index(String list_Index) {
		List_Index = list_Index;
	}
	public String getList_Music_Code() {
		return List_Music_Code;
	}
	public void setList_Music_Code(String list_Music_Code) {
		List_Music_Code = list_Music_Code;
	}
	

	
	
	
	
	
	
}
