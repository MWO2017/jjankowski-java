package JavaOne.LabThree.Wizytówki;

import java.util.ArrayList;

public class BankAccountBusinessCard extends BusinessCard {
    private String bankAccount = "";

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccountBusinessCard(String name, String surname) {
        super(name, surname);
    }

    public BankAccountBusinessCard(String name, String surname, int phone, String city) {
        super(name, surname, phone, city);
    }

    public BankAccountBusinessCard(String name, String surname, int phone, String city, String bankAccount) {
        super(name, surname, phone, city);
        setBankAccount(bankAccount);
    }




    protected ArrayList<String> getLines() {
        ArrayList<String> lines = super.getLines();
        if (!bankAccount.equals("")) {
            lines.add("Account:" + getBankAccount());
        }
        return lines;
    }
}


