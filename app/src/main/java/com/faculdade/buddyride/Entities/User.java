package com.faculdade.buddyride.Entities;

public class User {
    private String name;
    private String lastName;
    private String birthDate;
    private String email;
    private String password;
    private String secretQuestion;
    private String secretQuestionAnswer;
    private Status status;

    public enum Status {
        DRIVER,
        PASSENGER
    }


    public User(String name, String lastName, String birthDate, String email, String password, String secretQuestion, String secretQuestionAnswer) {
        setName(name);
        setLastName(lastName);
        setBirthDate(birthDate);
        setEmail(email);
        setPassword(password);
        setStatus(Status.PASSENGER);
        setSecretQuestion(secretQuestion);
        setSecretQuestionAnswer(secretQuestionAnswer);
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public String getPassword() {
        return password;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    public void setSecretQuestionAnswer(String secretQuestionAnswer) {
        this.secretQuestionAnswer = secretQuestionAnswer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getId() {
        // o email eh o proprio id, mas pra evitar confusao, existe essa forma de pegar o id
        return email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean checkSecretAnswer(String secretQuestion, String secretQuestionAnswer) {
        boolean result = false;

        if (this.secretQuestion.equals(secretQuestion) && this.secretQuestionAnswer.equals(secretQuestionAnswer)) {
            result = true;
        }

        return result;
    }
}
