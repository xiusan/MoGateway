package com.mogateway.entity;



/**
 * Created by xiaojinlu on 2018/7/11.
 */

public class OperatorInfo {
    private String operatorId;
    private String operatorName;
    private String operatorTel1;
    private String operatorTel2;
    private String operatorRegAddress;
    private String operatorNote;
    private String aesSecret;//第三方加密秘钥
    private String operatorSecret;//token秘钥
    private String  aesIv;//初始化向量
    private String sigSecret;//签名秘钥

    public String getAesSecret() {
        return aesSecret;
    }

    public void setAesSecret(String aesSecret) {
        this.aesSecret = aesSecret;
    }

    public String getOperatorSecret() {
        return operatorSecret;
    }

    public void setOperatorSecret(String operatorSecret) {
        this.operatorSecret = operatorSecret;
    }

    public String getAesIv() {
        return aesIv;
    }

    public void setAesIv(String aesIv) {
        this.aesIv = aesIv;
    }

    public String getSigSecret() {
        return sigSecret;
    }

    public void setSigSecret(String sigSecret) {
        this.sigSecret = sigSecret;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }


    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }


    public String getOperatorTel1() {
        return operatorTel1;
    }

    public void setOperatorTel1(String operatorTel1) {
        this.operatorTel1 = operatorTel1;
    }


    public String getOperatorTel2() {
        return operatorTel2;
    }

    public void setOperatorTel2(String operatorTel2) {
        this.operatorTel2 = operatorTel2;
    }


    public String getOperatorRegAddress() {
        return operatorRegAddress;
    }

    public void setOperatorRegAddress(String operatorRegAddress) {
        this.operatorRegAddress = operatorRegAddress;
    }


    public String getOperatorNote() {
        return operatorNote;
    }

    public void setOperatorNote(String operatorNote) {
        this.operatorNote = operatorNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperatorInfo that = (OperatorInfo) o;

        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (operatorName != null ? !operatorName.equals(that.operatorName) : that.operatorName != null) return false;
        if (operatorTel1 != null ? !operatorTel1.equals(that.operatorTel1) : that.operatorTel1 != null) return false;
        if (operatorTel2 != null ? !operatorTel2.equals(that.operatorTel2) : that.operatorTel2 != null) return false;
        if (operatorRegAddress != null ? !operatorRegAddress.equals(that.operatorRegAddress) : that.operatorRegAddress != null)
            return false;
        if (operatorNote != null ? !operatorNote.equals(that.operatorNote) : that.operatorNote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operatorId != null ? operatorId.hashCode() : 0;
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (operatorTel1 != null ? operatorTel1.hashCode() : 0);
        result = 31 * result + (operatorTel2 != null ? operatorTel2.hashCode() : 0);
        result = 31 * result + (operatorRegAddress != null ? operatorRegAddress.hashCode() : 0);
        result = 31 * result + (operatorNote != null ? operatorNote.hashCode() : 0);
        return result;
    }
}
