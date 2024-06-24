package BehavirolPatterns.CommandPattern;

import BehavirolPatterns.CommandPattern.fx.Command;

public class AddCustomerCommand implements Command {

    private final CustomerService service;

    public AddCustomerCommand(CustomerService service) {
        this.service = service;
    }


    @Override
    public void execute() {
        service.addCustomer();

    }
}
