package com.example.demo.domain;

import java.util.Date;

public class Like {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.id
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.liker
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    private String liker;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.post
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    private String post;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column like.time
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    private Date time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.id
     *
     * @return the value of like.id
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.id
     *
     * @param id the value for like.id
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.liker
     *
     * @return the value of like.liker
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public String getLiker() {
        return liker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.liker
     *
     * @param liker the value for like.liker
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public void setLiker(String liker) {
        this.liker = liker == null ? null : liker.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.post
     *
     * @return the value of like.post
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public String getPost() {
        return post;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.post
     *
     * @param post the value for like.post
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column like.time
     *
     * @return the value of like.time
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column like.time
     *
     * @param time the value for like.time
     *
     * @mbg.generated Mon Dec 17 14:11:34 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }
}