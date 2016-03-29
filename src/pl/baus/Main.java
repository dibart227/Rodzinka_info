package pl.baus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contin = 0;
        do {
            int familyMembersSize = downloadFamilySize();
            String[] arrayName = new String[familyMembersSize];
            int[] arrayAge = new int[familyMembersSize];
            fillFamilyMembersDatabase(arrayName, arrayAge);
            printFamilyMembers(arrayName, arrayAge);
            printFamilyInfo(arrayAge, arrayName);
            System.out.println("Czy chcesz zakończyć program? 1.Tak 2.Nie");
            contin = scanner.nextInt();
        }while(contin >= 2);
        System.out.println("Do zobaczyska ;)");

    }

    private static void fillFamilyMembersDatabase(String[] arrayName, int[] arrayAge) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ok, w takim razie podaj mi pojedyńczo ich imiona i wiek.");
        //uzupełnienie tablicy arrayName i arrayAge
        for (int i = 0; i < arrayName.length; i++) {
            System.out.print(String.format("Osoba %d ma na imię: ", i+1 ));
            arrayName[i] = scanner.next();
            System.out.print("Ile ma lat? ");
            arrayAge[i] = scanner.nextInt();
        }
    }

    private static int downloadFamilySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ilu masz członków rodziny? ");
        int familyMembersSize = 0;
        do {
            familyMembersSize = scanner.nextInt();
            if(familyMembersSize <= 0){
                System.out.println("Rodzina ma liczy więcej osób niż 0!!!");
            }
        }while(familyMembersSize <= 0);
        return familyMembersSize;
    }

    //Wyświetlenie informacji o najstarszej osobie w rodzinie, ew. ile jest D wiekowych w rodzinie
    private static void printFamilyInfo(int[] arrayAge, String[] arrayName){
        int[] arrayMaxAge = new int[3];
        for (int i = 0; i < arrayMaxAge.length; i++) {
            arrayMaxAge[i] = MaxAge(arrayAge)[i];
        }

        if(arrayMaxAge[2] == 1) {
            System.out.println(String.format("Najstarszą osoba w naszej rodzinie jest %s ma on/ona %d lat.", arrayName[arrayMaxAge[1]], arrayAge[arrayMaxAge[1]]));
        } else if (arrayMaxAge[2] > 1){
            System.out.println(String.format("Dominat wieku w naszej rodzinie jest %d.", arrayMaxAge[2]));
        } else {
            System.out.println("Przykro nam, ale baza danych członków rodziny jest niekompletna.");
        }

    }

    //Szykanie najstarszej osoby w rodzinie
    //arrayMaxAge[]{Największa wartość wieku, miejsce najstarszej osoby w tablicy, ilość D w rodzinie
    private static int[] MaxAge(int[] arrayAge) {
        int[] arrayMaxAge = new int[3];
        for (int i = 0; i < arrayAge.length; i++) {
            if(arrayMaxAge[0] < arrayAge[i]) {
                arrayMaxAge[0] = arrayAge[i];
                arrayMaxAge[1] = i;
            }
        }
        for (int i = 0; i < arrayAge.length; i++) {
            if(arrayAge[i] == arrayMaxAge[0]){
                arrayMaxAge[2]++;
            }
        }
        return arrayMaxAge;
    }
    // Metoda printFamilyMembers wyświetla informacje wszystkich członków rodziny w sposób uporządkowany
    private static void printFamilyMembers(String[] arrayName, int[] arrayAge) {
        if(arrayAge.length == arrayName.length) {
            for (int i = 0; i < arrayName.length; i++) {
                System.out.println(String.format("%s ma %d lat.", arrayName[i], arrayAge[i]));
            }
        } else {
            System.out.println("Przykro nam, ale baza danych członków rodziny jest niekompletna.");
        }
    }
}
