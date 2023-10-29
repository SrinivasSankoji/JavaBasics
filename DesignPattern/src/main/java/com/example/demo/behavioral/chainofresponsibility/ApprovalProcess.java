package com.example.demo.behavioral.chainofresponsibility;

public interface ApprovalProcess {

    void next(ApprovalProcess approvalProcess);

    void approveRequest(int amount);
}
