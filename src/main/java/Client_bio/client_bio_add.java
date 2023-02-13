package Client_bio;

public class client_bio_add
{

	 
	 private int account_id;
	 private String client_name;
	 private String contact_name;
	 private String email;
	 private String phone;
	 private String city;
	 private String state;
	 private String country;
	 
	 
	 
	public client_bio_add(String client_name, String contact_name, String email, String phone,
			String city, String state, String country) {
		super();
		// this.account_id = account_id;
		this.client_name = client_name;
		this.contact_name = contact_name;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public client_bio_add() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "client_bio_add [account_id=" + account_id + ", client_name=" + client_name + ", contact_name="
				+ contact_name + ", email=" + email + ", phone=" + phone + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}
	
	

}
