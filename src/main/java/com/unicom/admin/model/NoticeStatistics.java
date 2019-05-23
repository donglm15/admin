package com.unicom.admin.model;

public class NoticeStatistics {
    private String noticeFirst;
    private String noticeSecond;
    private int count;

    public String getNoticeFirst() {
        return noticeFirst;
    }

    public void setNoticeFirst(String noticeFirst) {
        this.noticeFirst = noticeFirst;
    }

    public String getNoticeSecond() {
        return noticeSecond;
    }

    public void setNoticeSecond(String noticeSecond) {
        this.noticeSecond = noticeSecond;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public NoticeStatistics() {
    }

    public NoticeStatistics(String noticeFirst, String noticeSecond, int count) {
        this.noticeFirst = noticeFirst;
        this.noticeSecond = noticeSecond;
        this.count = count;
    }
}
