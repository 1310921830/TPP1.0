package com.entity;
/**
* @author Administrator
* @date 2019��8��26��
* @version 1.0
*/
public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", tel=" + tel + ", password=" + password + ", name="
				+ name + "]";
	}
	private String id;//�û����
	private String nickname;//�ǳ�
	private String tel;//�ֻ���
	private String password;//����
	private String name;//����
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String nickname, String tel, String password, String name) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.tel = tel;
		this.password = password;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
