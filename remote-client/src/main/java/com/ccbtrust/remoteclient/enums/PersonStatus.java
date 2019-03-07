package com.ccbtrust.remoteclient.enums;

/**
 * 员工状态枚举类
 * @author nzhang
 */
public enum PersonStatus {
    /**
     * 在职
     */
    InService(0,"在职"),
    /**
     * 离职
     */
    LeaveOffice(1,"离职");

    private int state;
    private String info;

    PersonStatus(int state, String info) {
        this.state = state;
        this.info = info;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public int getState() {
        return state;
    }
    public String getInfo() {
        return info;
    }
    public static  PersonStatus stateOf(int state){
        for (PersonStatus personStatus: values()){
            if (personStatus.getState()==state){
                return personStatus;
            }
        }
        return null;
    }
}
