package test.nomal;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class User {

	private String id;
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public User(String id, Date createTime) {
		super();
		this.id = id;
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", createTime=" + createTime + "]";
	}
	public User() {
	}
	public static void main(String[] args) {
		User user=new User("123", new Date());
		String c=ContentString.createJsonWithDate(user);
		System.out.println(c);
		String json= 
				"{\"createTime\":\"\",\"id\":\"123\"}";
		
		User users=(User) ContentString.createBeanWithDate(json, User.class);
		System.out.println(ContentString.createJsonWithDate(users));
		
		
	}
	
	
	 
}
