package com.example.demo.behavioral.chainofresponsibility.skilledcodermedium;

public class ApprovalRequest {
    public static void main(String[] args) {
        ApprovalProcess ceo = new CEO();
        ApprovalProcess director = new Director(ceo);
        ApprovalProcess manager = new Manager(director);
        ApprovalProcess teamLead = new TeamLead(manager);
        teamLead.approveRequest(2000);
    }
}
