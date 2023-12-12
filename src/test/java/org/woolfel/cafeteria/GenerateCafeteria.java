package org.woolfel.cafeteria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.woolfel.cafeteria.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

public class GenerateCafeteria {
    public static void main(String[] args) {
        LocalTime sevenAM = LocalTime.of(7, 0);
        LocalTime nineAM = LocalTime.of(9, 0);
        LocalTime elevenAM = LocalTime.of(11,0);
        LocalTime twoPM = LocalTime.of(14,0);
        LocalTime fourPM = LocalTime.of(16,0);
        LocalTime eightPM = LocalTime.of(20,0);

        OperatingHours breakfast = new OperatingHours();
        breakfast.setName("breakfast");
        breakfast.setOpen(sevenAM);
        breakfast.setClose(nineAM);

        OperatingHours lunch = new OperatingHours();
        lunch.setName("lunch");
        lunch.setOpen(elevenAM);
        lunch.setClose(twoPM);

        OperatingHours dinner = new OperatingHours();
        dinner.setName("dinner");
        dinner.setOpen(fourPM);
        dinner.setClose(eightPM);

        OperatingHours lunchdinner = new OperatingHours();
        lunchdinner.setName("lunch and dinner");
        lunchdinner.setOpen(elevenAM);
        lunchdinner.setClose(eightPM);

        Cafeteria cafe = new Cafeteria();
        cafe.setCafeteriaID(UUID.randomUUID());
        cafe.setName("University Commons");
        cafe.setLocationName("UMASS Amherst Campus");
        cafe.getHours().add(breakfast);
        cafe.getHours().add(lunchdinner);

        Store italian = createItalian();
        Store thai = createThai();
        Store vietnam = createVietnamese();
        Store diner = createDiner();

        // set the hours for each store
        italian.getHours().add(lunch);
        italian.getHours().add(dinner);
        thai.getHours().add(lunch);
        thai.getHours().add(dinner);
        vietnam.getHours().add(lunch);
        vietnam.getHours().add(dinner);
        diner.getHours().add(breakfast);
        diner.getHours().add(lunch);
        diner.getHours().add(dinner);

        cafe.getCafeStores().add(italian);
        cafe.getCafeStores().add(thai);
        cafe.getCafeStores().add(vietnam);
        cafe.getCafeStores().add(diner);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writeValue(new FileWriter(new File("samples/cafedata.json")), cafe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Store createItalian() {
        Store italian = new Store();
        italian.setStoreID(UUID.randomUUID());
        italian.setStoreName("little italy");
        italian.setStoreDescription("Collection of american italian dishes everyone loves");
        italian.setTags(new String[]{"Italy","Italian","pasta"});

        Menu m = new Menu();
        m.setMenuID(UUID.randomUUID());
        m.setMenuType("dine-in");
        italian.getMenus().add(m);

        MenuItem i1 = new MenuItem();
        i1.setItemID(UUID.randomUUID());
        i1.setName("Fried Mozzarella");
        i1.setPrice(new BigDecimal("7.97"));
        i1.setGlutenfree(false);
        i1.setNutfree(true);
        i1.setVegan(false);
        i1.setVegetarian(true);
        i1.setItemNumber(1);
        i1.setCategory("appetizer");
        i1.setShortDescription("breaded deep fried mozzarella with marinara sauce");
        m.getItems().add(i1);

        MenuItem i2 = new MenuItem();
        i2.setItemID(UUID.randomUUID());
        i2.setName("Bread Sticks");
        i2.setPrice(new BigDecimal("5.49"));
        i2.setGlutenfree(false);
        i2.setNutfree(true);
        i2.setVegan(true);
        i2.setVegetarian(true);
        i2.setItemNumber(2);
        i2.setCategory("appetizer");
        i2.setShortDescription("bread sticks with marinara sauce");
        m.getItems().add(i2);

        MenuItem i3 = new MenuItem();
        i3.setItemID(UUID.randomUUID());
        i3.setName("Calamari");
        i3.setPrice(new BigDecimal("12.99"));
        i3.setGlutenfree(false);
        i3.setNutfree(true);
        i3.setVegetarian(false);
        i3.setVegan(false);
        i3.setShortDescription("deep fried calamari lightly breaded  with marinara and spicy ranch sauce");
        i3.setCategory("appetizer");
        i3.setItemNumber(3);
        m.getItems().add(i3);

        MenuItem i4 = new MenuItem();
        i4.setItemID(UUID.randomUUID());
        i4.setName("Spinach-Artichoke Dip");
        i4.setPrice(new BigDecimal("11.79"));
        i4.setGlutenfree(false);
        i4.setNutfree(true);
        i4.setVegetarian(true);
        i4.setVegan(false);
        i4.setShortDescription("A blend of spinach, artichokes and cheeses served warm with flatbread crisps");
        i4.setCategory("appetizer");
        i4.setItemNumber(4);
        m.getItems().add(i4);

        MenuItem i5 = new MenuItem();
        i5.setItemID(UUID.randomUUID());
        i5.setName("Chicken Alfredo");
        i5.setPrice(new BigDecimal("13.99"));
        i5.setGlutenfree(true);
        i5.setNutfree(true);
        i5.setVegetarian(false);
        i5.setVegan(false);
        i5.setShortDescription("Creamy alfredo sauce made from scratch with ingredients like parmesan, cream, garlic and butter, served with fettuccine pasta and topped with sliced grilled chicken");
        i5.setCategory("entree");
        i5.setItemNumber(10);
        m.getItems().add(i5);

        MenuItem i6 = new MenuItem();
        i6.setItemID(UUID.randomUUID());
        i6.setName("Chicken and Shrimp Carbonara");
        i6.setPrice(new BigDecimal("20.69"));
        i6.setGlutenfree(false);
        i6.setNutfree(true);
        i6.setVegetarian(false);
        i6.setVegan(false);
        i6.setShortDescription("Sautéed seasoned chicken, shrimp and spaghetti tossed in a creamy sauce with bacon and roasted red peppers");
        i6.setCategory("entree");
        i6.setItemNumber(11);
        m.getItems().add(i6);

        MenuItem i7 = new MenuItem();
        i7.setItemID(UUID.randomUUID());
        i7.setName("Spaghetti with Marinara");
        i7.setPrice(new BigDecimal("10.99"));
        i7.setGlutenfree(false);
        i7.setNutfree(true);
        i7.setVegetarian(true);
        i7.setVegan(true);
        i7.setShortDescription("Our homemade marinara served over spaghetti");
        i7.setCategory("entree");
        i7.setItemNumber(12);
        m.getItems().add(i7);

        MenuItem i8 = new MenuItem();
        i8.setItemID(UUID.randomUUID());
        i8.setName("Cheese Ravioli");
        i8.setPrice(new BigDecimal("16.89"));
        i8.setGlutenfree(false);
        i8.setNutfree(true);
        i8.setVegetarian(false);
        i8.setVegan(false);
        i8.setShortDescription("Filled with a blend of Italian cheeses, topped with your choice of homemade marinara or meat sauce and melted mozzarella");
        i8.setCategory("entree");
        i8.setItemNumber(13);
        m.getItems().add(i8);

        MenuItem i9 = new MenuItem();
        i9.setItemID(UUID.randomUUID());
        i9.setName("Eggplant Parmigiana");
        i9.setPrice(new BigDecimal("17.86"));
        i9.setGlutenfree(false);
        i9.setNutfree(true);
        i9.setVegetarian(false);
        i9.setVegan(false);
        i9.setShortDescription("Eggplant lightly fried and topped with marinara and melted mozzarella. Served with spaghetti");
        i9.setCategory("entree");
        i9.setItemNumber(14);
        m.getItems().add(i9);

        MenuItem i10 = new MenuItem();
        i10.setItemID(UUID.randomUUID());
        i10.setName("Fettuccine Alfredo");
        i10.setPrice(new BigDecimal("12.99"));
        i10.setGlutenfree(false);
        i10.setNutfree(true);
        i10.setVegetarian(false);
        i10.setVegan(false);
        i10.setShortDescription("Aged parmesan, cream, garlic and butter, served over fettuccine");
        i10.setCategory("entree");
        i10.setItemNumber(15);
        m.getItems().add(i10);

        MenuItem i11 = new MenuItem();
        i11.setItemID(UUID.randomUUID());
        i11.setName("Four Cheese Ziti");
        i11.setPrice(new BigDecimal("18.98"));
        i11.setGlutenfree(false);
        i11.setNutfree(true);
        i11.setVegetarian(false);
        i11.setVegan(false);
        i11.setShortDescription("A baked blend of Italian cheeses, pasta and our four cheese marinara");
        i11.setCategory("entree");
        i11.setItemNumber(16);
        m.getItems().add(i11);

        MenuItem i12 = new MenuItem();
        i12.setItemID(UUID.randomUUID());
        i12.setName("Tiramisu");
        i12.setPrice(new BigDecimal("8.98"));
        i12.setGlutenfree(false);
        i12.setNutfree(true);
        i12.setVegetarian(false);
        i12.setVegan(false);
        i12.setShortDescription("A layer of creamy custard set atop espresso-soaked ladyfingers");
        i12.setCategory("dessert");
        i12.setItemNumber(17);
        m.getItems().add(i12);

        MenuItem i13 = new MenuItem();
        i13.setItemID(UUID.randomUUID());
        i13.setName("Sicilian Cheesecake");
        i13.setPrice(new BigDecimal("18.98"));
        i13.setGlutenfree(false);
        i13.setNutfree(true);
        i13.setVegetarian(false);
        i13.setVegan(false);
        i13.setShortDescription("Ricotta cheesecake with a shortbread cookie crust");
        i13.setCategory("entree");
        i13.setItemNumber(18);
        m.getItems().add(i13);

        return italian;
    }

    public static  Store createThai() {
        Store thai = new Store();
        thai.setStoreID(UUID.randomUUID());
        thai.setStoreName("Siam Streets");
        thai.setStoreDescription("popular street food of thailand");
        thai.setTags(new String[]{"Thailand","spicy","south asian"});

        Menu m = new Menu();
        m.setMenuID(UUID.randomUUID());
        m.setMenuType("dine-in");
        thai.getMenus().add(m);

        MenuItem i1 = new MenuItem();
        i1.setItemID(UUID.randomUUID());
        i1.setName("Chicken Satay");
        i1.setVegan(false);
        i1.setVegetarian(false);
        i1.setNutfree(false);
        i1.setGlutenfree(false);
        i1.setPrice(new BigDecimal("9.50"));
        i1.setCategory("appetizer");
        i1.setShortDescription("Chicken tenders on skewers, marinated with Thai spices; served with peanut sauce and cucumber sauce");
        i1.setLongDescription("");
        i1.setItemNumber(1);
        m.getItems().add(i1);

        MenuItem i2 = new MenuItem();
        i2.setItemID(UUID.randomUUID());
        i2.setName("Shrimp Satay");
        i2.setVegan(false);
        i2.setVegetarian(false);
        i2.setNutfree(false);
        i2.setGlutenfree(false);
        i2.setPrice(new BigDecimal("9.50"));
        i2.setCategory("appetizer");
        i2.setShortDescription("Charcoal-grilled shrimp marinated with Thai spices; served with peanut sauce and cucumber sauce");
        i2.setLongDescription("");
        i2.setItemNumber(2);
        m.getItems().add(i2);

        MenuItem i3 = new MenuItem();
        i3.setItemID(UUID.randomUUID());
        i3.setName("Tung Tong");
        i3.setVegan(false);
        i3.setVegetarian(false);
        i3.setNutfree(false);
        i3.setGlutenfree(false);
        i3.setPrice(new BigDecimal("9.89"));
        i3.setCategory("appetizer");
        i3.setShortDescription("Four crispy pastry bags filled with chicken, corn, and water chestnuts served with sweet and sour sauce");
        i3.setLongDescription("");
        i3.setItemNumber(3);
        m.getItems().add(i3);

        MenuItem i4 = new MenuItem();
        i4.setItemID(UUID.randomUUID());
        i4.setName("Fried Tofu");
        i4.setVegan(false);
        i4.setVegetarian(false);
        i4.setNutfree(false);
        i4.setGlutenfree(false);
        i4.setPrice(new BigDecimal("8.95"));
        i4.setCategory("appetizer");
        i4.setShortDescription("Deep-fried tofu until golden brown served with sweet and sour sauce and ground peanuts");
        i4.setLongDescription("");
        i4.setItemNumber(4);
        m.getItems().add(i4);

        MenuItem i5 = new MenuItem();
        i5.setItemID(UUID.randomUUID());
        i5.setName("Coconut Shrimp");
        i5.setVegan(false);
        i5.setVegetarian(false);
        i5.setNutfree(false);
        i5.setGlutenfree(false);
        i5.setPrice(new BigDecimal("9.28"));
        i5.setCategory("appetizer");
        i5.setShortDescription("Shrimp in coconut baer, deep-fried until golden");
        i5.setLongDescription("");
        i5.setItemNumber(5);
        m.getItems().add(i5);

        MenuItem i6 = new MenuItem();
        i6.setItemID(UUID.randomUUID());
        i6.setName("Tom Yum");
        i6.setCategory("soup");
        i6.setVegan(false);
        i6.setVegetarian(false);
        i6.setNutfree(false);
        i6.setGlutenfree(false);
        i6.setPrice(new BigDecimal("7.59"));
        i6.setShortDescription("Thai hot and sour soup with a choice of chicken, lemongrass, mushrooms, tomatoes, and lemon juice topped with cilantro and scallions");
        i6.setLongDescription("");
        i6.setItemNumber(6);
        m.getItems().add(i6);

        MenuItem i7 = new MenuItem();
        i7.setItemID(UUID.randomUUID());
        i7.setName("Tom Kha");
        i7.setCategory("soup");
        i7.setVegan(false);
        i7.setVegetarian(false);
        i7.setNutfree(false);
        i7.setGlutenfree(false);
        i7.setPrice(new BigDecimal("8.59"));
        i7.setShortDescription("Coconut milk soup mixed galangal with tofu, Thai herbs, lime juice, mushrooms, tomatoes, cilantro, and scallions");
        i7.setLongDescription("");
        i7.setItemNumber(7);
        m.getItems().add(i7);

        MenuItem i8 = new MenuItem();
        i8.setItemID(UUID.randomUUID());
        i8.setName("Pork Basil and chili");
        i8.setCategory("entree");
        i8.setVegan(false);
        i8.setVegetarian(false);
        i8.setNutfree(false);
        i8.setGlutenfree(false);
        i8.setPrice(new BigDecimal("14.95"));
        i8.setShortDescription("Pork sauteed with red and green bell peppers, onions, carrots, broccoli, green beans, mushrooms, scallions & basil leaves.");
        i8.setLongDescription("");
        i8.setItemNumber(8);
        m.getItems().add(i8);

        MenuItem i9 = new MenuItem();
        i9.setItemID(UUID.randomUUID());
        i9.setName("Ginger Beef");
        i9.setCategory("entree");
        i9.setVegan(false);
        i9.setVegetarian(false);
        i9.setNutfree(false);
        i9.setGlutenfree(false);
        i9.setPrice(new BigDecimal("15.95"));
        i9.setShortDescription("Beef sauteed with fresh ginger, red and green bell peppers, onions, carrots, snow peas, mushrooms, baby corn, and scallions");
        i9.setLongDescription("");
        i9.setItemNumber(9);
        m.getItems().add(i9);

        MenuItem i10 = new MenuItem();
        i10.setItemID(UUID.randomUUID());
        i10.setName("Rama Garden");
        i10.setCategory("entree");
        i10.setVegan(false);
        i10.setVegetarian(false);
        i10.setNutfree(false);
        i10.setGlutenfree(false);
        i10.setPrice(new BigDecimal("14.99"));
        i10.setShortDescription("Chicken with red and green bell peppers, carrots, snow peas, baby corn, broccoli, mushrooms, and zucchini served on the side with peanut sauce");
        i10.setLongDescription("");
        i10.setItemNumber(10);
        m.getItems().add(i10);

        MenuItem i11 = new MenuItem();
        i11.setItemID(UUID.randomUUID());
        i11.setName("Mixed Veggies");
        i11.setCategory("entree");
        i11.setVegan(false);
        i11.setVegetarian(false);
        i11.setNutfree(false);
        i11.setGlutenfree(false);
        i11.setPrice(new BigDecimal("8.95"));
        i11.setShortDescription("Fresh garden vegetables in light brown sauce");
        i11.setLongDescription("");
        i11.setItemNumber(11);
        m.getItems().add(i11);

        MenuItem i12 = new MenuItem();
        i12.setItemID(UUID.randomUUID());
        i12.setName("Pad Prik King Chicken");
        i12.setCategory("entree");
        i12.setVegan(false);
        i12.setVegetarian(false);
        i12.setNutfree(false);
        i12.setGlutenfree(false);
        i12.setPrice(new BigDecimal("17.85"));
        i12.setShortDescription("Crispy chicken with red and green bell peppers, and string beans in prik king sauce");
        i12.setLongDescription("");
        i12.setItemNumber(12);
        m.getItems().add(i12);

        MenuItem i13 = new MenuItem();
        i13.setItemID(UUID.randomUUID());
        i13.setName("Spicy Eggplant");
        i13.setCategory("entree");
        i13.setVegan(false);
        i13.setVegetarian(false);
        i13.setNutfree(false);
        i13.setGlutenfree(false);
        i13.setPrice(new BigDecimal("14.95"));
        i13.setShortDescription("Chicken is sauteed with eggplant, red and green bell peppers, string beans, carrots and basil in spicy basil sauce");
        i13.setLongDescription("");
        i13.setItemNumber(13);
        m.getItems().add(i13);

        return thai;
    }

    public static Store createVietnamese() {
        Store vietnam = new Store();
        vietnam.setStoreID(UUID.randomUUID());
        vietnam.setStoreName("Hanoi Heaven");
        vietnam.setStoreDescription("the flavors of north vietnam");
        vietnam.setTags(new String[]{"Vietnam","Vietnamese","south asian"});

        Menu m = new Menu();
        m.setMenuID(UUID.randomUUID());
        m.setMenuType("dine-in");
        vietnam.getMenus().add(m);

        MenuItem i1 = new MenuItem();
        i1.setItemID(UUID.randomUUID());
        i1.setName("Wonton Soup");
        i1.setGlutenfree(false);
        i1.setNutfree(true);
        i1.setVegan(false);
        i1.setVegetarian(false);
        i1.setPrice(new BigDecimal("9.95"));
        i1.setShortDescription("pork wonton in a clear broth");
        i1.setLongDescription("pork wonton in a clear broth with cilantro and carrots");
        i1.setCategory("appetizer");
        i1.setItemNumber(1);
        m.getItems().add(i1);

        MenuItem i2 = new MenuItem();
        i2.setItemID(UUID.randomUUID());
        i2.setName("Crispy spring rolls");
        i2.setPrice(new BigDecimal("6.95"));
        i2.setGlutenfree(true);
        i2.setVegan(false);
        i2.setVegetarian(false);
        i2.setNutfree(true);
        i2.setShortDescription("deep fried spring rolls with pork");
        i2.setLongDescription("deep fried spring rolls with pork, mint, carrots and rice noodle");
        i2.setCategory("appetizer");
        i2.setItemNumber(2);
        m.getItems().add(i2);

        MenuItem i5 = new MenuItem();
        i5.setItemID(UUID.randomUUID());
        i5.setName("Roast Quail");
        i5.setPrice(new BigDecimal("18.95"));
        i5.setGlutenfree(true);
        i5.setVegan(false);
        i5.setVegetarian(false);
        i5.setNutfree(false);
        i5.setShortDescription("2 Roast Quail serves 4 people");
        i5.setLongDescription("");
        i5.setCategory("appetizer");
        i5.setItemNumber(3);
        m.getItems().add(i5);

        MenuItem i6 = new MenuItem();
        i6.setItemID(UUID.randomUUID());
        i6.setName("Summer Rolls");
        i6.setPrice(new BigDecimal("9.95"));
        i6.setGlutenfree(true);
        i6.setVegan(false);
        i6.setVegetarian(false);
        i6.setNutfree(false);
        i6.setShortDescription("This traditional Vietnamese Spring Roll with fresh veggies, herbs, soft slices of pork and shrimp served with a super hoisin and peanut dipping sauce");
        i6.setLongDescription("");
        i6.setCategory("appetizer");
        i6.setItemNumber(4);
        m.getItems().add(i6);

        MenuItem i7 = new MenuItem();
        i7.setItemID(UUID.randomUUID());
        i7.setName("Vietnamese Crepe");
        i7.setPrice(new BigDecimal("9.95"));
        i7.setGlutenfree(true);
        i7.setVegan(false);
        i7.setVegetarian(false);
        i7.setNutfree(true);
        i7.setShortDescription("A mixture of shrimp, pork, and bean sprouts folded into a rice powder pancake");
        i7.setLongDescription("");
        i7.setCategory("appetizer");
        i7.setItemNumber(5);
        m.getItems().add(i7);

        MenuItem i11 = new MenuItem();
        i11.setItemID(UUID.randomUUID());
        i11.setName("Chicken Salad");
        i11.setPrice(new BigDecimal("9.95"));
        i11.setGlutenfree(true);
        i11.setVegan(false);
        i11.setVegetarian(false);
        i11.setNutfree(true);
        i11.setShortDescription("Cabbage salad with carrots and shreded chicken");
        i11.setLongDescription("");
        i11.setCategory("salad");
        i11.setItemNumber(6);
        m.getItems().add(i11);

        MenuItem i12 = new MenuItem();
        i12.setItemID(UUID.randomUUID());
        i12.setName("Shrimp Salad");
        i12.setPrice(new BigDecimal("9.95"));
        i12.setGlutenfree(true);
        i12.setVegan(false);
        i12.setVegetarian(false);
        i12.setNutfree(true);
        i12.setShortDescription("Cabbage salad with carrots and shrimp");
        i12.setLongDescription("");
        i12.setCategory("salad");
        i12.setItemNumber(7);
        m.getItems().add(i12);

        MenuItem i13 = new MenuItem();
        i13.setItemID(UUID.randomUUID());
        i13.setName("Green Papaya Salad");
        i13.setPrice(new BigDecimal("14.95"));
        i13.setGlutenfree(true);
        i13.setVegan(false);
        i13.setVegetarian(false);
        i13.setNutfree(false);
        i13.setShortDescription("Green papaya, thai basil and tomato with a lime peanut fish sauce dressing");
        i13.setLongDescription("");
        i13.setCategory("appetizer");
        i13.setItemNumber(8);
        m.getItems().add(i13);

        MenuItem i14 = new MenuItem();
        i14.setItemID(UUID.randomUUID());
        i14.setName("Rice noodle salad");
        i14.setPrice(new BigDecimal("7.95"));
        i14.setGlutenfree(true);
        i14.setVegan(false);
        i14.setVegetarian(false);
        i14.setNutfree(false);
        i14.setShortDescription("Rice noodle, carrots, cucumber, scallion and cilantro servied with fish sauce dressing");
        i14.setLongDescription("");
        i14.setCategory("appetizer");
        i14.setItemNumber(9);
        m.getItems().add(i14);

        MenuItem i3 = new MenuItem();
        i3.setItemID(UUID.randomUUID());
        i3.setName("pho with everything");
        i3.setGlutenfree(true);
        i3.setNutfree(true);
        i3.setVegetarian(false);
        i3.setVegan(false);
        i3.setPrice(new BigDecimal("15.50"));
        i3.setShortDescription("Pho noodle soup with rare steak, flank, brisket, tendon and tripe");
        i3.setLongDescription("Pho noodle soup with rare steak, flank, brisket, tendon and tripe. The noodles are made from rice and there's a side dish of optional toppings.");
        i3.setCategory("noodle soups");
        i3.setItemNumber(10);
        m.getItems().add(i3);

        MenuItem i4 = new MenuItem();
        i4.setItemID(UUID.randomUUID());
        i4.setName("Pho with rare steak");
        i4.setGlutenfree(true);
        i4.setNutfree(true);
        i4.setVegetarian(false);
        i4.setVegan(false);
        i4.setPrice(new BigDecimal("15.50"));
        i4.setShortDescription("Pho noodle soup with rare steak");
        i4.setLongDescription("Pho noodle soup with rare steak. The noodles are made from rice, the broth is made from beef bones and there's a side dish of optional toppings.");
        i4.setCategory("noodle soups");
        i4.setItemNumber(11);
        m.getItems().add(i4);

        MenuItem i8 = new MenuItem();
        i8.setItemID(UUID.randomUUID());
        i8.setName("Pho with rare round and tendon");
        i8.setGlutenfree(true);
        i8.setNutfree(true);
        i8.setVegetarian(false);
        i8.setVegan(false);
        i8.setPrice(new BigDecimal("15.50"));
        i8.setShortDescription("Pho noodle soup with rare steak and tendon");
        i8.setLongDescription("Pho noodle soup with rare steak and tendon");
        i8.setCategory("noodle soups");
        i8.setItemNumber(12);
        m.getItems().add(i8);

        MenuItem i9 = new MenuItem();
        i9.setItemID(UUID.randomUUID());
        i9.setName("Chicken Pho");
        i9.setGlutenfree(true);
        i9.setNutfree(true);
        i9.setVegetarian(false);
        i9.setVegan(false);
        i9.setPrice(new BigDecimal("15.50"));
        i9.setShortDescription("Chicken pho broth with rice noodles");
        i9.setLongDescription("");
        i9.setCategory("noodle soups");
        i9.setItemNumber(13);
        m.getItems().add(i9);

        MenuItem i10 = new MenuItem();
        i10.setItemID(UUID.randomUUID());
        i10.setName("Seafood noodle soup");
        i10.setGlutenfree(false);
        i10.setNutfree(true);
        i10.setVegetarian(false);
        i10.setVegan(false);
        i10.setPrice(new BigDecimal("18.90"));
        i10.setShortDescription("Noodle soup with shrimp, imitation crabmeat, squid and fish cake");
        i10.setLongDescription("");
        i10.setCategory("noodle soups");
        i10.setItemNumber(14);
        m.getItems().add(i10);

        MenuItem i15 = new MenuItem();
        i15.setItemID(UUID.randomUUID());
        i15.setName("Stir fry yellow noodles");
        i15.setGlutenfree(false);
        i15.setNutfree(false);
        i15.setVegetarian(false);
        i15.setVegan(false);
        i15.setPrice(new BigDecimal("18.30"));
        i15.setShortDescription("Egg noodles stir fried with bean sprouts, carrots, cucumber, garlic and ginger");
        i15.setLongDescription("");
        i15.setCategory("stir fry");
        i15.setItemNumber(15);
        m.getItems().add(i15);

        MenuItem i16 = new MenuItem();
        i16.setItemID(UUID.randomUUID());
        i16.setName("Pad Thai");
        i16.setGlutenfree(true);
        i16.setNutfree(false);
        i16.setVegetarian(false);
        i16.setVegan(false);
        i16.setPrice(new BigDecimal("17.90"));
        i16.setShortDescription("Classic Pad Thai noodles with chicken, bean sprouts, garlic chive and peanuts");
        i16.setLongDescription("");
        i16.setCategory("stir fry");
        i16.setItemNumber(16);
        m.getItems().add(i16);

        MenuItem i17 = new MenuItem();
        i17.setItemID(UUID.randomUUID());
        i17.setName("Stir fry flat noodles");
        i17.setGlutenfree(true);
        i17.setNutfree(false);
        i17.setVegetarian(false);
        i17.setVegan(false);
        i17.setPrice(new BigDecimal("17.90"));
        i17.setShortDescription("Large flat rice noodles stir fried with chicken, carrots and bean sprouts");
        i17.setLongDescription("");
        i17.setCategory("stir fry");
        i17.setItemNumber(17);
        m.getItems().add(i17);

        MenuItem i18 = new MenuItem();
        i18.setItemID(UUID.randomUUID());
        i18.setName("Curry Vegetable Medley");
        i18.setGlutenfree(true);
        i18.setNutfree(false);
        i18.setVegetarian(false);
        i18.setVegan(false);
        i18.setPrice(new BigDecimal("18.90"));
        i18.setShortDescription("Sauteed with onions, summer squash, mushrooms carrots, baby corn, snow peas and roasted peanuts");
        i18.setLongDescription("");
        i18.setCategory("stir fry");
        i18.setItemNumber(18);
        m.getItems().add(i18);

        MenuItem i19 = new MenuItem();
        i19.setItemID(UUID.randomUUID());
        i19.setName("Pork Sauteed with lemongrass");
        i19.setGlutenfree(true);
        i19.setNutfree(false);
        i19.setVegetarian(false);
        i19.setVegan(false);
        i19.setPrice(new BigDecimal("18.90"));
        i19.setShortDescription("Pork sauteed with sliced onions, scallions, red peppers and roasted peanuts");
        i19.setLongDescription("");
        i19.setCategory("stir fry");
        i19.setItemNumber(19);
        m.getItems().add(i19);

        MenuItem i20 = new MenuItem();
        i20.setItemID(UUID.randomUUID());
        i20.setName("Chicken Sauteed with lemongrass");
        i20.setGlutenfree(true);
        i20.setNutfree(false);
        i20.setVegetarian(false);
        i20.setVegan(false);
        i20.setPrice(new BigDecimal("18.90"));
        i20.setShortDescription("Chicken sauteed with onions, ginger and roasted peanuts");
        i20.setLongDescription("");
        i20.setCategory("stir fry");
        i20.setItemNumber(20);
        m.getItems().add(i20);

        return vietnam;
    }

    public static Store createDiner() {
        Store diner = new Store();
        diner.setStoreID(UUID.randomUUID());
        diner.setStoreName("Diner 99");
        diner.setStoreDescription("your favorite american dishes");
        diner.setTags(new String[]{"diner","american"});

        Menu m = new Menu();
        m.setMenuID(UUID.randomUUID());
        m.setMenuType("dine-in");
        diner.getMenus().add(m);

        MenuItem i1 = new MenuItem();
        i1.setItemID(UUID.randomUUID());
        i1.setName("Chicken Noodle Soup");
        i1.setGlutenfree(false);
        i1.setNutfree(true);
        i1.setVegan(false);
        i1.setVegetarian(false);
        i1.setPrice(new BigDecimal("6.75"));
        i1.setShortDescription("Chicken breast, celery, carrots and rotini pasta");
        i1.setLongDescription("");
        i1.setCategory("soups");
        i1.setItemNumber(1);
        m.getItems().add(i1);

        MenuItem i2 = new MenuItem();
        i2.setItemID(UUID.randomUUID());
        i2.setName("New England Claim Chowder");
        i2.setGlutenfree(false);
        i2.setNutfree(true);
        i2.setVegan(false);
        i2.setVegetarian(false);
        i2.setPrice(new BigDecimal("7.99"));
        i2.setShortDescription("Quahog claims, potato and bacon in a creamy broth");
        i2.setLongDescription("");
        i2.setCategory("soups");
        i2.setItemNumber(2);
        m.getItems().add(i2);

        MenuItem i3 = new MenuItem();
        i3.setItemID(UUID.randomUUID());
        i3.setName("Buffalo Wings");
        i3.setGlutenfree(false);
        i3.setNutfree(true);
        i3.setVegan(false);
        i3.setVegetarian(false);
        i3.setPrice(new BigDecimal("9.89"));
        i3.setShortDescription("8 buffalo wings with ranch dressing on the side");
        i3.setLongDescription("");
        i3.setCategory("appetizer");
        i3.setItemNumber(3);
        m.getItems().add(i3);

        MenuItem i4 = new MenuItem();
        i4.setItemID(UUID.randomUUID());
        i4.setName("Dirty Fries");
        i4.setGlutenfree(true);
        i4.setNutfree(true);
        i4.setVegan(false);
        i4.setVegetarian(false);
        i4.setPrice(new BigDecimal("9.99"));
        i4.setShortDescription("Shoe string fries topped with cheese, bacon, garlic chips and paprika");
        i4.setLongDescription("");
        i4.setCategory("appetizer");
        i4.setItemNumber(4);
        m.getItems().add(i4);

        MenuItem i5 = new MenuItem();
        i5.setItemID(UUID.randomUUID());
        i5.setName("Hashbrowns and 3 eggs");
        i5.setGlutenfree(true);
        i5.setNutfree(true);
        i5.setVegan(false);
        i5.setVegetarian(false);
        i5.setPrice(new BigDecimal("11.99"));
        i5.setShortDescription("Yukon gold potato hash with 3 eggs");
        i5.setLongDescription("");
        i5.setCategory("entrees");
        i5.setItemNumber(5);
        m.getItems().add(i5);

        MenuItem i6 = new MenuItem();
        i6.setItemID(UUID.randomUUID());
        i6.setName("3 eggs, sausage and 3 pancakes");
        i6.setGlutenfree(false);
        i6.setNutfree(true);
        i6.setVegan(false);
        i6.setVegetarian(false);
        i6.setPrice(new BigDecimal("13.89"));
        i6.setShortDescription("");
        i6.setLongDescription("");
        i6.setCategory("entrees");
        i6.setItemNumber(6);
        m.getItems().add(i6);

        MenuItem i7 = new MenuItem();
        i7.setItemID(UUID.randomUUID());
        i7.setName("3 blueberry pancakes");
        i7.setGlutenfree(false);
        i7.setNutfree(true);
        i7.setVegan(false);
        i7.setVegetarian(false);
        i7.setPrice(new BigDecimal("8.89"));
        i7.setShortDescription("");
        i7.setLongDescription("");
        i7.setCategory("entrees");
        i7.setItemNumber(7);
        m.getItems().add(i7);

        MenuItem i8 = new MenuItem();
        i8.setItemID(UUID.randomUUID());
        i8.setName("Reuben");
        i8.setGlutenfree(false);
        i8.setNutfree(true);
        i8.setVegan(false);
        i8.setVegetarian(false);
        i8.setPrice(new BigDecimal("9.89"));
        i8.setShortDescription("Corn beef, swiss, sauerkraut and mustard on rye");
        i8.setLongDescription("");
        i8.setCategory("sandwich");
        i8.setItemNumber(8);
        m.getItems().add(i8);

        MenuItem i9 = new MenuItem();
        i9.setItemID(UUID.randomUUID());
        i9.setName("Roast Beef");
        i9.setGlutenfree(false);
        i9.setNutfree(true);
        i9.setVegan(false);
        i9.setVegetarian(false);
        i9.setPrice(new BigDecimal("12.89"));
        i9.setShortDescription("Roast beef, mustard, cheddar, lettuce and kaiser bun");
        i9.setLongDescription("");
        i9.setCategory("sandwich");
        i9.setItemNumber(9);
        m.getItems().add(i9);

        MenuItem i10 = new MenuItem();
        i10.setItemID(UUID.randomUUID());
        i10.setName("Roast Turkey");
        i10.setGlutenfree(false);
        i10.setNutfree(true);
        i10.setVegan(false);
        i10.setVegetarian(false);
        i10.setPrice(new BigDecimal("9.89"));
        i10.setShortDescription("Roast turkey breast, swiss, lettuce and tomato on kaiser bun");
        i10.setLongDescription("");
        i10.setCategory("sandwich");
        i10.setItemNumber(10);
        m.getItems().add(i10);

        MenuItem i11 = new MenuItem();
        i11.setItemID(UUID.randomUUID());
        i11.setName("BLT");
        i11.setGlutenfree(false);
        i11.setNutfree(true);
        i11.setVegan(false);
        i11.setVegetarian(false);
        i11.setPrice(new BigDecimal("10.89"));
        i11.setShortDescription("Bacon, lettuce and tomato on rye");
        i11.setLongDescription("");
        i11.setCategory("sandwich");
        i11.setItemNumber(11);
        m.getItems().add(i11);

        MenuItem i12 = new MenuItem();
        i12.setItemID(UUID.randomUUID());
        i12.setName("Black forrest ham");
        i12.setGlutenfree(false);
        i12.setNutfree(true);
        i12.setVegan(false);
        i12.setVegetarian(false);
        i12.setPrice(new BigDecimal("11.89"));
        i12.setShortDescription("Black forrest ham, cheddar, lettuce, onion and tomato on kaiser bun");
        i12.setLongDescription("");
        i12.setCategory("sandwich");
        i12.setItemNumber(12);
        m.getItems().add(i12);

        MenuItem i13 = new MenuItem();
        i13.setItemID(UUID.randomUUID());
        i13.setName("Classic burger");
        i13.setGlutenfree(false);
        i13.setNutfree(true);
        i13.setVegan(false);
        i13.setVegetarian(false);
        i13.setPrice(new BigDecimal("6.89"));
        i13.setShortDescription("1 beef patty, lettuce, tomato, onions, pickles and ketchup on kaiser bun");
        i13.setLongDescription("");
        i13.setCategory("burger");
        i13.setItemNumber(13);
        m.getItems().add(i13);

        MenuItem i14 = new MenuItem();
        i14.setItemID(UUID.randomUUID());
        i14.setName("Cheese burger");
        i14.setGlutenfree(false);
        i14.setNutfree(true);
        i14.setVegan(false);
        i14.setVegetarian(false);
        i14.setPrice(new BigDecimal("7.89"));
        i14.setShortDescription("1 beef patty, 2 slices of cheddar, lettuce, tomato, onions, pickles and ketchup on kaiser bun");
        i14.setLongDescription("");
        i14.setCategory("burger");
        i14.setItemNumber(14);
        m.getItems().add(i14);

        MenuItem i15 = new MenuItem();
        i15.setItemID(UUID.randomUUID());
        i15.setName("Baconator burger");
        i15.setGlutenfree(false);
        i15.setNutfree(true);
        i15.setVegan(false);
        i15.setVegetarian(false);
        i15.setPrice(new BigDecimal("10.89"));
        i15.setShortDescription("1 beef patty, 3 strips of bacon, lettuce, tomato, onions, pickles and ketchup on kaiser bun");
        i15.setLongDescription("");
        i15.setCategory("burger");
        i15.setItemNumber(15);
        m.getItems().add(i15);

        MenuItem i16 = new MenuItem();
        i16.setItemID(UUID.randomUUID());
        i16.setName("Guacamole burger");
        i16.setGlutenfree(false);
        i16.setNutfree(true);
        i16.setVegan(false);
        i16.setVegetarian(false);
        i16.setPrice(new BigDecimal("11.89"));
        i16.setShortDescription("1 beef patty, guacamole, lettuce and tapatio sauce on kaiser bun");
        i16.setLongDescription("");
        i16.setCategory("burger");
        i16.setItemNumber(16);
        m.getItems().add(i16);

        MenuItem i17 = new MenuItem();
        i17.setItemID(UUID.randomUUID());
        i17.setName("Cheese Omelet");
        i17.setGlutenfree(true);
        i17.setNutfree(true);
        i17.setVegan(false);
        i17.setVegetarian(false);
        i17.setPrice(new BigDecimal("6.89"));
        i17.setShortDescription("2 egg omelette with cheddar");
        i17.setLongDescription("");
        i17.setCategory("omelet");
        i17.setItemNumber(17);
        m.getItems().add(i17);

        MenuItem i18 = new MenuItem();
        i18.setItemID(UUID.randomUUID());
        i18.setName("Denver Omelet");
        i18.setGlutenfree(true);
        i18.setNutfree(true);
        i18.setVegan(false);
        i18.setVegetarian(false);
        i18.setPrice(new BigDecimal("8.89"));
        i18.setShortDescription("2 egg omelette with cheddar, ham, onion and bell peppers");
        i18.setLongDescription("");
        i18.setCategory("omelet");
        i18.setItemNumber(18);
        m.getItems().add(i18);

        MenuItem i19 = new MenuItem();
        i19.setItemID(UUID.randomUUID());
        i19.setName("Feta Spinach Omelet");
        i19.setGlutenfree(true);
        i19.setNutfree(true);
        i19.setVegan(false);
        i19.setVegetarian(false);
        i19.setPrice(new BigDecimal("9.89"));
        i19.setShortDescription("2 egg omelette with feta cheese and spinach");
        i19.setLongDescription("");
        i19.setCategory("omelet");
        i19.setItemNumber(19);
        m.getItems().add(i19);

        MenuItem i20 = new MenuItem();
        i20.setItemID(UUID.randomUUID());
        i20.setName("Tomato Omelet");
        i20.setGlutenfree(true);
        i20.setNutfree(true);
        i20.setVegan(false);
        i20.setVegetarian(false);
        i20.setPrice(new BigDecimal("8.89"));
        i20.setShortDescription("2 egg omelette with diced tomato and ham");
        i20.setLongDescription("");
        i20.setCategory("omelet");
        i20.setItemNumber(20);
        m.getItems().add(i20);

        return diner;
    }
}