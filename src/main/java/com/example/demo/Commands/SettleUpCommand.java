package com.example.demo.Commands;

import com.example.demo.Controllers.SettleUpController;
import com.example.demo.DTOs.SettleUpResponseDto;

import java.util.List;

public class SettleUpCommand implements Command{

    private SettleUpController settleUpController;

    public SettleUpCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }

    @Override
    public void execute(String input) {
        List<String> tokens = List.of(input.split(" "));
        Long userId = Long.valueOf(tokens.get(0));

        SettleUpResponseDto responseDto = settleUpController.settleUpUser();
        System.out.println(responseDto);
    }

    @Override
    public boolean matches(String input) {
        //U1 SettleUp
        List<String> tokens = List.of(input.split(" "));

        return tokens.size() == 2 &&
                tokens.get(1).equalsIgnoreCase(CommandKeyword.SETTLE_UP);
        // tokens.get(1).equalsIgnoreCase("SettleUp"
    }
}
