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
 * For demo purposes, just generate some employees that run the cash
 * registers.
 *
 */
public class GenerateEmployees {
    public static int count = 12;
    private static List<Employee> employees = new ArrayList<>();
    public static List<Employee> generateEmployees() {
        for (int i=0; i < count; i++) {
            Employee e = new Employee();
            e.setEmployeeID(UUID.randomUUID());
            e.setFirstName("first" + i);
            e.setLastName("last" + i);
            employees.add(e);
        }
        return employees;
    }
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                count = Integer.parseInt(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Employee> emps = generateEmployees();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(new File("samples/employees.json")), emps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
