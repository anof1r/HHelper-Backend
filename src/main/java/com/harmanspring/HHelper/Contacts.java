package com.harmanspring.HHelper;

public class Contacts {
    private String contactName;
    private String contactPosition;
    private String contactNumber;
    private String contactEmail;
    private String contactTelegram;
    private String contactImage;

    Contacts(){}

    public void setContactImage(String contactImage) {
        this.contactImage = contactImage;
    }

    public String getContactImage() {
        return contactImage;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    public void setContactTelegram(String contactTelegram) {
        this.contactTelegram = contactTelegram;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getContactPosition() {
        return contactPosition;
    }

    public String getContactTelegram() {
        return contactTelegram;
    }
}
