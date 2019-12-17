package com.faculdade.buddyride.Learning;

import android.widget.TextView;

public class ItemsListView {

    private TextView name;
    private TextView lastName;
    private TextView birthDate;
    private TextView email;
    private TextView password;
    private TextView confirmPassword;
    private TextView secretQuestion;
    private TextView secretQuestionAnswer;

    public ItemsListView(TextView name, TextView lastName, TextView birthDate, TextView email, TextView password, TextView confirmPassword, TextView secretQuestion, TextView secretQuestionAnswer) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.secretQuestion = secretQuestion;
        this.secretQuestionAnswer = secretQuestionAnswer;
    }

    public TextView getName() {
        return name;
    }

    public TextView getLastName() {
        return lastName;
    }

    public TextView getBirthDate() {
        return birthDate;
    }

    public TextView getEmail() {
        return email;
    }

    public TextView getPassword() {
        return password;
    }

    public TextView getSecretQuestion() {
        return secretQuestion;
    }

    public TextView getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    public TextView getConfirmPassword() {
        return confirmPassword;
    }


}
