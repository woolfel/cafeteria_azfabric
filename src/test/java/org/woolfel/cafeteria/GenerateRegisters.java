package org.woolfel.cafeteria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.woolfel.cafeteria.model.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Generate some registers for a cafeteria. Default count is 8. To generate
 * a different number, call the main method with the desired count.
 */
public class GenerateRegisters {
    public static int count = 8;
    public GenerateRegisters() {}

    public static List<CashRegister> registers = new ArrayList<>();

    public static List<CashRegister> generateRegisters() {
        for (int i=0; i < count; i++) {
            CashRegister cr = new CashRegister();
            cr.setRegisterID(UUID.randomUUID());
            cr.setBrand("Square");
            cr.setModel("Square Register Kit");
            cr.setVersion("2.0");
            registers.add(cr);
        }
        return registers;
    }

    public static void  main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                count = Integer.parseInt(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<CashRegister> regs = new ArrayList<>();
        regs = generateRegisters();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writeValue(new FileWriter(new File("samples/registers.json")), regs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
