package cn.lushantingyue.realmdemomvp.model.impl;

import java.util.UUID;

import cn.lushantingyue.realmdemomvp.bean.UserBean;
import cn.lushantingyue.realmdemomvp.model.IUserModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class UserModel implements IUserModel {

    /**
     *  Model层: 代理操作 本地bean/网络数据实体读写
     */
    UserBean user;
    private Realm realm;

    public UserModel() {    }

    public void init(RealmConfiguration config) {
        realm = Realm.getInstance(config);
    }

    public void init() {
        realm = Realm.getDefaultInstance();
    }

    public UserModel begin() {
        realm.beginTransaction();
        // 带主键primary key的创建方式
        user = realm.createObject(UserBean.class, UUID.randomUUID().toString() );
        return this;
    }

    @Override
    public UserModel setFirstName(String firstName) {
        // 存储firstName
        user.setmFirstName(firstName);
        return this;
    }

    @Override
    public UserModel setLastName(String lastName) {
        // 存储lastName
        user.setmLastName(lastName);
        return this;
    }

    @Override
    public UserBean load(String firstName) {
        // 查数据库或者联网获取id的userbean
        RealmResults<UserBean> realmResult = realm.where(UserBean.class).equalTo("mFirstName", firstName).findAll();
        if (realmResult.size() != 0)
            return realmResult.get(0);
        else
            return new UserBean("","","");
    }

    public void commit() {
        realm.commitTransaction();
    }

}
