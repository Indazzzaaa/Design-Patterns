package BehavirolPatterns.TemplatMethod;

public class TransferMoneyTask extends Task{
    @Override
    protected void doExecute() {
        System.out.println("->> Transfer Money Task");
    }
}
