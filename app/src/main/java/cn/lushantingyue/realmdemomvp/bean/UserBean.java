package cn.lushantingyue.realmdemomvp.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserBean extends RealmObject{

	@PrimaryKey
	private String uuid;
	private String mFirstName;
	private String mLastName;

	public UserBean() {
	}

	public UserBean(String uuid, String firstName, String lastName) {
		this.mFirstName = firstName;
		this.mLastName = lastName;
	}

	public UserBean setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
		return this;
	}

	public UserBean setmLastName(String mLastName) {
		this.mLastName = mLastName;
		return this;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public String getLastName() {
		return mLastName;
	}

}
