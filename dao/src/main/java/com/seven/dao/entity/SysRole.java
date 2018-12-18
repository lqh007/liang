package com.seven.dao.entity;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    @Id
    private Integer id;

    private String role;

    private String description;

    private String available;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(String available) {
        this.available = available;
    }
}