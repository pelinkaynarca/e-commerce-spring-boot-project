package java4a.odev.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public enum UserRole {
    CUSTOMER,
    ADMIN
/*
    private final short roleId;
    private UserRole(short roleId) {
        this.roleId = roleId;
    }

    public short getroleId() {
        return roleId;
    }
    */
}

