package com.example.androidcoursedesign.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "classifyList", schema = "android_news", catalog = "")
public class ClassifyListEntity implements Serializable {
    private int classifyId;
    private String classifyName;

    @Id
    @Column(name = "classifyId")
    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    @Basic
    @Column(name = "classifyName")
    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifyListEntity that = (ClassifyListEntity) o;
        return classifyId == that.classifyId &&
                Objects.equals(classifyName, that.classifyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classifyId, classifyName);
    }
}
