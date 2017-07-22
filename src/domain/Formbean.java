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
		
		//�û�����Ϊ����Ϊ���ⳤ�ȵĺ���
		if(name==null){
			form.getErrors().put("name", "�û�������Ϊ��");
			isok=false;
		}else if(!name.matches("[\u4e00-\u9fa5]+")){
			form.getErrors().put("name", "�û���ֻ��Ϊ����");
			isok=false;
		}
		//����Ϊ7-12λ���ֻ���ĸ���
		if(password==null){
			form.getErrors().put("password", "���벻��Ϊ��");
			isok=false;
		}else if( !password.matches("[\\da-zA-Z]{7,12}")){
			form.getErrors().put("password", "����ֻ����7-12λ���ֻ���ĸ���");
			isok=false;
		}
		
		if(gender==null){
			form.getErrors().put("gender", "�Ա���Ϊ��");
			isok=false;
		}
		
		if(cellphone==null){
			form.getErrors().put("cellphone", "�ֻ����벻��Ϊ��");
			isok=false;
		}else if( !cellphone.matches("^1[3|4|5|8]\\d{9}$")){
			form.getErrors().put("cellphone", "�ֻ�������Ч");
			isok=false;
		}
		
		if(email==null){
			form.getErrors().put("email", "���䲻��Ϊ��");
			isok=false;
		}else if( !email.matches("[\\da-zA-Z@.]+")){
			form.getErrors().put("email", "�����ʽ����");
			isok=false;
		}
		
		if(types==null){
			form.getErrors().put("types", "�ͻ����Ͳ���Ϊ��");
			isok=false;
		}
		
		return isok;
	}
	
}
