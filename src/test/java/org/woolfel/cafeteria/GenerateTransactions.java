package org.woolfel.cafeteria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.woolfel.cafeteria.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple class to generate transactions that use the cafeteria menu data.
 */
public class GenerateTransactions {

    private Cafeteria cafe = null;
    private List<Store> stores = null;
    private List<CashRegister> regs = null;
    private List<Employee> emps = null;
    private List<MenuItem> items = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private int studentCount = 25000; // UMass Amherst has 28K students, default to 25K

    public GenerateTransactions(){
        mapper.registerModule(new JavaTimeModule());
    }

    public void loadData() {
        String cafefile = "samples/cafeteria.json";
        String storefile = "samples/stores.json";
        String regfile = "samples/registers.json";
        String empfile = "samples/employees.json";
        try {
            cafe = mapper.readValue(new File(cafefile), Cafeteria.class);
            regs = mapper.readValue(new File(regfile), new TypeReference<List<CashRegister>>() { });
            emps = mapper.readValue(new File(empfile), new TypeReference<List<Employee>>() { });
            stores = mapper.readValue(new File(storefile), new TypeReference<List<Store>>() { });
            for (int i=0; i < stores.size(); i++) {
                List<Menu> menus = stores.get(i).getMenus();
                for (int j=0; j < menus.size(); j++) {
                    Menu m = menus.get(j);
                    items.addAll(m.getItems());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate transactions for number of days going back from today
     */
    public void generateTransactions() {

    }

    /**
     * Only the Diner has breakfast items
     */
    public void generateBreakfast() {

    }

    public void generateLunch() {

    }

    public void generateDinner() {

    }

    public static void main(String[] args) {
        GenerateTransactions gen = new GenerateTransactions();
        gen.loadData();
        gen.generateTransactions();
    }
}
