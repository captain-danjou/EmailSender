package com.davidweaver.emailsender.Entities.DTO;

/**
 * Created by david.weaver on 05/02/17.
 */
public class EmailSendAck {

    private String requestId;
    private Status status;

    public static EmailSendAck createAnEmailSendAck(String requestId, EmailSendAck.Status status) {
        return new EmailSendAck(requestId, status);
    }

    private EmailSendAck(String requestId, Status status) {
        this.requestId = requestId;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public enum Status {
        OK,
        ERROR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailSendAck that = (EmailSendAck) o;

        if (!getRequestId().equals(that.getRequestId())) return false;
        return getStatus() == that.getStatus();

    }

    @Override
    public int hashCode() {
        int result = getRequestId().hashCode();
        result = 31 * result + getStatus().hashCode();
        return result;
    }
}
