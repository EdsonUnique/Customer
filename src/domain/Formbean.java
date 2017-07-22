package domain;


import java.util.HashMap;
import java.util.Map;

public class Formbean {

	private String name;
	private String password;
	private String gender;
	private String cellphone;
	private String email;
	private String birthday;
	private String types;
	private String preferences;
	private String description;
	private Map<String,String>errors=new HashMap<String,String>();
	
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean checkForm(Formbean form){
		
		boolean isok=true;
		
		//用户名不为空且为任意长度的汉字
		if(name==null){
			form.getErrors().put("name", "用户名不能为空");
			isok=false;
		}else if(!name.matches("[\u4e00-\u9fa5]+")){
			form.getErrors().put("name", "用户名只能为汉字");
			isok=false;
		}
		//密码为7-12位数字或字母组成
		if(password==null){
			form.getErrors().put("password", "密码不能为空");
			isok=false;
		}else if( !password.matches("[\\da-zA-Z]{7,12}")){
			form.getErrors().put("password", "密码只能由7-12位数字或字母组成");
			isok=false;
		}
		
		if(gender==null){
			form.getErrors().put("gender", "性别不能为空");
			isok=false;
		}
		
		if(cellphone==null){
			form.getErrors().put("cellphone", "手机号码不能为空");
			isok=false;
		}else if( !cellphone.matches("^1[3|4|5|8]\\d{9}$")){
			form.getErrors().put("cellphone", "手机号码无效");
			isok=false;
		}
		
		if(email==null){
			form.getErrors().put("email", "邮箱不能为空");
			isok=false;
		}else if( !email.matches("[\\da-zA-Z@.]+")){
			form.getErrors().put("email", "邮箱格式错误");
			isok=false;
		}
		
		if(types==null){
			form.getErrors().put("types", "客户类型不能为空");
			isok=false;
		}
		
		return isok;
	}
	
}
