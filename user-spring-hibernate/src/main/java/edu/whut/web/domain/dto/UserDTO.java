package edu.whut.web.domain.dto;

public class UserDTO {
    private long id;

    private String name;

    private String password;

    private String password2;

    private String email;

    private long organizationId;

    private long[] roleIds;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public String getEmail() {
        return email;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public long[] getRoleIds() {
        return roleIds;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public void setRoleIds(long[] roleIds) {
        this.roleIds = roleIds;
    }
}
