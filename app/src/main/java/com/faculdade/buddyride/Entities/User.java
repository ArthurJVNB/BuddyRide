package com.faculdade.buddyride.Entities;

import java.util.Date;

public class User {
    private String name;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private String secretQuestion;
    private String secretQuestionAnswer;

    public User(String name, String lastName, Date birthDate, String email, String password, String secretQuestion, String secretQuestionAnswer) {
        setName(name);
        setLastName(lastName);
        setBirthDate(birthDate);
        setEmail(email);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    private String getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    public void setSecretQuestionAnswer(String secretQuestionAnswer) {
        this.secretQuestionAnswer = secretQuestionAnswer;
    }

    public String getId() {
        // o email eh o proprio id, mas pra evitar confusao, existe essa forma de pegar o id
        return email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean checkSecretQuestion(String secretQuestion, String secretQuestionAnswer) {
        boolean result = false;

        if (this.secretQuestion.equals(secretQuestion) && this.secretQuestionAnswer.equals(secretQuestionAnswer)) {
            result = true;
        }

        return result;
    }
}
