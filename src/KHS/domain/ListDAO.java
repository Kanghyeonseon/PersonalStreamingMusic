package KHS.domain;

import KHS.dto.ListDTO;
import KHS.view.builderMember;
import KHS.view.builderMemberList;

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
			pstmt = conn.prepareStatement("insert into list_tbl values(?,?,?)");
			pstmt.setString(1, dto.getList_Name());
			pstmt.setString(2, dto.getList_Member_Id());
			pstmt.setString(3, dto.getList_Music_Code());
			int result = pstmt.executeUpdate();				
			if(result!=0) { return true; }
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {pstmt.close(); }catch(Exception e) { e.printStackTrace(); }
		}	
		return true;
	}
	public boolean Delete(ListDTO dto) {
		try {
			pstmt=conn.prepareStatement("delete from list_tbl where list_name=? and list_member_id=?");
			pstmt.setString(2, dto.getList_Name());
			pstmt.setString(1, dto.getList_Member_Id());
			int result = pstmt.executeUpdate();
			if(result!=0) { System.out.println("삭제 성공!"); return true;}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		return false;
	}
	public boolean SelectList(ListDTO dto) {
		try {
			builderMemberList.txtList.setText("");
			pstmt = conn.prepareStatement("select list_music_code from list_tbl where list_member_id = ?");	
			pstmt.setString(1,dto.getList_Member_Id());

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				builderMemberList.txtList.append( rs.getString("list_music_code") + "\n" );				
			}
			return true;
			
		} catch(Exception e1) { e1.printStackTrace(); 
		} finally {
			try { rs.close(); } catch(Exception e1) { e1.printStackTrace(); }
			try { pstmt.close(); } catch(Exception e2) { e2.printStackTrace(); }
		} return false;
	}
	
	
}
