package com.example.demo.behavioral.chainofresponsibility.skilledcodermedium;

import com.example.demo.behavioral.chainofresponsibility.skilledcodermedium.ApprovalProcess;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Director implements ApprovalProcess {

    private ApprovalProcess approvalProcess;

    @Override
    public void next(ApprovalProcess handler) {
    }

    @Override
    public void approveRequest(int amount) {
        if (amount <= 30000) {
            System.out.println("Director can approve the purchase of $" + amount);
        } else if (approvalProcess != null) {
            approvalProcess.approveRequest(amount);
        }
    }
}
