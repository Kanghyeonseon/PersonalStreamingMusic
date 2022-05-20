package KHS.domain;

import KHS.dto.ListDTO;
import KHS.view.builderMember;

public class ListDAO extends DAO {
	public boolean Select(ListDTO dto) {
		try {
			builderMember.textArea.setText("");
			pstmt = conn.prepareStatement("select distinct List_Name from list_tbl where list_member_id = ?");		
			pstmt.setString(1,dto.getList_Member_Id());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				builderMember.textArea.append( rs.getString("List_Name") + "\n" );				
			}
			return true;
			
		} catch(Exception e1) { e1.printStackTrace(); 
		} finally {
			try { rs.close(); } catch(Exception e1) { e1.printStackTrace(); }
			try { pstmt.close(); } catch(Exception e2) { e2.printStackTrace(); }
		} return false;
	}
	public boolean Insert(ListDTO dto) {
		try {
			pstmt = conn.prepareStatement("insert into list_tbl values(?,?,?,?)");
			pstmt.setString(1, dto.getList_Name());
			pstmt.setString(2, dto.getList_Member_Id());
			pstmt.setString(3, dto.getList_Index());
			pstmt.setString(4, dto.getList_Music_Code());
			int result = pstmt.executeUpdate();				
			if(result!=0) { return true; }
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {pstmt.close(); }catch(Exception e) { e.printStackTrace(); }
		}	
		
		
		
		return true;
	}
}
