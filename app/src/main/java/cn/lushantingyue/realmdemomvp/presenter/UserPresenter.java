package cn.lushantingyue.realmdemomvp.presenter;

import android.content.Context;

import cn.lushantingyue.realmdemomvp.bean.UserBean;
import cn.lushantingyue.realmdemomvp.model.impl.UserModel;
import cn.lushantingyue.realmdemomvp.view.IUserView;

/**
 * Presenter就能通过接口与View及Model进行交互
 * @author lushantingyue
 *
 */
public class UserPresenter {

	/**
	 * Presenter 组合了 View层的接口和Model层的接口/操作类
	 * 作用：
	 * 1.是视图层和数据层的中间代理，负责接收 视图层的事件 向业务层分发
	 * 2.进一步解耦视图层和数据层
	 */
	private Context mContext;

	private IUserView mUserView;
	private UserModel mUserModel;

	public UserPresenter(IUserView view, Context context) {
		this.mContext = context;
		mUserView = view;
		mUserModel = new UserModel();
		mUserModel.init();
	}

	public void saveUser(String firstName, String lastName) {

		/**
		 * 2. 创建一个Realm
		 一个Realm  类比于一个SQLite数据库。
		 它有一个与之对应的文件，一旦创建将持久化保存在安卓的文件系统中。
		 要创建一个新的Realm，你可以在任意Activity中调用静态方法Realm.getInstance。
		 */
		mUserModel
				.begin()
				.setFirstName(firstName)
				.setLastName(lastName)
				.commit();
	}

	public void loadUser(String first) {
		UserBean user = mUserModel.load(first);
		mUserView.setFirstName(user.getFirstName());// 通过调用IUserView的方法来更新显示
		mUserView.setLastName(user.getLastName());
	}

}
