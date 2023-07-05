package com.lcefesto;

import javafx.scene.control.TextField;

public class ParamTextField extends TextField {

    public ParamTextField(String text, Class<?> type) {
        super();
        this.setPromptText(text);
        //this.setTextFormatter();
        setLooks();
    }

    private void setLooks(){

    }
}
