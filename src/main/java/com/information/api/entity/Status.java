package com.information.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    Long id;
    boolean newStatus;
    boolean oldStatus;

    public Status(Long id, boolean newStatus, boolean oldStatus) {
        this.id = id;
        this.newStatus = newStatus;
        this.oldStatus = oldStatus;
    }
}
