package com.hzlh.lhkt.data.mode;

public class ZhiYuan {

    public String name;

    public String imageurl;

    public String content;

    public String time;

    public ZhiYuan(String name, String imageurl, String content, String time) {
        this.name = name;
        this.imageurl = imageurl;
        this.content = content;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ZhiYuan{" +
                "name='" + name + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
