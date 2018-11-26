package org.web.memberDTO;

public class MemberDTO {
    private int id;
    private String userId, userPw, userEmail;

    public MemberDTO(String userId, String userPw, String userEmail) {
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
    }

    public MemberDTO(int id, String userId, String userPw, String userEmail) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // good for debugging
    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
