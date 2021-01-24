public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        LaptopModel Laptop1 = new LaptopModel("G14","Ryzen 9","16 GB","512 GB","RGB");

        LaptopModel Laptop2 = (LaptopModel) Laptop1.clone();
        LaptopModel Laptop3 = (LaptopModel) Laptop1.clone();

        Laptop2.setRam("24 GB");
        Laptop2.setHardDisk("1 TB");

        Laptop3.setProcessor("Ryzen 7");
        Laptop3.setRGB("NO RGB");

        System.out.println("Original prototype Laptop class: " + Laptop1);

        System.out.println("Cloned Laptop class 1: " + Laptop2);
        System.out.println("Cloned Laptop class 2: " + Laptop3);

    }


}
