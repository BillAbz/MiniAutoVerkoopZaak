package service;

import DAO.OfficeDAO;
import Entities.Customer;
import Entities.Employee;
import Entities.Office;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class OfficeService {

    private OfficeDAO officeDAO;
    private Scanner scanner;

    public OfficeService() {
        officeDAO = new OfficeDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllOffices() throws SQLException {
        if (officeDAO.getAllOffices() != null)
            officeDAO.getAllOffices().forEach(System.out::println);
        else
            System.out.println("No Offices to show.");
    }

    public void showOfficeByOfficeCode() throws SQLException {
        System.out.println("What is the id of the Office you want to lookup?");
        int input = scanner.nextInt();
        Office office =  officeDAO.getOfficeByOfficeCode(input);
        if (office != null)
            System.out.println(office);
        else
            System.out.println("Id does not match any of the Offices.");
    }


    public Office createAnOffice() {
        System.out.println("What city is the office located?");
        String city = scanner.nextLine();
        System.out.println("What is the phone number of the office?");
        String phoneNumber = scanner.next();
        if (phoneNumber.length()<9 || phoneNumber.length()>10){
            System.out.println("doesn't seem right");
            phoneNumber = scanner.next();
        }else {
            System.out.println(phoneNumber);
            System.out.println("klopt dit nummer?   Y/N");
            String yesNo= scanner.next();
            if (yesNo.toUpperCase(Locale.ROOT)=="N"){
                phoneNumber =scanner.next();
            }
            System.out.println("thanks");
        }
        System.out.println("What is the first addressline of the office?");
        String addressLine1 = scanner.nextLine();
        System.out.println("What's the second addressline of the office?");
        String addressLine2 = scanner.nextLine();
        System.out.println("What is the state of the office?");
        String state = scanner.nextLine();
        System.out.println("What is the Country of the office?");
        String country = scanner.nextLine();
        System.out.println("What is the postal code of the office?");
        String postalCode = scanner.nextLine();
        System.out.println("What is the territory of the office?");
        String territory = scanner.nextLine();
        Office office = new Office(city,phoneNumber,addressLine1,addressLine2,state,country,postalCode,territory);
        officeDAO.addOffices(office);

        return office;
    }

    public void updateAnOffice() {

            boolean done;
            System.out.println("please enter the code of the office you wish to update");
            int id = scanner.nextInt();
            Office office = officeDAO.getOfficeByOfficeCode(id);

            while (office == null) {
                System.err.println("Office doesn't exist. Please enter a valid code.");
                id = scanner.nextInt();
                office = officeDAO.getOfficeByOfficeCode(id);
            }
            System.out.println("What would you like to update:\n");



            do {
                done = false;

                String updateMore;











                System.out.println("Please select an option: \n(1)City\n(2)Phone\n(3)AddressLine 1\n(4)AddressLine 2\n(5)State\n(6)Country\n(7)Postal Code\n(8)Territory");
                int selection = scanner.nextInt();

                while (selection > 10 || selection < 1) {
                    System.out.println("Please make a valid selection");
                    selection = scanner.nextInt();
                }

                switch (selection) {
                    case 1:
                        System.out.println("City:");
                        String city = scanner.nextLine();
                        office.setCity(city);
                        System.out.println("City has been updated to: " + city);


                        break;


                    case 2:
                        System.out.println("PhoneNumber:"); //Todo:: Make loop instead of passing once in if else statement, also make check more solid
                        String phone = scanner.nextLine();
                        if (phone.length() < 9 || phone.length() > 10) {
                            System.out.println("doesn't seem right");
                            phone = scanner.next();
                        } else {
                            System.out.println(phone);
                            System.out.println("klopt dit nummer?   Y/N");
                            String yesNo = scanner.next();
                            if (yesNo.toUpperCase(Locale.ROOT) == "N") {
                                phone = scanner.next();
                            }
                            System.out.println("thanks");
                            office.setPhone(phone);
                        }
                        System.out.println("Phone number has been updated to: " + phone);


                        break;


                    case 3:
                        System.out.println("AddressLine1:");
                        String addressLine1 = scanner.nextLine();
                        office.setAddressLine1(addressLine1);
                        System.out.println("Address line 1 has been updated to: " + addressLine1);

                        break;
                    case 4:
                        System.out.println("AddressLine2:");
                        String addressLine2 = scanner.nextLine();
                        office.setAddressLine2(addressLine2);
                        System.out.println("Address line 2 has been updated to: " + addressLine2);

                        break;

                    case 5:
                        System.out.println("State:");
                        String state = scanner.nextLine();
                        office.setState(state);
                        System.out.println("State has been updated to: " + state);



                        break;

                    case 6:
                        System.out.println("Country:");
                        String country = scanner.nextLine();
                        office.setCountry(country);
                        System.out.println("Country has been updated to: " + country);

                        break;

                    case 7:
                        System.out.println("PostalCode:");
                        String postalCode = scanner.nextLine();
                        office.setPostalCode(postalCode);
                        System.out.println("Postal code has been updated to: " + postalCode);


                        break;

                    case 8:
                        System.out.println("Territory");
                        String territory = scanner.nextLine();
                        office.setTerritory(territory);
                        System.out.println("Territory has been updated to: " + territory);


                }
                System.out.println("\nWould you like to update anything else?: Y/N");
                updateMore = scanner.next();
                while (!updateMore.equalsIgnoreCase("y") && !updateMore.equalsIgnoreCase("n") ) {
                    System.out.println("Would you like to update anything else?: ->Y/N<-");
                    updateMore = scanner.next();
                }
                if (updateMore.equalsIgnoreCase("n")){
                    done = true;
                }else done = false;




            }while (!done);

            officeDAO.updateOffices(office);


        }



    public void deleteAnOffice() {

    }

}
