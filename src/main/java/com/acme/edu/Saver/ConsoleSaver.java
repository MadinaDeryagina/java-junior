package com.acme.edu.Saver;

import com.acme.edu.Saver.Saver;

public class ConsoleSaver implements Saver {

    public void save(String message){
        System.out.print(message);
    }
}
