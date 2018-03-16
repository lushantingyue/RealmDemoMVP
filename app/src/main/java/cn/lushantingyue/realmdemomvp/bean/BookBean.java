//package cn.lushantingyue.realmdemomvp.bean;
//
//import io.realm.RealmObject;
//import io.realm.annotations.PrimaryKey;
//
///**
// * Created by lushantingyue on 2018/03/16.
// */
//public class BookBean extends RealmObject {
//
//    // 编号作为主键
//    @PrimaryKey
//    private int SN;
//    private String name;
//    private String author;
//    private String publisher;
//
//    public BookBean(int SN, String name, String author, String publisher) {
//        this.SN = SN;
//        this.name = name;
//        this.author = author;
//        this.publisher = publisher;
//    }
//
//    public int getSN() {
//        return SN;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public BookBean setSN(int SN) {
//        this.SN = SN;
//        return this;
//    }
//
//    public BookBean setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public BookBean setAuthor(String author) {
//        this.author = author;
//        return this;
//    }
//
//    public BookBean setPublisher(String publisher) {
//        this.publisher = publisher;
//        return this;
//    }
//
//}
