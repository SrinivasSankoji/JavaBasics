package com.example.demo.behavioral.chainofresponsibility.skilledcodermedium;

public interface ApprovalProcess {
    void next(ApprovalProcess approvalProcess);

    void approveRequest(int amount);
}
