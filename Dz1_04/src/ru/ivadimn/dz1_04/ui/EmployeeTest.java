package ru.ivadimn.dz1_04.ui;

import ru.ivadimn.dz1_04.model.Employee;

/**
 * Created by vadim on 21.07.16.
 */
public class EmployeeTest {

    public static final int EMPLOYEE_COUNT = 6;

    public static void main(String[] args) {
        Employee[] employees = new Employee[EMPLOYEE_COUNT];

        employees[0] = new Employee("Иввнов Петр Сергеевич", "начальник отдела", "pivanov@yanddex.ru",
                "222-33-67", 50000.00, 45);
        employees[1] = new Employee("Сидоров Иван Степанович", "заместитель начальник отдела", "isidorov@yanddex.ru",
                "456-33-67", 40000.00, 40);
        employees[2] = new Employee("Васильев Семен Петрович", "юрисконсульт", "svasilev@yanddex.ru",
                "678-33-67", 35000.00, 35);
        employees[3] = new Employee("Макаров Сергей Александрович", "ведущий специалист", "smakarov@yanddex.ru",
                "876-22-67", 35000.00, 23);
        employees[4] = new Employee("Адеев Андрей Иванович", "заместитель генерального директора", "aadeev@yanddex.ru",
                "156-22-88", 70000.00, 48);
        employees[5] = new Employee("Филиппов Александр Семенлвич", "генеральный директор", "afilippov@yanddex.ru",
                "146-34-88", 100000.00, 50);

        System.out.println("Сотрудник старше 40 лет :");
        showInfo(employees, 40);

    }

    private static void showInfo(Employee[] employees, int age) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= age)
                employees[i].printInfo();
        }
    }
}
