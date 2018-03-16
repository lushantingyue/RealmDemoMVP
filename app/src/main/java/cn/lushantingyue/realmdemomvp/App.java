package cn.lushantingyue.realmdemomvp;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.regex.Pattern;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by lushantingyue on 2018/03/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build() )
                .build() );
        // 通过该方法可配置数据表命名格式, 加密密钥, 保存地址
//        RealmInspectorModulesProvider.builder(this)
//                .withFolder(getCacheDir())
//                .withEncryptionKey("encrypted.realm", key)
//                .withMetaTables()
//                .withDescendingOrder()
//                .withLimit(1000)
//                .databaseNamePattern(Pattern.compile(".+\\.realm"))
//                .build();

        // 初始化Realm
        Realm.init(this);
        // 默认配置
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder().name("userBean.realm").build());
    }
}
