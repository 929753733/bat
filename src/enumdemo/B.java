package enumdemo;

/**
 * @author lvyue
 * @since 2020/12/7
 */
public enum B {
    SUCCESS("1", "投票成功！"),
    FAIL("0", "投票失败！");

    private String voteFlag;
    private String voteMessage;

    B(String voteFlag, String voteMessage) {
        this.voteFlag = voteFlag;
        this.voteMessage = voteMessage;
    }

    public String voteFlag() {
        return this.voteFlag;
    }

    public String voteMessage() {
        return this.voteMessage;
    }
}
