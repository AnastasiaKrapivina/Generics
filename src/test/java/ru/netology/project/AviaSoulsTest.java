package ru.netology.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Аэропорт1", "Аэропорт2", 30, 2, 5);
    Ticket ticket2 = new Ticket("Аэропорт1", "Аэропорт2", 80, 6, 8);
    Ticket ticket3 = new Ticket("Аэропорт1", "Аэропорт2", 40, 2, 6);
    Ticket ticket4 = new Ticket("Аэропорт1", "Аэропорт2", 100, 1, 6);
    Ticket ticket5 = new Ticket("Аэропорт1", "Аэропорт2", 70, 4, 8);

    @Test
    public void testAdd() {
        AviaSouls soul = new AviaSouls();
        soul.add(ticket1);
        soul.add(ticket2);
        soul.add(ticket3);
        soul.add(ticket4);
        soul.add(ticket5);

        Ticket[] expected = {ticket1, ticket3, ticket5, ticket2, ticket4};
        Ticket[] actual = soul.search("Аэропорт1", "Аэропорт2");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFlightTime() {
        AviaSouls soul = new AviaSouls();
        soul.add(ticket1);
        soul.add(ticket2);
        soul.add(ticket3);
        soul.add(ticket4);
        soul.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket1, ticket3,  ticket5,  ticket4};

        Ticket[] actual = soul.searchAndSortBy("Аэропорт1", "Аэропорт2", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}