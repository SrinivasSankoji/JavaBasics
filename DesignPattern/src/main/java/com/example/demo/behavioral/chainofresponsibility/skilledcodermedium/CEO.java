package com.example.demo.behavioral.chainofresponsibility.skilledcodermedium;

import com.example.demo.behavioral.chainofresponsibility.skilledcodermedium.ApprovalProcess;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CEO implements ApprovalProcess {

    @Override
    public void next(ApprovalProcess handler) {
    }

    @Override
    public void approveRequest(int amount) {
        System.out.println("CEO can approve the purchase of $" + amount);
    }
}
