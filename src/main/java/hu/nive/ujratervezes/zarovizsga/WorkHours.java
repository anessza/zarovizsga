package hu.nive.ujratervezes.zarovizsga;
/*
A WorkHours osztályban implementáld a String minWork(String file) metódust!
A metódus paraméterként megkapja egy fájl elérési útvonalát. A tesztesetben
ez a src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt,
így ebbe a könyvtárba tedd a fájlt!

A fájl formátuma:

John Doe,8,2021-01-01
Jack Doe,7,2021-01-02
Jack Doe,8,2021-01-03
John Doe,2,2021-01-04
John Doe,8,2021-01-05
John Doe,7,2021-01-06

A dolgozó neve, mennyi órát dolgozott egy nap, és a nap. Azt kell visszaadni, hogy ki
melyik nap dolgozott a legkevesebbet. A fenti fájl alapján John Doe 2021-01-04-én csak
2 órát dolgozott, így a következő Stringet kell visszaadni: John Doe: 2021-01-04.
Egy napra, egy alkalmazotthoz mindig csak egy sor van.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


class WorkHours{

    public String[] splitStringForList (String line){

        String[] works = new String[3];

        int i = line.indexOf(",");
        int j = line.indexOf(",", i+1);
        /*int k = line.indexOf(",", j);*/

        String name = line.substring(0, i);
        String hours = line.substring(i+1, j);
        String day = line.substring(j+1);

        works[0] = name;
        works[1] = hours;
        works[2] = day;

        return works;
    }


    public String minWork(String file) {

        Path path = Path.of(file);

        try (BufferedReader br = Files.newBufferedReader(path)) {

            String line;

            List<String[]> workHours = new ArrayList<>();

            while ((line = br.readLine()) != null)
            {
                workHours.add(splitStringForList(line));
            }

            int minHours = 12;
            String[] minWorkerDay = new String[3];

            for (String[] item : workHours ){
                if (Integer.parseInt(item[1]) < minHours) {
                    minHours = Integer.parseInt(item[1]);
                    minWorkerDay = item;
                }

            }
            String resolve = minWorkerDay[0].toString() + ": " + minWorkerDay[2].toString();

            return resolve;
        }
        catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

}
