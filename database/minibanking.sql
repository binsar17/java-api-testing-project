-- ==========================================
-- MINI BANKING DATABASE
-- QA / API TESTING PROJECT
-- ==========================================

-- Create database
CREATE DATABASE IF NOT EXISTS minibanking;

USE minibanking;

-- ==========================================
-- TABLE: customers
-- ==========================================

CREATE TABLE IF NOT EXISTS customers (
    id BIGINT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    account_number VARCHAR(10) NOT NULL,
    balance DOUBLE NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_account_number (account_number),
    CONSTRAINT chk_balance_non_negative CHECK (balance >= 0)
);

-- ==========================================
-- TEST DATA
-- ==========================================

INSERT INTO customers
    (customer_name, account_number, balance)
VALUES
    ('Budi Santoso', '1000000001', 5000000.00),
    ('Siti Aminah', '1000000002', 7500000.00),
    ('Andi Pratama', '1000000003', 2500000.00);

-- ==========================================
-- READ / SELECT TEST
-- ==========================================

-- Get all customers
SELECT * FROM customers;

-- Get customer by ID
SELECT *
FROM customers
WHERE id = 1;

-- Get customer by account number
SELECT *
FROM customers
WHERE account_number = '1000000001';

-- ==========================================
-- VALIDATION TEST
-- ==========================================

-- Check duplicate account numbers
SELECT account_number, COUNT(*) AS total
FROM customers
GROUP BY account_number
HAVING COUNT(*) > 1;

-- Check negative balance
SELECT *
FROM customers
WHERE balance < 0;

-- Check invalid account number length
SELECT *
FROM customers
WHERE CHAR_LENGTH(account_number) <> 10;

-- Check NULL values
SELECT *
FROM customers
WHERE customer_name IS NULL
   OR account_number IS NULL
   OR balance IS NULL;

-- ==========================================
-- UPDATE TEST
-- ==========================================

UPDATE customers
SET customer_name = 'Budi Santoso Updated',
    balance = 6000000.00
WHERE id = 1;

-- Verify update
SELECT *
FROM customers
WHERE id = 1;

-- ==========================================
-- DELETE TEST
-- ==========================================

DELETE FROM customers
WHERE id = 3;

-- Verify delete
SELECT *
FROM customers
WHERE id = 3;

-- ==========================================
-- FINAL DATA
-- ==========================================

SELECT * FROM customers;
