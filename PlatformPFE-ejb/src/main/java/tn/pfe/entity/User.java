package tn.pfe.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
//@Table(name="User")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private int phoneNumber;
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDay;
	private Boolean isEnable;
	private Boolean connected;
	private String token;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastConnect;
	
		
	public User(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Boolean getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}
	public Boolean getConnected() {
		return connected;
	}
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getLastConnect() {
		return lastConnect;
	}
	public void setLastConnect(Date lastConnect) {
		this.lastConnect = lastConnect;
	}
	public User(String lastName, String firstName, String email, String password, int phoneNumber, Date birthDay,
			Boolean isEnable, Boolean connected, String token, Date dateCreation, Date lastConnect) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDay = birthDay;
		this.isEnable = isEnable;
		this.connected = connected;
		this.token = token;
		this.dateCreation = dateCreation;
		this.lastConnect = lastConnect;
	}
	public User(String email, String password , boolean isEnable) {
		this.email = email;
		this.password = password;
		this.isEnable = isEnable;

	}
	
	
	

	
	
	
}
