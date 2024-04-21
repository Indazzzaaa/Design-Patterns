package TemplatMethod;

public class GenerateReportTask extends Task{
    @Override
    protected void doExecute() {
        System.out.println("->> Transferring Money Task");
    }
}
