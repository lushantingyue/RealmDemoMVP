package cn.lushantingyue.realmdemomvp.view;

/**
 * 根据需求可知，View可以对ID、FirstName、LastName这三个EditText进行读操作，对FirstName和LastName进行写操作
 *
 * @author lushantingyue
 *
 */
public interface IUserView {
	/**
	 *  定义View层的公用视图方法，如网络加载失败/文件下载的  进度条显示
	 * @return
     */
	String getFristName();

	String getLastName();

	void setFirstName(String firstName);

	void setLastName(String lastName);
}
