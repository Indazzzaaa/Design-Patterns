package TemplatMethod;

public abstract class Task {
    private final AuditTrail auditTrail;

    public Task(){
        this.auditTrail = new AuditTrail();
    }

    public Task(AuditTrail auditTrail){
        this.auditTrail = auditTrail;
    }

    public void execute(){
    auditTrail.record();
        // this is what defines the template method pattern calling function which will be defined in the subclasses
    this.doExecute();
    }

    protected abstract void doExecute();

}
