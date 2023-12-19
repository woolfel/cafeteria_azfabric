package org.woolfel.cafeteria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.woolfel.cafeteria.model.*;

import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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

    private int employeeIndex = 0;
    private int registerIndex = 0;
    private Random ran = new Random();
    private BigDecimal salesTax = new BigDecimal("0.0625");
    private LocalDateTime june5monday = null;
    private LocalDateTime june5mondayLunch = null;
    private LocalDateTime june5mondayDinner = null;
    public int days = 14;
    public GenerateTransactions(){
        mapper.registerModule(new JavaTimeModule());
        try {
            june5monday = LocalDateTime.parse("2023-05-03T07:00:00");
            june5mondayLunch = LocalDateTime.parse("2023-05-03T11:00:00");
            june5mondayDinner = LocalDateTime.parse("2023-05-03T16:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
     * Generate transactions for n days. to change from the default
     * 14 days, set it to the desired days. Logic is pretty simple
     * right now and doesn't take into account weekends.
     *
     * In reality, weekends should have no transactions since it
     * is probably closed.
     */
    public void generateTransactions() {
        List<Transaction> trxs = new ArrayList<>();
        for (int d=0; d < days; d++) {
            june5monday = june5monday.plusDays(d * 1);
            june5mondayLunch = june5mondayLunch.plusDays(d * 1);
            june5mondayDinner = june5mondayDinner.plusDays(d * 1);
            int bkcount = (int)(studentCount * 0.13);
            generateBreakfast(bkcount, trxs);
            int lunchcount = (int)(studentCount * 0.65);
            generateLunch(lunchcount, trxs);
            int dinnercount = (int)(studentCount * 0.28);
            generateDinner(dinnercount, trxs);
        }
        try {
            mapper.writeValue(new File("samples/tranx.json"), trxs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UUID getEmployeeID() {
        UUID eid = emps.get(employeeIndex).getEmployeeID();
        if (employeeIndex < (emps.size() - 1)) {
            employeeIndex++;
        } else if (employeeIndex == (emps.size() - 1)) {
            employeeIndex = 0;
        }
        return eid;
    }

    public UUID getRegisterID() {
        UUID rid = regs.get(registerIndex).getRegisterID();
        if (registerIndex < (regs.size() - 1)) {
            registerIndex++;
        } else if (registerIndex == (regs.size() - 1)) {
            registerIndex = 0;
        }
        return rid;
    }

    public void getBreakfastItems(Transaction trx) {
        int count = 1 + ran.nextInt(3);
        ArrayList<MenuItem> orderitems = new ArrayList<>(count);
        BigDecimal subtot = new BigDecimal("0.0");
        for (int i =0; i < count; i++) {
            int b = ran.nextInt(breakfastItems.size()) - 1;
            if (b < 0) {
                b = 0;
            }
            MenuItem mi = breakfastItems.get(b);
            orderitems.add(mi);
            subtot = subtot.add(mi.getPrice());
        }
        subtot = subtot.setScale(2, RoundingMode.DOWN);
        trx.setItems(orderitems);
        trx.setSubtotal(subtot);
        BigDecimal stax = subtot.multiply(salesTax);
        stax = stax.setScale(2, RoundingMode.DOWN);
        trx.setTax(stax);
        BigDecimal total = subtot.add(trx.getTax());
        total = total.setScale(2, RoundingMode.DOWN);
        trx.setTotal(total);
    }

    public void getLunchItems(Transaction trx) {
        int count = 1 + ran.nextInt(4);
        ArrayList<MenuItem> orderitems = new ArrayList<>(count);
        BigDecimal subtot = new BigDecimal("0.0");
        for (int i =0; i < count; i++) {
            int b = ran.nextInt(items.size()) - 1;
            if (b < 0) {
                b = 0;
            }
            MenuItem mi = items.get(b);
            orderitems.add(mi);
            subtot = subtot.add(mi.getPrice());
        }
        subtot = subtot.setScale(2, RoundingMode.DOWN);
        trx.setItems(orderitems);
        trx.setSubtotal(subtot);
        BigDecimal stax = subtot.multiply(salesTax);
        stax = stax.setScale(2, RoundingMode.DOWN);
        trx.setTax(stax);
        BigDecimal total = subtot.add(trx.getTax());
        total = total.setScale(2, RoundingMode.DOWN);
        trx.setTotal(total);
    }

    /**
     * Only the Diner has breakfast items
     */
    public void generateBreakfast(int studentCount, List<Transaction> data) {
        LocalDateTime paytime = june5monday.plusSeconds(ran.nextInt(60));
        for (int i=0; i < studentCount; i++) {
            Transaction trx = new Transaction();
            trx.setCafeID(cafe.getCafeteriaID());
            trx.setTransactionID(UUID.randomUUID());
            trx.setEmployID(getEmployeeID());
            trx.setRegisterID(getRegisterID());
            getBreakfastItems(trx);
            paytime = paytime.plusSeconds(ran.nextInt(35));
            if (i % 2 != 0) {
                trx.setPaymentType("mealplan");
            } else {
                trx.setPaymentType("cc");
            }
            trx.setTimestamp(paytime);
            data.add(trx);
        }
    }

    public void generateLunch(int studentCount, List<Transaction> data) {
        LocalDateTime paytime = june5mondayLunch.plusSeconds(ran.nextInt(10));
        for (int i=0; i < studentCount; i++) {
            Transaction trx = new Transaction();
            trx.setCafeID(cafe.getCafeteriaID());
            trx.setTransactionID(UUID.randomUUID());
            trx.setEmployID(getEmployeeID());
            trx.setRegisterID(getRegisterID());
            getLunchItems(trx);
            paytime = paytime.plusSeconds(ran.nextInt(15));
            if (i % 2 != 0) {
                trx.setPaymentType("mealplan");
            } else {
                trx.setPaymentType("cc");
            }
            trx.setTimestamp(paytime);
            data.add(trx);
        }
    }

    public void getDinnerItems(Transaction trx) {
        int count = 1 + ran.nextInt(3);
        ArrayList<MenuItem> orderitems = new ArrayList<>(count);
        BigDecimal subtot = new BigDecimal("0.0");
        for (int i =0; i < count; i++) {
            int b = ran.nextInt(items.size()) - 1;
            if (b < 0) {
                b = 0;
            }
            MenuItem mi = items.get(b);
            orderitems.add(mi);
            subtot = subtot.add(mi.getPrice());
        }
        subtot = subtot.setScale(2, RoundingMode.DOWN);
        trx.setItems(orderitems);
        trx.setSubtotal(subtot);
        BigDecimal stax = subtot.multiply(salesTax);
        stax = stax.setScale(2, RoundingMode.DOWN);
        trx.setTax(stax);
        BigDecimal total = subtot.add(trx.getTax());
        total = total.setScale(2, RoundingMode.DOWN);
        trx.setTotal(total);
    }

    public void generateDinner(int studentCount, List<Transaction> data) {
        LocalDateTime paytime = june5mondayDinner.plusSeconds(ran.nextInt(10));
        for (int i=0; i < studentCount; i++) {
            Transaction trx = new Transaction();
            trx.setCafeID(cafe.getCafeteriaID());
            trx.setTransactionID(UUID.randomUUID());
            trx.setEmployID(getEmployeeID());
            trx.setRegisterID(getRegisterID());
            getLunchItems(trx);
            paytime = paytime.plusSeconds(ran.nextInt(15));
            if (i % 2 != 0) {
                trx.setPaymentType("mealplan");
            } else {
                trx.setPaymentType("cc");
            }
            trx.setTimestamp(paytime);
            data.add(trx);
        }
    }

    public static void main(String[] args) {
        GenerateTransactions gen = new GenerateTransactions();
        gen.loadData();
        gen.generateTransactions();
    }
}
