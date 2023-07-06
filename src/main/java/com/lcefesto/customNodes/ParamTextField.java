package com.lcefesto.customNodes;

import javafx.scene.control.TextField;

import java.util.Arrays;

public class ParamTextField extends TextField {
    private final Class<?> type;
    public Object argument;
    public boolean isArray;

    public ParamTextField(String text, Class<?> type) {
        super();
        this.setPromptText(text);
        this.type = type;
        this.setTextFormatter(MFXOpButton.getTypeFormatter(type));
        setLooks();
    }

    private void setLooks(){
        this.setMinWidth(240);
        this.setMinHeight(60);
        this.setStyle("-fx-background-color: #FFF2CF; -fx-background-radius: 15; -fx-font-size: 24");
    }

    public Object getArguments(){
        if(type.isArray()){
            if(type == double.class){
                return Arrays.stream(this.getText().split(",")).map(Double::parseDouble);
            }else if(type == int.class){
                return Arrays.stream(this.getText().split(",")).map(Integer::parseInt);
            }
        }else{
            if(type == double.class){
                return Double.parseDouble(this.getText());
            }else if(type == int.class){
                return Integer.parseInt(this.getText());
            }
        }
        return null;
    }
}
