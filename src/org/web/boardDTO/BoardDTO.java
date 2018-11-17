package org.web.boardDTO;

import java.sql.Timestamp;

public class BoardDTO {
    private int mId, mGroup, step, hit, indent;
    private String userName, title, content;
    private Timestamp date;

    public BoardDTO(int mId, int mGroup, int step, int hit, int indent, String userName, String title, String content, Timestamp date) {
        this.mId = mId;
        this.mGroup = mGroup;
        this.step = step;
        this.hit = hit;
        this.indent = indent;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmGroup() {
        return mGroup;
    }

    public void setmGroup(int mGroup) {
        this.mGroup = mGroup;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
