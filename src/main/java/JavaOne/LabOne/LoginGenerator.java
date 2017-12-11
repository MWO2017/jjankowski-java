package JavaOne.LabOne;

public class LoginGenerator {
    public static void main(String[] args) {

        String[] studentNames = { "Budynek Piotr",
                "Chalupa Krystyna",
                "Wiezowiec Jan",
                "Szkieletor Andrzej",
                "Domek Marianna" };

        String[] email = createEmailAddress(studentNames);
        printEmailAdresses(email);
    }

    public static String[] createEmailAddress(String[] studentNames){
        String[] emailAdresses = new String[studentNames.length];
        for (int i=0; i<studentNames.length; i++){
            String[] splitted = studentNames[i].split(" ");
            String studentEmailAdress = splitted[0].substring(0,3) + splitted[1].substring(0,2) +"@student.agh.edu.pl";

            emailAdresses[i]= studentEmailAdress.toLowerCase();
        }

        return emailAdresses;
    }

    public static void printEmailAdresses(String[] emailadresses){
        for (int i=0; i< emailadresses.length; i++){
            System.out.println(emailadresses[i]);
        }
    }


}

