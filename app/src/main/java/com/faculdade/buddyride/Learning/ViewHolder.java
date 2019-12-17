package com.faculdade.buddyride.Learning;

import android.widget.EditText;

public class ViewHolder {
    public EditText name;
    public EditText lastname;
    public EditText dateOfBirth;
    public EditText email;
    public EditText password;
    public EditText confirmPassword;
    public EditText secretQuestion;
    public EditText secretAnswer;

    //This method help us set data from ItemListView into ViewHolder
    public void setDataIntoViewHolder(ItemsListView items){
        name.setText((CharSequence) items.getName());
        lastname.setText((CharSequence) items.getLastName());
        dateOfBirth.setText((CharSequence) items.getBirthDate());
        email.setText((CharSequence) items.getEmail());
        password.setText((CharSequence) items.getPassword());
        confirmPassword.setText((CharSequence) items.getPassword()); // VE ISSO
        secretQuestion.setText((CharSequence) items.getSecretQuestion());
        secretAnswer.setText((CharSequence) items.getSecretQuestionAnswer());

    }

}
