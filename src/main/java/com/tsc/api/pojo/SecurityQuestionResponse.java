package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityQuestionResponse {
    public SecurityQuestionResponse(){}

    public int QuestionId;
    public String Question;
    public String DataType;
    public int MinLen;
    public int MaxLen;
    public String MinLenErrMsg;
    public String MaxLenErrMsg;
    public String SplChrErrMsg;

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public int getMinLen() {
        return MinLen;
    }

    public void setMinLen(int minLen) {
        MinLen = minLen;
    }

    public int getMaxLen() {
        return MaxLen;
    }

    public void setMaxLen(int maxLen) {
        MaxLen = maxLen;
    }

    public String getMinLenErrMsg() {
        return MinLenErrMsg;
    }

    public void setMinLenErrMsg(String minLenErrMsg) {
        MinLenErrMsg = minLenErrMsg;
    }

    public String getMaxLenErrMsg() {
        return MaxLenErrMsg;
    }

    public void setMaxLenErrMsg(String maxLenErrMsg) {
        MaxLenErrMsg = maxLenErrMsg;
    }

    public String getSplChrErrMsg() {
        return SplChrErrMsg;
    }

    public void setSplChrErrMsg(String splChrErrMsg) {
        SplChrErrMsg = splChrErrMsg;
    }
}
