package jxau.model;

/**
 * @author YaoWenHao
 * @Title: Question
 * @ProjectName EasyuiJavaCrud
 * @Description: TODO
 * @date 2018/9/27 20:04
 */
public class Question {
    private int id;
    private char questionType;
    private String questionContent;
    private String questionAnswer;
    private char questionDifficult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getQuestionType() {
        return questionType;
    }

    public void setQuestionType(char questionType) {
        this.questionType = questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public char getQuestionDifficult() {
        return questionDifficult;
    }

    public void setQuestionDifficult(char questionDifficult) {
        this.questionDifficult = questionDifficult;
    }
}
