package com.example.demo.behavioral.chainofresponsibility;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Manager implements ApprovalProcess{

    private ApprovalProcess approvalProcess;

    @Override
    public void next(ApprovalProcess handler) {
    }

    @Override
    public void approveRequest(int amount) {
        if (amount <= 2000) {
            System.out.println("Manager can approve the purchase of $" + amount);
        } else if (approvalProcess != null) {
            approvalProcess.approveRequest(amount);
        }
    }
}
