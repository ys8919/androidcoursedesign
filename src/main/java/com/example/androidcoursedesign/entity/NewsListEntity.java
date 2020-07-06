package com.example.androidcoursedesign.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "newsList", schema = "android_news", catalog = "")
public class NewsListEntity implements Serializable {
    private int newsId;
    private String newsTitle;
    private String newsInfo;
    private String newsPhoto;
    private String newsDate;
    private Integer state;

    @Id
    @Column(name = "newsId")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "newsTitle")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "newsInfo")
    public String getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(String newsInfo) {
        this.newsInfo = newsInfo;
    }

    @Basic
    @Column(name = "newsPhoto")
    public String getNewsPhoto() {
        return newsPhoto;
    }

    public void setNewsPhoto(String newsPhoto) {
        this.newsPhoto = newsPhoto;
    }

    @Basic
    @Column(name = "newsDate")
    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsListEntity that = (NewsListEntity) o;
        return newsId == that.newsId &&
                Objects.equals(newsTitle, that.newsTitle) &&
                Objects.equals(newsInfo, that.newsInfo) &&
                Objects.equals(newsPhoto, that.newsPhoto) &&
                Objects.equals(newsDate, that.newsDate) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, newsTitle, newsInfo, newsPhoto, newsDate, state);
    }
}
