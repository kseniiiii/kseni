package com.company.commands;
import com.company.Insurance;
import java.io.IOException;

public class Certificate extends Command {
    @Override
    public void execute() throws IOException {
        System.out.println("*  Дериватив - це договір стандартної форми, що засвідчує право та/або зобов'язання\n" +
                "придбати або продати базовий актив на визначених у цьому договорі умовах у майбутньому\n" +
                "для зменшення ризику.");
    }
    public Certificate(Insurance insurance)
    {
        this.insurance = insurance;
    }
}
