package com.ln.film.form;

public class AddUserForm extends ControllerForm{
		private String username;
	    private String password;
	    private Integer status;
	    private String email;
	    private String mobile;
	    private Integer role;
	    private String realname;
	    private String idCardNo;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public Integer getRole() {
			return role;
		}
		public void setRole(Integer role) {
			this.role = role;
		}
		public String getRealname() {
			return realname;
		}
		public void setRealname(String realname) {
			this.realname = realname;
		}
		public String getIdCardNo() {
			return idCardNo;
		}
		public void setIdCardNo(String idCardNo) {
			this.idCardNo = idCardNo;
		}
		@Override
		public String toString() {
			return "AddUserForm [username=" + username + ", password=" + password + ", status=" + status + ", email="
					+ email + ", mobile=" + mobile + ", role=" + role + ", realname=" + realname + ", idCardNo="
					+ idCardNo + "]";
		}
	    
}
