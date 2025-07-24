package com.example.demo.Controllers;

import com.example.demo.DTOs.SettleUpRequestDto;
import com.example.demo.DTOs.SettleUpResponseDto;
import com.example.demo.Services.SettleUpService;


public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    public SettleUpResponseDto settleUpUser(SettleUpRequestDto requestDto){

        SettleUpResponseDto settleUpResponseDto  = settleUpService.settleUpUser(requestDto.getUserID());

        return settleUpResponseDto;
    }

    public SettleUpResponseDto settleUpGroup(SettleUpRequestDto requestDto){
        SettleUpResponseDto responseDto = settleUpService.settleUpGroup(requestDto.getGroupID());
        return responseDto;
    }
}
