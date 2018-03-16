package cn.lushantingyue.realmdemomvp.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import cn.lushantingyue.realmdemomvp.R;
import cn.lushantingyue.realmdemomvp.presenter.UserPresenter;
import cn.lushantingyue.realmdemomvp.view.IUserView;
import io.realm.Realm;

public class MainActivity extends Activity implements OnClickListener, IUserView {

	/**
	 *  demo for mvp mode project
	 *  practice on MVP, Realm database, RecyclerView
	 *
	 *  mvp的思想: 实现 Activity/fragment 的进一步分离，
	 *  view: Activity/fragment 只负责管理视图
	 *  presenter: 代理操作model
	 *  model : 管理本地和网络数据
	 */
	UserPresenter presenter;
	EditText id,first,last;
	private Realm realm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.save).setOnClickListener(this);
		findViewById(R.id.load).setOnClickListener(this);
		id = (EditText) findViewById(R.id.id);
		first = (EditText) findViewById(R.id.first);
		last = (EditText) findViewById(R.id.last);

		// 获取默认配置下的Realm实例
		realm = Realm.getDefaultInstance();
		presenter = new UserPresenter(this, MainActivity.this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.save:
			presenter.saveUser(getFristName(), getLastName());
			break;
		case R.id.load:
			presenter.loadUser(getFristName());
			break;
		default:
			break;
		}
	}

	@Override
	public String getFristName() {
		return first.getText().toString();
	}

	@Override
	public String getLastName() {
		return last.getText().toString();
	}

	@Override
	public void setFirstName(String firstName) {
		first.setText(firstName);
	}

	@Override
	public void setLastName(String lastName) {
		last.setText(lastName);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		realm.close();
	}
}
