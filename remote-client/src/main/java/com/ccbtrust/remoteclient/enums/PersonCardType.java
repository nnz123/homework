package com.ccbtrust.remoteclient.enums;


/**
 * @author nzhang
 */
public enum PersonCardType {
    /**
     *身份证
     */
    IdCard(0,"身份证"),
    /**
     *护照
     */
    Passport(1,"护照");
    private int state;
    private String stateInfo;

    PersonCardType(int state,String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    public int getState() {
        return state;
    }
    public String getStateInfo() {
        return stateInfo;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void setS(String stateInfo) {
        this.stateInfo = stateInfo;
    }
    public static  PersonCardType stateOf(int state){
        for (PersonCardType cardType: values()){
            if (cardType.getState()==state){
                return cardType;
            }
        }
        return null;
    }
}
