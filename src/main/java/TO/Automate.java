package TO;

public class Automate {
    private int coinTotalAmount;
    private int canAmount;

    private int soldAmount;

    public int getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }

    public int getCoinTotalAmount() {
        return coinTotalAmount;
    }

    public void setCoinTotalAmount(int coinTotalAmount) {
        this.coinTotalAmount = coinTotalAmount;
    }

    public int getCanAmount() {
        return canAmount;
    }

    public void setCanAmount(int canAmount) {
        this.canAmount = canAmount;
    }

    private boolean hasCoinEntered;


    Automate(int beginningCanAmount) {
        canAmount = beginningCanAmount;
        hasCoinEntered = false;
    }

    public boolean getMoney() {
        if (hasCoinEntered) {
            return false;
        } else {
            hasCoinEntered = true;
            coinTotalAmount++;
            return true;
        }
    }

    public boolean insertCoinAmount(int coinAmount) {
        if (!hasCoinEntered) {
            coinTotalAmount = coinTotalAmount + coinAmount;
            hasCoinEntered = true;
            return true;
        } else {
            return false;
        }

    }

    public boolean discardCan() {
        if (hasCoinEntered && canAmount > 0) {
            canAmount--;
            hasCoinEntered = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean discardCanAmount(int canAmountToDiscard) {
        if (hasCoinEntered && canAmount > 0) {
            if (canAmountToDiscard <= coinTotalAmount && canAmountToDiscard <= canAmount) {
                setSoldAmount(canAmountToDiscard);
                System.out.println("Sold: " + getSoldAmount() + " cans.");
                canAmount = canAmount - canAmountToDiscard;
                coinTotalAmount = coinTotalAmount - canAmountToDiscard;
                System.out.println("Coins left: " + coinTotalAmount);
                hasCoinEntered = true;
            } else if (canAmountToDiscard < coinTotalAmount && canAmountToDiscard > canAmount) {
                System.out.println("Lack of Cans!");
                setSoldAmount(canAmount);
                System.out.println("Sold can amount: " + getSoldAmount());
                coinTotalAmount = coinTotalAmount - canAmount;
                canAmount = canAmountToDiscard - canAmount;
                hasCoinEntered = true;
                canAmount = 0;
            } else if (canAmountToDiscard > coinTotalAmount && canAmountToDiscard < canAmount) {
                System.out.println("Lack of Money!");
                setSoldAmount(coinTotalAmount);
                System.out.println("Sold can amount: " + getSoldAmount());
                coinTotalAmount = 0;
                hasCoinEntered = false;
                canAmount = canAmount - canAmountToDiscard;
            } else if (canAmountToDiscard > coinTotalAmount && canAmountToDiscard > canAmount) {
                if (coinTotalAmount > canAmount) {
                    setSoldAmount(canAmount);
                } else {
                    setSoldAmount(coinTotalAmount);
                }
                System.out.println("Sold can amount: " + getSoldAmount());
                coinTotalAmount = 0;
                canAmount = 0;
                hasCoinEntered = false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean returnMoney(int moneyAmount) {
        if (hasCoinEntered && coinTotalAmount > moneyAmount) {
            coinTotalAmount = coinTotalAmount - moneyAmount;
            return true;
        } else {
            return false;
        }
    }

}
