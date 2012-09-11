package org.tju.ebs.entity;

public class MessageTemplate extends AbstractEntity {
    private String id;

    private String code;

    private String name;

    private String subject;

    private Integer expiredHours;

    private String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getExpiredHours() {
        return expiredHours;
    }

    public void setExpiredHours(Integer expiredHours) {
        this.expiredHours = expiredHours;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}