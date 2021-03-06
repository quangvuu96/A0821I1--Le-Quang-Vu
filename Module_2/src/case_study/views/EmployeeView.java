package case_study.views;

import case_study.controllers.FuramaController;
import case_study.models.Employee;
import case_study.utils.CommonUtil;
import case_study.utils.ConstantUtil;

public class EmployeeView {
    private static FuramaController employeeController= new FuramaController();

    static void employeeManger(){
        System.out.println("--- Employee View: ---\n" +
                "1. Display list employees\n" +
                "2. Add new employee\n" +
                "3. Edit employee\n" +
                "4. Return main menu\n");

        int choice= 0;
        do{
            System.out.print("Input your choice: ");
            choice= Integer.parseInt(CommonUtil.getScanner().nextLine());
        }while (choice<=0 || choice> 4);

        switch (choice){
            case 1:
                display();
                break;
            case 2:
                create();
                break;
            case 3:
                edit();
                break;
            case 4:
                FuramaController.displayMainMenu();
        }
    }

    private static void display(){
//        System.out.print("Input name to search: ");
//        String name= CommonUtil.getScanner().nextLine();
//        employeeController.search(name).forEach(System.out::println);
        employeeController.getAll().forEach(System.out::println);
    }

    private static void create(){
        inputAndSave(0);
    }

    private static void edit(){
        employeeController.getAll().forEach(System.out::println);
        System.out.printf("Choice employee id to edit: ");
        int id= Integer.parseInt(CommonUtil.getScanner().nextLine());
        inputAndSave(id);
    }

    private static void inputAndSave(int id){
        System.out.printf("Code: ");
        String code= CommonUtil.getScanner().nextLine();
        System.out.printf("Fullname: ");
        String name= CommonUtil.getScanner().nextLine();
        System.out.printf("Birthday: ");
        String birthday= CommonUtil.getScanner().nextLine();
        System.out.printf("Gender: ");
        String gender= CommonUtil.getScanner().nextLine();
        System.out.printf("Phone: ");
        String phone= CommonUtil.getScanner().nextLine();
        Employee employee= new Employee(id, code, name, birthday, ConstantUtil.Gender.valueOf(gender.toUpperCase()) , phone, "email", "address", null, null, 123);
        employeeController.save(employee);
        System.out.println(id==0? "Created successful": "Updated successful");
    }
}
