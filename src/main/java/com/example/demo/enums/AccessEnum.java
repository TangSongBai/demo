package com.example.demo.enums;

import lombok.Data;

/**
 * @author 86187
 */


public enum AccessEnum {

    /**
     * 公开的
     */
    COMMON("common","公共的"),


    /**
     * 管理员
     */

    ADMIN("admin","管理员"),




    ;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    private String permission;


    private String description;


    AccessEnum(String permission, String description) {
        this.description=description;
        this.permission=permission;
    }
}
