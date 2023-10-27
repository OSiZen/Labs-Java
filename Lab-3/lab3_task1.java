public class lab3_task1 {
    public static void main(String[] args) {
        House[] houses = {
            new House(1, 1, 48.4, 1, 3, "Лесi Українки 9", 1, 2075),
            new House(1, 2, 50, 1, 3, "Лесi Українки 9", 1, 2075),
            new House(1, 3, 39.3, 1, 2, "Лесi Українки 9", 1, 2075),
            new House(1, 4, 40.1, 2, 2, "Лесi Українки 9", 1, 2075),
            new House(1, 5, 58, 2, 4, "Лесi Українки 9", 1, 2075),
            new House(1, 6, 46.79, 2, 3, "Лесi Українки 9", 1, 2075),
            new House(2, 1, 47.1, 1, 3, "Подiльська 25", 2, 2061),
            new House(2, 2, 44.83, 1, 3, "Подiльська 25", 2, 2061),
            new House(2, 3, 46.7, 1, 3, "Подiльська 25", 2, 2061),
            new House(3, 12, 49.97, 5, 4, "Соборна 15", 3, 2120),
            new House(3, 14, 57, 5, 4, "Соборна 15", 3, 2120),
            new House(3, 16, 58.12, 5, 4, "Соборна 15", 3, 2120),
        };

        House.filterQuantityRooms(houses, 2);
        House.filterRoomsFloors(houses, 3, 5, 4);
        House.filterRoomAreas(houses, 50);
    }
}

class House {
    private int id;
    private int roomNum;
    private double area;
    private int floor;
    private int qtyRooms;
    private String street;
    private int typeHouse;
    private int termUse;

    public House(int id, int roomNum, double area, int floor, int qtyRooms, String street, int typeHouse, int termUse) {
        this.id = id;
        this.roomNum = roomNum;
        this.area = area;
        this.floor = floor;
        this.qtyRooms = qtyRooms;
        this.street = street;
        this.typeHouse = typeHouse;
        this.termUse = termUse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getQtyRooms() {
        return qtyRooms;
    }

    public void setQtyRooms(int qtyRooms) {
        this.qtyRooms = qtyRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getTypeHouse() {
        return typeHouse;
    }

    public void setTypeHouse(int typeHouse) {
        this.typeHouse = typeHouse;
    }

    public int getTermUse() {
        return termUse;
    }

    public void setTermUse(int termUse) {
        this.termUse = termUse;
    }

    @Override
    public String toString() {
        String type = (typeHouse == 1) ? "5-ти поверхiвка" : ((typeHouse > 2) ? "бiльше 9-ти поверхiв" : "9-ти поверхiвка");
        return "Будинок (id) " + id + ", квартира №: " + roomNum + ", площа: " + area + ", поверх №: " + floor + ", к-сть кiмнат: " + qtyRooms + ", вул. " + street + ", тип будiвлi: " + type + ", термiн експлуатацiї до: " + termUse;
    }

    public static void filterQuantityRooms(House[] houses, int qtyRooms) {
        System.out.println("\nСписок квартир з " + qtyRooms + " кiмнатами:");
        for (House h : houses) {
            if (h.getQtyRooms() == qtyRooms) {
                System.out.println(h);
            }
        }
    }

    public static void filterRoomsFloors(House[] houses, int minFloor, int maxFloor, int qtyRooms) {
        System.out.println("\nСписок квартир з " + qtyRooms + " кiмнатами на поверхах вiд " + minFloor + " до " + maxFloor + ":");
        for (House h : houses) {
            if (h.getQtyRooms() == qtyRooms && h.getFloor() >= minFloor && h.getFloor() <= maxFloor) {
                System.out.println(h);
            }
        }
    }

    public static void filterRoomAreas(House[] houses, double minArea) {
        System.out.println("\nСписок квартир з площею бiльше " + minArea + ":");
        for (House h : houses) {
            if (h.getArea() > minArea) {
                System.out.println(h);
            }
        }
    }
}