package com.example.demo.behavioral.chainofresponsibility;

public class ApprovalRequest {

    public static void main(String[] args) {

        ApprovalProcess ceo=new CEO(null);
        ApprovalProcess director=new Director(ceo);
        ApprovalProcess manager=new Manager(director);
        ApprovalProcess teamLead=new TeamLead(manager);

        teamLead.approveRequest(500000);
    }
}
