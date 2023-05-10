package ru.netology.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Аэропорт1", "Аэропорт2", 30, 2, 5);
    Ticket ticket2 = new Ticket("Аэропорт1", "Аэропорт2", 100, 6, 8);
    Ticket ticket3 = new Ticket("Аэропорт1", "Аэропорт2", 40, 2, 6);
    Ticket ticket4 = new Ticket("Аэропорт1", "Аэропорт2", 100, 1, 6);
    Ticket ticket5 = new Ticket("Аэропорт1", "Аэропорт2", 70, 4, 8);
    Ticket ticket6 = new Ticket("Аэропорт2", "Аэропорт3", 100, 1, 6);
    Ticket ticket7 = new Ticket("Аэропорт4", "Аэропорт5", 70, 4, 8);

    @Test
    public void testAddOll() {
        AviaSouls soul = new AviaSouls();
        soul.add(ticket1);
        soul.add(ticket2);
        soul.add(ticket3);
        soul.add(ticket4);
        soul.add(ticket5);
        soul.add(ticket6);
        soul.add(ticket7);

        Ticket[] expected = {ticket1, ticket3, ticket5, ticket2, ticket4};
        Ticket[] actual = soul.search("Аэропорт1", "Аэропорт2");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddOne() {
        AviaSouls soul = new AviaSouls();
        soul.add(ticket1);
        soul.add(ticket2);
        soul.add(ticket3);
        soul.add(ticket4);
        soul.add(ticket5);
        soul.add(ticket6);
        soul.add(ticket7);

        Ticket[] expected = {ticket7};
        Ticket[] actual = soul.search("Аэропорт4", "Аэропорт5");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testAdNull() {
        AviaSouls soul = new AviaSouls();
        soul.add(ticket1);
        soul.add(ticket2);
        soul.add(ticket3);
        soul.add(ticket4);
        soul.add(ticket5);
        soul.add(ticket6);
        soul.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = soul.search("Аэропорт6", "Аэропорт7");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFlightTimeAll() {
        AviaSouls soul = new AviaSouls();
        soul.add(ticket1);
        soul.add(ticket2);
        soul.add(ticket3);
        soul.add(ticket4);
        soul.add(ticket5);
        soul.add(ticket6);
        soul.add(ticket7);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket1, ticket3,  ticket5,  ticket4};

        Ticket[] actual = soul.searchAndSortBy("Аэропорт1", "Аэропорт2", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFlightTimeOne() {
        AviaSouls soul = new AviaSouls();
        soul.add(ticket1);
        soul.add(ticket2);
        soul.add(ticket3);
        soul.add(ticket4);
        soul.add(ticket5);
        soul.add(ticket6);
        soul.add(ticket7);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6};

        Ticket[] actual = soul.searchAndSortBy("Аэропорт2", "Аэропорт3", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
        @Test
        public void testFlightTimeNull() {
            AviaSouls soul = new AviaSouls();
            soul.add(ticket1);
            soul.add(ticket2);
            soul.add(ticket3);
            soul.add(ticket4);
            soul.add(ticket5);
            soul.add(ticket6);
            soul.add(ticket7);
            TicketTimeComparator timeComparator = new TicketTimeComparator();

            Ticket[] expected = {};

            Ticket[] actual = soul.searchAndSortBy("Аэропорт6", "Аэропорт7", timeComparator);
            Assertions.assertArrayEquals(expected, actual);
        }

}