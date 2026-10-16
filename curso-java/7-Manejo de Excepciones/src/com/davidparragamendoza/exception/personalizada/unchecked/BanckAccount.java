package com.davidparragamendoza.exception.personalizada.unchecked;

public class BanckAccount {
    private double balance;

    public BanckAccount(double balance) {
        this.balance = balance;
    }

    public void retiraMonto(double monto){
        if(monto > balance){
            throw new NegativeBalanceException("Fondo Insuficientes..");
        }
        balance -= monto;
        System.out.println("Extraccion Existosa");
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        BanckAccount account=null;
        try {
            account = new BanckAccount(500);
            System.out.println("Saldo Actual: "+ account.getBalance());
            account.retiraMonto(600);

        }catch (NegativeBalanceException e){
            System.out.println(e.getMessage());
        }


        System.out.println("Saldo Actual: "+ account.getBalance());


    }
}
