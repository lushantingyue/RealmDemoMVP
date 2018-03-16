package cn.lushantingyue.realmdemomvp.model;

import cn.lushantingyue.realmdemomvp.bean.UserBean;
import cn.lushantingyue.realmdemomvp.model.impl.UserModel;

/**
 * Model也需要对这三个字段进行读写操作，并存储在某个载体内(这不是我们所关心的，可以存在内存、文件、数据库或者远程服务器，
 * 但对于Presenter及View无影响)
 *
 * @author lushantingyue
 *
 */
public interface IUserModel {

	UserModel setFirstName(String firstName);

	UserModel setLastName(String lastName);

	UserBean load(String firstName);// 通过id读取user信息,返回一个UserBean
}
