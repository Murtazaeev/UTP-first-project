public class Account implements IAggregable<Account, Double>, IDeeplyCloneable<Account> {

    private Person owner;
    private Double sum;

    Account(Person owner, Double sum) {
        this.owner = owner;
        this.sum = sum;
    }

    Person getOwner() {
        return owner;
    }

    Double getSum() {
        return sum;
    }

    public Double aggregate(Double iResult) {
        return iResult == null ? sum : iResult + sum;
    }

    public Account deepClone() {
        return new Account(owner.deepClone(), sum);
    }
}