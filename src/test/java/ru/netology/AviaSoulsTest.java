package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Сочи", 16_877, 7, 11);
    Ticket ticket2 = new Ticket("Сочи","Москва", 10_775, 14, 18 );
    Ticket ticket3 = new Ticket("Сочи", "Калининград", 18_100, 19, 16);
    Ticket ticket4 = new Ticket("Сочи", "Минск", 11_645, 15, 1);
    Ticket ticket5 = new Ticket("Казань", "Минск", 10_775, 22, 21);
    Ticket ticket6 = new Ticket("Казань", "Москва", 7_945, 7, 9 );
    Ticket ticket7 = new Ticket("Сочи", "Минск", 12_589, 10, 22);
    Ticket ticket8 = new Ticket("Сочи", "Минск", 10_600, 2, 13);
    Ticket ticket9 = new Ticket("Сочи", "Минск",  13_654, 9, 17);
    AviaSouls manager = new AviaSouls();

    @Test
    public void compareIfThePriceOfTheFirstHigherThanTheSecond(){
        manager.add(ticket1);
        manager.add(ticket2);


        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareIfThePriceOfTheFirstIsLessThanTheSecond(){
        manager.add(ticket2);
        manager.add(ticket3);


        int expected = -1;
        int actual = ticket2.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareIfThePriceOfTheFirstAndSecondAreEqual(){
        manager.add(ticket2);
        manager.add(ticket5);


        int expected = 0;
        int actual = ticket2.compareTo(ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchingForTicketFromPointToPoint(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

       Ticket[] expected = {ticket6};
       Ticket[] actual = manager.search("Казань",  "Москва");
    }

    @Test
    public void searchForTicketIfThereIsNoSuchOption(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Владивосток",  "Москва");
    }
    @Test
    public void searchForTicketSortedByPrice(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket8, ticket4, ticket7, ticket9};
        Ticket[] actual = manager.search("Сочи", "Минск");
    }
    @Test
    public void compareByFlightTime(){
        Comparator<Ticket>comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket9,ticket4, ticket8, ticket7};
        Ticket[] actual  = manager.searchAndSortBy("Сочи", "Минск", comparator);
    }

}
