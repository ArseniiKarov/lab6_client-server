package data.generators;

import data.*;
import manager.Validator;

import java.util.Scanner;

public class WorkerGenerator {
    /**
     * Метод для генерации работника с вводом данных с клавиатуры
     * @param id id
     * @return работник
     */
    public static Worker createWorker(Long id) {
        System.out.println("Генерация");
        Scanner scanner = new Scanner(System.in);

        Address address = new Address();
        Organization org = new Organization();
        Coordinates coords = new Coordinates();

        Worker worker = (id == 0) ? new Worker() : new Worker(id);

        // worker name
        while (true) {
            try {
                System.out.println("Введите имя:");
                String input = scanner.nextLine();
                worker.setName(input);
                if (!input.isEmpty()) {
                    break;
                } else {
                    System.out.println("имя не может быть пустым");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // coord x
        while (true) {
            try {
                System.out.println("Введите координату x : ");
                long x = Long.parseLong(scanner.nextLine());
                coords.setX(x);
                break;
            } catch (Exception e) {
                System.out.println("необходимо ввести число");
            }
        }

        // coord y
        while (true) {
            try {
                System.out.println("Введите координату y (максимальное значение 581): ");
                long y = Long.parseLong(scanner.nextLine());
                if (y <= 581) {
                    coords.setY(y);
                    break;
                } else {
                    System.out.println("слишком большое значение");
                }
            } catch (Exception e) {
                System.out.println("необходимо ввести число");
            }
        }
        worker.setCoordinates(coords);

        while (true) {
            try {
                System.out.println("Введите зарплату сотрудника:");
                float salary = Float.parseFloat(scanner.nextLine());
                if (salary > 0) {
                    worker.setSalary(salary);
                    break;
                } else {
                    System.out.println("зарплата не может быть отрицательной или 0");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // worker pos
        while (true) {
            try {
                System.out.println("Введите позицию: DIRECTOR | HUMAN_RESOURCES | BAKER");
                String input = scanner.nextLine();
                if (Validator.isInt(input)) {
                    int index = Integer.parseInt(input);
                    Position position = switch (index) {
                        case 1 -> Position.DIRECTOR;
                        case 2 -> Position.HUMAN_RESOURCES;
                        case 3 -> Position.BAKER;
                        default -> null;
                    };
                    if (position == null) {
                        System.out.println("слишком большое значение");
                    } else {
                        worker.setPosition(position);
                        break;
                    }
                } else {
                    input = input.toUpperCase();
                    worker.setPosition(Position.valueOf(input));
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // org
        while (true) {
            try {
                System.out.println("Введите имя организации:");
                String fullname = scanner.nextLine();
                if (!fullname.isEmpty()) {
                    org.setFullName(fullname);
                    break;
                } else {
                    System.out.println("имя не может быть пустым");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите количество работников:");
                int employeesCount = Integer.parseInt(scanner.nextLine());
                if (employeesCount > 0) {
                    org.setEmployeesCount(employeesCount);
                    break;
                } else {
                    System.out.println("количество работников не может быть отрицательным или 0");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите тип организации: COMMERCIAL, GOVERNMENT, TRUST, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY");
                String input = scanner.nextLine();

                if (Validator.isInt(input)) {
                    int index = Integer.parseInt(input);
                    OrganizationType organizationType = switch (index) {
                        case 1 -> OrganizationType.COMMERCIAL;
                        case 2 -> OrganizationType.GOVERNMENT;
                        case 3 -> OrganizationType.TRUST;
                        case 4 -> OrganizationType.PRIVATE_LIMITED_COMPANY;
                        case 5 -> OrganizationType.OPEN_JOINT_STOCK_COMPANY;
                        default -> null;
                    };
                    if (organizationType == null) {
                        System.out.println("введите цифру или значение типа организации");
                    } else {
                        org.setType(organizationType);
                        break;
                    }
                } else {
                    OrganizationType type = OrganizationType.valueOf(input.toUpperCase());
                    org.setType(type);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите улицу:");
                String street = scanner.nextLine();
                if (!street.isEmpty()) {
                    address.setStreet(street);
                    break;
                } else {
                    System.out.println("улица не может быть пустой");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите почтовый индекс:");
                String zipCode = scanner.nextLine();
                if (zipCode.length() >= 7) {
                    address.setZipCode(zipCode);
                    break;
                } else {
                    System.out.println("почтовый индекс должен быть не меньше 7 символов");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Location town = new Location();

        while (true) {
            try {
                System.out.println("Введите координату x для локации:");
                double locX = Double.parseDouble(scanner.nextLine().strip());
                town.setX(locX);
                break;
            } catch (Exception e) {
                System.out.println("необходимо ввести число");
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату y для локации:");
                float locY = Float.parseFloat(scanner.nextLine().strip());
                town.setY(locY);
                break;
            } catch (Exception e) {
                System.out.println("необходимо ввести число");
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату z для локации:");
                float locZ = Float.parseFloat(scanner.nextLine().strip());
                town.setZ(locZ);
                break;
            } catch (Exception e) {
                System.out.println("необходимо ввести число");
            }
        }

        address.setTown(town);
        org.setOfficialAddress(address);
        worker.setOrganization(org);
        worker.setCoordinates(coords);
        System.out.println("Генерация закончена");

        return worker;
    }


    /**
     * Метод для создания работника из массива данных
     * @param data массив данных
     * @return работник
     */
    public static Worker createWorkerFromData(String[] data) {
        Worker worker = new Worker();
        try {
            worker.setName(data[0]);

            Coordinates coords = new Coordinates();
            coords.setX(Long.parseLong(data[1]));
            coords.setY(Long.parseLong(data[2]));
            worker.setCoordinates(coords);

            worker.setSalary(Float.parseFloat(data[3]));
            worker.setPosition(Position.valueOf(data[4].toUpperCase()));

            Organization org = new Organization();
            org.setFullName(data[5]);
            org.setEmployeesCount(Integer.parseInt(data[6]));
            org.setType(OrganizationType.valueOf(data[7].toUpperCase()));

            Address address = new Address();
            address.setStreet(data[8]);
            address.setZipCode(data[9]);

            Location town = new Location();
            town.setX(Double.parseDouble(data[10]));
            town.setY(Float.parseFloat(data[11]));
            town.setZ(Float.parseFloat(data[12]));
            address.setTown(town);

            org.setOfficialAddress(address);
            worker.setOrganization(org);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка при обработке данных для создания Worker: " + e.getMessage());
        }
        return worker;
    }
}