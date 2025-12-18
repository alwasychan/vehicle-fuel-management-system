# Vehicle Fuel Management System 🚗🏍️🚚

## 📌 Project Overview
A **Java-based console application** for managing fuel consumption and refueling operations of different vehicle types. This project demonstrates Object-Oriented Programming (OOP) concepts with real-world application in fuel management.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![OOP](https://img.shields.io/badge/OOP-Design-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Status](https://img.shields.io/badge/Status-Complete-success)

## ✨ Features
- ✅ **Multiple Vehicle Types** - Car, Bike, and Truck management
- ✅ **Fuel Operations** - Refuel and consumption tracking
- ✅ **Capacity Validation** - Prevents overfilling and underflow
- ✅ **Exception Handling** - Robust error management
- ✅ **Console UI** - User-friendly menu system
- ✅ **Data Persistence** - Runtime vehicle storage

## 🏗️ Class Architecture
```
Vehicle (Abstract Class)
├── Car (Extends Vehicle)
├── Bike (Extends Vehicle)
└── Truck (Extends Vehicle)

FuelManagementSystem (Manager Class)
Cseproject (Main Driver Class)
```

## 📊 Vehicle Specifications

### 🚗 Car
| Attribute | Example Value |
|-----------|--------------|
| ID | C1, C2, C3 |
| Model | Toyota, Honda, BMW |
| Fuel Capacity | 50-70 liters |
| Seats | 4-7 seats |

### 🏍️ Bike
| Attribute | Example Value |
|-----------|--------------|
| ID | B1, B2, B3 |
| Model | Yamaha, Honda, Suzuki |
| Fuel Capacity | 10-20 liters |
| Type | Sport, Cruiser, Scooter |

### 🚚 Truck
| Attribute | Example Value |
|-----------|--------------|
| ID | T1, T2, T3 |
| Model | Volvo, Tata, Mercedes |
| Fuel Capacity | 150-200 liters |
| Load Capacity | 5-20 tons |

## 🚀 Installation & Setup

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or Command Line

### Method 1: Using IDE
1. Clone the repository:
```bash
git clone https://github.com/your-username/vehicle-fuel-management.git
```
2. Open in your IDE
3. Run `Cseproject.java`

### Method 2: Command Line
```bash
# Compile the program
javac Cseproject.java

# Run the program
java Cseproject
```

## 📖 How to Use

### Main Menu Options
```
===== Vehicle Fuel Management System =====
1. Show All Vehicles
2. Refuel a Vehicle
3. Use Fuel
4. Exit
```

### Sample Operations

#### 1. View All Vehicles
```
--- Vehicle List ---
Car
ID: C1
Model: Toyota
Seats: 5
Fuel Capacity: 50.0 L
Current Fuel: 20.0 L
-----------------------------
```

#### 2. Refuel a Vehicle
```
Enter Vehicle ID (C1/B1/T1): C1
Enter fuel amount to add (in liters): 15
Refuel successful.
Updated Fuel: 35.0 L
```

#### 3. Use Fuel
```
Enter Vehicle ID (C1/B1/T1): B1
Enter fuel amount to use (in liters): 5
Fuel usage successful.
Updated Fuel: 3.0 L
```

## ⚠️ Error Handling
The system includes comprehensive error handling:
- ❌ Invalid fuel amount (negative/zero values)
- ❌ Insufficient fuel for consumption
- ❌ Overfilling beyond capacity
- ❌ Vehicle not found
- ❌ Invalid menu choices
- ❌ Non-numeric inputs

## 💻 Code Structure

### Key Methods
| Method | Class | Description |
|--------|-------|-------------|
| `refuel(double amount)` | Vehicle | Adds fuel with validation |
| `consumeFuel(double amount)` | Vehicle | Deducts fuel with validation |
| `displayInfo()` | All Vehicles | Shows vehicle details |
| `findVehicle(String id)` | FuelManagementSystem | Searches vehicle by ID |

### Sample Code Snippet
```java
// Abstract Vehicle class
abstract class Vehicle {
    private String id;
    private String model;
    private double fuelCapacity;
    private double currentFuel;
    
    public void refuel(double amount) throws Exception {
        if(amount <= 0) throw new Exception("Fuel amount must be greater than zero.");
        if(currentFuel + amount > fuelCapacity) throw new Exception("Cannot refuel. Fuel capacity exceeded.");
        currentFuel += amount;
    }
}
```

## 🧪 Testing Examples

### Test Case 1: Normal Refuel
```
Input: Refuel Vehicle C1 with 20 liters
Output: Success (20 → 40 liters)
```

### Test Case 2: Overfill Prevention
```
Input: Refuel Vehicle C1 with 30 liters (Capacity: 50, Current: 40)
Output: Error - "Cannot refuel. Fuel capacity exceeded."
```

### Test Case 3: Insufficient Fuel
```
Input: Use 15 liters from Vehicle B1 (Current: 8 liters)
Output: Error - "Not enough fuel."
```

## 📈 Project Highlights
- **Encapsulation**: Private fields with public getters/setters
- **Inheritance**: Vehicle as base class extended by Car, Bike, Truck
- **Polymorphism**: `displayInfo()` method overridden in subclasses
- **Abstraction**: Vehicle as abstract class
- **Exception Handling**: Custom error messages

## 🎯 Learning Outcomes
This project covers:
- Core OOP principles in Java
- ArrayList for dynamic data management
- User input validation
- Menu-driven console applications
- Real-world problem solving

## 👥 Sample Data (Pre-loaded)
| Vehicle | ID | Model | Fuel Capacity | Current Fuel | Special Attribute |
|---------|----|-------|--------------|--------------|-------------------|
| Car | C1 | Toyota | 50L | 20L | 5 Seats |
| Bike | B1 | Yamaha | 15L | 8L | Sport Type |
| Truck | T1 | Volvo | 150L | 90L | 12 Tons |

## 🔮 Future Enhancements
Potential improvements for this project:
- [ ] Database integration (MySQL/PostgreSQL)
- [ ] GUI using JavaFX/Swing
- [ ] File persistence (Save/Load data)
- [ ] Fuel price calculator
- [ ] Maintenance scheduling
- [ ] User authentication
- [ ] Reports generation

## 🤝 Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author
**Your Name**  
- GitHub: https://github.com/alwasychan
- Email: alwasychan@proton.me
- University: East West University

## 🙏 Acknowledgments
- Java Documentation
- OOP Concepts and Design Patterns
- All Contributors and Testers

---
⭐ **Star this repo if you find it helpful!** ⭐

---

**Last Updated:** December 2025
**Java Version:** 17+  
**Project Status:** ✅ Complete & Functional

```
For any queries or issues, please open an issue in the GitHub repository.
Happy Coding! 🚀
```


## 📞 Support
Need help? Create an issue or contact the author!

---
Made with ❤️ and Java
