# 🍔 iHungry Burger Shop Management System  
*A Java Swing (MVC) desktop application for managing burger shop orders.*

---

## 📌 Overview  

iHungry Burger Shop Management System is a Java Swing application built using the **MVC design pattern**.  
It allows the burger shop to efficiently manage customer orders, update order details, search customer & order history, and view categorized order lists.

---

## 🛠️ Technologies Used  
- **Java SE**  
- **Java Swing (GUI)**  
- **MVC Architecture**  
- **Custom UI Components** (e.g., `RoundedJButton`)  
- **File-based storage** (`iHungry_db.txt`)

---

## 📂 Project Structure

```
src/
 ├── controller/
 ├── model/
 ├── view/
 ├── util/
 └── iHungry_db.txt
```

---

## ✨ Features

### **1. Place Order**
- Auto-generates `Order ID` (O001, O002, …).
- Auto-generates `Customer ID` (C001, C002, …).
- Accepts customer name and burger quantity.
- Validates all inputs.
- Calculates net total (Burger price = **Rs. 500**).
- Order statuses: **PREPARING, DELIVERED, CANCELLED**.

---

### **2. Search Best Customer**
- Shows all customers sorted by total purchases (descending).
- Displays summary table.
- Option to return to main menu.

---

### **3. Search Order**
- Enter Order ID → displays full order details.
- Validates if order exists.

---

### **4. Search Customer**
- Enter Customer ID → displays:
  - All orders by that customer  
  - Total spent  
  - Order breakdown  
- Option to continue searching or go back.

---

### **5. View Orders**
Displays orders under three categories:  
1. **Delivered Orders**  
2. **Preparing Orders**  
3. **Cancelled Orders**  
Each category opens a display table with complete details.

---

### **6. Update Order Details**
- Search by Order ID.
- Only **Preparing** orders can be updated.
- Update:
  - **Burger Quantity**  
  - **Order Status**
- Validates all inputs.
- Shows updated values.

---

## 💾 Data Storage  
All order and customer data is saved inside:

```
iHungry_db.txt
```

The application reads and writes using structured text records.

---

## 📸 Screenshots  
<img width="534" height="235" alt="image" src="https://github.com/user-attachments/assets/cae0ed50-d421-4dd9-b5fd-30f752d821d7" />
<img width="853" height="578" alt="image" src="https://github.com/user-attachments/assets/dbe64b18-a5d8-484d-a7b4-ba9a7954f8f5" />
<img width="833" height="537" alt="image" src="https://github.com/user-attachments/assets/ea4203d4-d4f1-42e1-a228-f4fbe2764d6b" />
<img width="834" height="536" alt="image" src="https://github.com/user-attachments/assets/3909111d-e70f-4aa0-8b0f-d35a2e4031ef" />
<img width="849" height="635" alt="image" src="https://github.com/user-attachments/assets/e11a1a00-5ddf-445c-b797-728fc9f651a3" />

---

## 🚀 How to Run  
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repo.git](https://github.com/SachinthaAbeygunasekara/iHungry_Burger_Shop.git
   ```
2. Open the project in **NetBeans / IntelliJ / Eclipse**.
3. Compile and run:
   ```bash
   javac Main.java
   java Main
   ```

