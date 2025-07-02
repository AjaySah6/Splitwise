package com.example.demo.Commands;

public interface Command {

    // match and execute

    public void execute (String input);
    public boolean matches (String input);

}
