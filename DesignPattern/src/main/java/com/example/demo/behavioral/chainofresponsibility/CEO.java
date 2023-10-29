package com.example.demo.behavioral.chainofresponsibility;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CEO implements ApprovalProcess {

    private ApprovalProcess approvalProcess;

    @Override
    public void next(ApprovalProcess handler) {
        this.approvalProcess = approvalProcess;
    }

    @Override
    public void approveRequest(int amount) {
        System.out.println("CEO can approve the purchase of $" + amount);
    }
}
