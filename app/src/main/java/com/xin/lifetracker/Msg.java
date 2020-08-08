package com.xin.lifetracker;

public class Msg {
    // 消息类型  收到
    public static final int TYPE_RECEIVED = 0;
    // 消息类型 发出
    public static final int TYPE_SENT = 1;
    // 消息内容
    private String content;
    // 消息类型
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;

    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
