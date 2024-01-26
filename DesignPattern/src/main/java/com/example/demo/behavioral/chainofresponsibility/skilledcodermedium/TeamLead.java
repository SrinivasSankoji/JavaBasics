package com.example.demo.behavioral.chainofresponsibility.skilledcodermedium;

import com.example.demo.behavioral.chainofresponsibility.skilledcodermedium.ApprovalProcess;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeamLead implements ApprovalProcess {
    private ApprovalProcess approvalProcess;

    @Override
    public void next(ApprovalProcess approvalProcess) {
    }

    @Override
    public void approveRequest(int amount) {
        if (amount <= 1000) {
            System.out.println("Team Lead can approve the purchase of $" + amount);
        } else if (approvalProcess != null) {
            approvalProcess.approveRequest(amount);
        }
    }
}
