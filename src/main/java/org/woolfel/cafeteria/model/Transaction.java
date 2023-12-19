package org.woolfel.cafeteria.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Transactions can be meal plan or direct purchase with cash or CC.
 */
public class Transaction {
    private UUID transactionID;
    private List<MenuItem> items = new ArrayList<>();
    private String paymentType;
    private LocalDateTime timestamp;
    private UUID cafeID;
    // The register that processed the transaction
    private UUID registerID;
    // the cashier employee ID
    private UUID employID;
    private BigDecimal subtotal = new BigDecimal("0.0");
    private BigDecimal tax = new BigDecimal("0.0");
    private BigDecimal total = new BigDecimal("0.0");
    public Transaction(){}

    public UUID getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(UUID transactionID) {
        this.transactionID = transactionID;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getCafeID() {
        return cafeID;
    }

    public void setCafeID(UUID cafeID) {
        this.cafeID = cafeID;
    }

    public UUID getRegisterID() {
        return registerID;
    }

    public void setRegisterID(UUID registerID) {
        this.registerID = registerID;
    }

    public UUID getEmployID() {
        return employID;
    }

    public void setEmployID(UUID employID) {
        this.employID = employID;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
