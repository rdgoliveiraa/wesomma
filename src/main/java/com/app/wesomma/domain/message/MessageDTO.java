package com.app.wesomma.domain.message;


import com.app.wesomma.domain.person.User;

import java.util.Date;
import java.util.List;

public class MessageDTO implements Comparable<MessageDTO> {

    private Integer id;

    private User sender;

    private List<User> receivers;

    private String message;

    private boolean read;

    private Date shippingDate;

    private Date dateReading;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<User> receivers) {
        this.receivers = receivers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Date getDateReading() {
        return dateReading;
    }

    public void setDateReading(Date dateReading) {
        this.dateReading = dateReading;
    }

    @Override
    public int compareTo(MessageDTO messageDTO) {
        if (this.id != null && this.id > messageDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < messageDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
