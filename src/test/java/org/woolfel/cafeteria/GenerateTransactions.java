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
    private List<MenuItem> items = new ArrayList<MenuItem>();
    private List<MenuItem> breakfastItems = new ArrayList<MenuItem>();
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
                    for (int x=0; x < m.getItems().size(); x++) {
                        MenuItem mi = m.getItems().get(x);
                        if (mi.getCategory().equals("breakfast")) {
                            breakfastItems.add(mi);
                        } else {
                            items.add(mi);
                        }
                    }
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
        int bkcount = (int)(studentCount * 0.13);
        List<Transaction> trxs = new ArrayList<>();
        generateBreakfast(bkcount, trxs);
        int lunchcount = (int)(studentCount * 0.65);
        generateLunch(lunchcount, trxs);
        int dinnercount = (int)(studentCount * 0.28);
        generateDinner(dinnercount, trxs);
    }

    /**
     * Only the Diner has breakfast items
     */
    public void generateBreakfast(int studentCount, List<Transaction> data) {

    }

    public void generateLunch(int studentCount, List<Transaction> data) {

    }

    public void generateDinner(int studentCount, List<Transaction> data) {

    }

    public static void main(String[] args) {
        GenerateTransactions gen = new GenerateTransactions();
        gen.loadData();
        gen.generateTransactions();
    }
}
