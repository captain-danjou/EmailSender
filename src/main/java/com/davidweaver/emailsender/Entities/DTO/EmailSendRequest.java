package com.davidweaver.emailsender.Entities.DTO;

/**
 * Created by david.weaver on 05/02/17.
 */
public class EmailSendRequest {

    private String requestId;
    private String fromEmailAddress;
    private String toEmailAddress;
    private String subject;
    private String body;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getToEmailAddress() {
        return toEmailAddress;
    }

    public void setToEmailAddress(String toEmailAddress) {
        this.toEmailAddress = toEmailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailSendRequest that = (EmailSendRequest) o;

        if (!getRequestId().equals(that.getRequestId())) return false;
        if (getFromEmailAddress() != null ? !getFromEmailAddress().equals(that.getFromEmailAddress()) : that.getFromEmailAddress() != null)
            return false;
        if (getToEmailAddress() != null ? !getToEmailAddress().equals(that.getToEmailAddress()) : that.getToEmailAddress() != null)
            return false;
        if (getSubject() != null ? !getSubject().equals(that.getSubject()) : that.getSubject() != null) return false;
        return !(getBody() != null ? !getBody().equals(that.getBody()) : that.getBody() != null);

    }

    @Override
    public int hashCode() {
        int result = getRequestId().hashCode();
        result = 31 * result + (getFromEmailAddress() != null ? getFromEmailAddress().hashCode() : 0);
        result = 31 * result + (getToEmailAddress() != null ? getToEmailAddress().hashCode() : 0);
        result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
        result = 31 * result + (getBody() != null ? getBody().hashCode() : 0);
        return result;
    }
}
