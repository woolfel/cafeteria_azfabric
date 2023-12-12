package org.woolfel.cafeteria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.woolfel.cafeteria.model.Cafeteria;
import org.woolfel.cafeteria.model.CashRegister;
import org.woolfel.cafeteria.model.Employee;

import java.io.File;
import java.util.List;

/**
 * Simple class to generate transactions that use the cafeteria menu data.
 */
public class GenerateTransactions {

    private Cafeteria cafe = null;
    private List<CashRegister> regs = null;
    private List<Employee> emps = null;
    private ObjectMapper mapper = new ObjectMapper();

    public GenerateTransactions(){
        mapper.registerModule(new JavaTimeModule());
    }

    public void loadData() {
        String cafefile = "cafedata.json";
        String regfile = "registers.json";
        String empfile = "employees.json";
        try {
            cafe = mapper.readValue(new File(cafefile), Cafeteria.class);
            regs = mapper.readValue(new File(regfile), new TypeReference<List<CashRegister>>() { });
            emps = mapper.readValue(new File(empfile), new TypeReference<List<Employee>>() { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateTransactions() {

    }

    public static void main(String[] args) {
        GenerateTransactions gen = new GenerateTransactions();
        gen.loadData();
        gen.generateTransactions();
    }
}
