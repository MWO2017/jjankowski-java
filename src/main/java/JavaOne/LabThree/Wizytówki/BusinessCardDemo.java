package JavaOne.LabThree.Wizytówki;

public class BusinessCardDemo {
    public static void main(String[] args) {
       BusinessCard janekBusinessCard = new BusinessCard("Jan", "Jankowski");
        System.out.println(janekBusinessCard);

        BusinessCard romekBusinessCard = new BusinessCard("Roman", "Kowalki",123456789,
                "Kraków");
        System.out.println(romekBusinessCard);
        BusinessCard rafalBusinessCard = new BankAccountBusinessCard("Rafal", "Przybysz",
                13234453, "Kraków","1020 20003 0888888888883");
        System.out.println(rafalBusinessCard);

        BusinessCard piotrekBusinessCard = new BankAccountBusinessCard("Piotrek", "Przybysz",
                13234453,"New York");
        System.out.println(piotrekBusinessCard);


        System.out.println(romekBusinessCard.getCity().equals(rafalBusinessCard.getCity()));
        System.out.println(rafalBusinessCard.getCity()== (janekBusinessCard.getCity()));
        System.out.println(rafalBusinessCard);
    }
}
