package com.geekbrains.sem6;

import java.util.*;

/**
 * Хранение и обработка данных ч3: множество коллекций Set
 * <p>
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * <p>
 * -Создать множество ноутбуков.
 * -Написать метод, который будет запрашивать у пользователя критерий (или критерии)
 * фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
 * Например:
 * Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * -Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 * -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class cwLaptopStore {
    public static void main(String[] args) {
        boolean stop = true;
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> criteria = addCriteria();
        Set<Laptop> laptops = new HashSet<>(Arrays.asList(
                new Laptop("acer", "16", "16", "nvidea", "1024", "windows", "intel", "8"),
                new Laptop("asus", "19", "8", "amd", "512", "linux", "amd", "6"),
                new Laptop("apple", "17", "16", "apple", "512", "macOS", "apple", "10"),
                new Laptop("asus", "19", "4", "nvidea", "256", "windows", "amd", "4"),
                new Laptop("apple", "17", "16", "nvidea", "512", "macOS", "intel", "10")
        ));

        while (stop){
            System.out.print("Критерии для фильтрации ноутбука:\n" +
                    "1 - Производитель\n" +
                    "2 - Диагональ экрана (дюйм)\n" +
                    "3 - Объем оперативной памяти (ГБ)\n" +
                    "4 - Производитель дискретной видеокарты\n" +
                    "5 - Общий объем твердотельных накопителей (SSD) (ГБ)\n" +
                    "6 - Операционная система\n" +
                    "7 - Производитель процессора\n" +
                    "8 - Количество производительных ядер\n" +
                    "0 - Выход\n" +
                    "Введите цифру, соответствующую необходимому критерию:");

            String number = scanner.next();
            int num = 0;
            try {
                num = Integer.parseInt(number);
            } catch (Exception e) {
                System.out.println("Не верный ввод!");
            }

            if (num != 0) {
                System.out.print(criteria.get(num));
            } else {
                stop = false;
            }


            Map<String, Integer> filters = getFilters(num, laptops);
            System.out.println(filters.keySet());
            System.out.print("Введите критерий поиска: ");
            String filtered = scanner.next();
            int num1 = 0;
            try {
                num1 = filters.get(filtered);
            } catch (Exception e){
                System.out.println("Не верный ввод!");
                stop = false;
            }
            getFiltered(num1, filtered, laptops);
        }
        scanner.close();
    }

    private static void getFiltered(int num, String filter, Set<Laptop> laptops){

        if(num == 1) {
            for (Laptop laptop : laptops) {
                if(filter.equals(laptop.manufacturer)){
                    System.out.println(laptop);
                }
            }
        } else if (num == 2) {
            for (Laptop laptop : laptops) {
                if(filter.equals(laptop.screenDiagonalInch)){
                    System.out.println(laptop);
                }
            }
        }else if (num == 3) {
            for (Laptop laptop : laptops) {
                if(filter.equals(laptop.ramCapacityGb)){
                    System.out.println(laptop);
                }
            }
        }else if (num == 4) {
            for (Laptop laptop : laptops) {
                if(filter.equals(laptop.discreteGraphicsCardManufacturer)){
                    System.out.println(laptop);
                }
            }
        }else if (num == 5) {
            for (Laptop laptop : laptops) {
                if(filter.equals(laptop.totalSsdCapacityGb)){
                    System.out.println(laptop);
                }
            }
        }else if (num == 6) {
            for (Laptop laptop : laptops) {
                if(filter.equals(laptop.operatingSystem)){
                    System.out.println(laptop);
                }
            }
        }else if (num == 7) {
            for (Laptop laptop : laptops) {
                if(filter.equals(laptop.cpuManufacturer)){
                    System.out.println(laptop);
                }
            }
        }else {
            for (Laptop laptop : laptops) {
                if (filter.equals(laptop.numberOfProductiveCores)) {
                    System.out.println(laptop);
                }
            }
        }
    }
    private static HashMap<String, Integer> getFilters(int num, Set<Laptop> laptops) {
        HashMap<String, Integer> filters = new HashMap<>();

        if(num == 1) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.manufacturer, num);
            }
        } else if (num == 2) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.screenDiagonalInch, num);
            }
        }else if (num == 3) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.ramCapacityGb, num);
            }
        }else if (num == 4) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.discreteGraphicsCardManufacturer, num);
            }
        }else if (num == 5) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.totalSsdCapacityGb, num);
            }
        }else if (num == 6) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.operatingSystem, num);
            }
        }else if (num == 7) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.cpuManufacturer, num);
            }
        }else if (num == 8) {
            for (Laptop laptop : laptops) {
                filters.put(laptop.numberOfProductiveCores, num);
            }
        } else {
            System.out.println("Не верный ввод!");
        }
        return filters;
    }

    private static HashMap<Integer, String> addCriteria() {
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(1, "Производитель: ");
        hmap.put(2, "Диагональ экрана (дюйм): ");
        hmap.put(3, "Объем оперативной памяти (ГБ): ");
        hmap.put(4, "Производитель дискретной видеокарты: ");
        hmap.put(5, "Общий объем твердотельных накопителей (SSD) (ГБ): ");
        hmap.put(6, "Операционная система: ");
        hmap.put(7, "Производитель процессора: ");
        hmap.put(8, "Количество производительных ядер: " );
        return hmap;
    }
}

class Laptop {
    String manufacturer;
    String screenDiagonalInch;
    String ramCapacityGb;
    String discreteGraphicsCardManufacturer;
    String totalSsdCapacityGb;
    String operatingSystem;
    String cpuManufacturer;
    String numberOfProductiveCores;

    public Laptop(String manufacturer, String screenDiagonalInch, String ramCapacityGb,
                  String discreteGraphicsCardManufacturer, String totalSsdCapacityGb,
                  String operatingSystem, String cpuManufacturer, String numberOfProductiveCores) {
        this.manufacturer = manufacturer;
        this.screenDiagonalInch = screenDiagonalInch;
        this.ramCapacityGb = ramCapacityGb;
        this.discreteGraphicsCardManufacturer = discreteGraphicsCardManufacturer;
        this.totalSsdCapacityGb = totalSsdCapacityGb;
        this.operatingSystem = operatingSystem;
        this.cpuManufacturer = cpuManufacturer;
        this.numberOfProductiveCores = numberOfProductiveCores;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Производитель='" + manufacturer + '\'' + "\n" +
                " Диагональ экрана (дюйм)='" + screenDiagonalInch + '\'' + "\n" +
                " Объем оперативной памяти (ГБ)='" + ramCapacityGb + '\'' + "\n" +
                " Производитель дискретной видеокарты='" + discreteGraphicsCardManufacturer + '\'' + "\n" +
                " Общий объем твердотельных накопителей (SSD) (ГБ)='" + totalSsdCapacityGb + '\'' + "\n" +
                " Операционная система='" + operatingSystem + '\'' + "\n" +
                " Производитель процессора='" + cpuManufacturer + '\'' + "\n" +
                " Количество производительных ядер='" + numberOfProductiveCores + '\'' + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(manufacturer, laptop.manufacturer) &&
                Objects.equals(screenDiagonalInch, laptop.screenDiagonalInch) &&
                Objects.equals(ramCapacityGb, laptop.ramCapacityGb) &&
                Objects.equals(discreteGraphicsCardManufacturer, laptop.discreteGraphicsCardManufacturer) &&
                Objects.equals(totalSsdCapacityGb, laptop.totalSsdCapacityGb) &&
                Objects.equals(operatingSystem, laptop.operatingSystem) &&
                Objects.equals(cpuManufacturer, laptop.cpuManufacturer) &&
                Objects.equals(numberOfProductiveCores, laptop.numberOfProductiveCores);
    }
    @Override
    public int hashCode() {
        return 1;
    }
}