package com.hzlh.lhkt.data.mode;

public class VideoData {

    public int id;

    public String videoName;

    public String videourl;

    public String videoImgurl;

    public String userImgurl;

    public String username;

    public int looknum;

    public String time;

    public VideoData(int id, String videoName, String videourl, String videoImgurl, String userImgurl, String username, int looknum, String time) {
        this.id = id;
        this.videoName = videoName;
        this.videourl = videourl;
        this.videoImgurl = videoImgurl;
        this.userImgurl = userImgurl;
        this.username = username;
        this.looknum = looknum;
        this.time = time;
    }

    @Override
    public String toString() {
        return "VideoData{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", videourl='" + videourl + '\'' +
                ", videoImgurl='" + videoImgurl + '\'' +
                ", userImgurl='" + userImgurl + '\'' +
                ", username='" + username + '\'' +
                ", looknum=" + looknum +
                ", time='" + time + '\'' +
                '}';
    }
}
