package test_task.models;

public class Client {
    public String name;
    public Long moneyBalance;

    public Client(String name, Long moneyBalance) {
        this.name = name;
        this.moneyBalance = moneyBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(Long moneyBalance) {
        this.moneyBalance = moneyBalance;
    }
}
