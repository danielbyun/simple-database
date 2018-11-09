package org.web.memberDTO;

public class MemberDTO {
    private String userId, userPw, userEmail;

    public MemberDTO(String userId, String userPw, String userEmail) {
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
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

    public String getDisplayName() {
        return userEmail;
    }

    public void setDisplayName(String userEmail) {
        this.userEmail = userEmail;
    }
}
