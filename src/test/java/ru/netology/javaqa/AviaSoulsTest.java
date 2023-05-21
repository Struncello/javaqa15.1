package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void sortingTickets() {
        AviaSouls sorting = new AviaSouls();
        Ticket ticket1 = new Ticket("LA", "NY", 300, 9, 15);
        Ticket ticket2 = new Ticket("LA", "NY", 400, 10, 14);
        Ticket ticket3 = new Ticket("LA", "NY", 100, 11, 15);
        Ticket ticket4 = new Ticket("LA", "NY", 300, 8, 10);
        Ticket ticket5 = new Ticket("LA", "NY", 500, 13, 14);
        Ticket ticket6 = new Ticket("SPB", "Minsk", 700, 9, 15);
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);
        sorting.add(ticket6);

        Ticket[] expected = {ticket3, ticket1, ticket4, ticket2, ticket5};
        Ticket[] actual = sorting.search("LA", "NY");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortingTicketsIfOne() {
        AviaSouls sorting = new AviaSouls();
        Ticket ticket1 = new Ticket("LA", "NY", 300, 9, 15);
        Ticket ticket2 = new Ticket("LA", "NY", 400, 10, 14);
        Ticket ticket3 = new Ticket("LA", "NY", 100, 11, 15);
        Ticket ticket4 = new Ticket("LA", "NY", 300, 8, 10);
        Ticket ticket5 = new Ticket("LA", "NY", 500, 13, 14);
        Ticket ticket6 = new Ticket("SPB", "Minsk", 700, 9, 15);
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);
        sorting.add(ticket6);

        Ticket[] expected = {ticket6};
        Ticket[] actual = sorting.search("SPB", "Minsk");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortingTicketsIfNone() {
        AviaSouls sorting = new AviaSouls();
        Ticket ticket1 = new Ticket("LA", "NY", 300, 9, 15);
        Ticket ticket2 = new Ticket("LA", "NY", 400, 10, 14);
        Ticket ticket3 = new Ticket("LA", "NY", 100, 11, 15);
        Ticket ticket4 = new Ticket("LA", "NY", 300, 8, 10);
        Ticket ticket5 = new Ticket("LA", "NY", 500, 13, 14);
        Ticket ticket6 = new Ticket("SPB", "Minsk", 700, 9, 15);
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);
        sorting.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = sorting.search("NY", "Minsk");

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void sortingTicketsComparator() {
        AviaSouls sorting = new AviaSouls();
        Ticket ticket1 = new Ticket("LA", "NY", 300, 9, 15); //6
        Ticket ticket2 = new Ticket("LA", "NY", 400, 10, 14); //4
        Ticket ticket3 = new Ticket("LA", "NY", 100, 11, 15); //4
        Ticket ticket4 = new Ticket("LA", "NY", 300, 8, 10); //2
        Ticket ticket5 = new Ticket("LA", "NY", 500, 13, 14); //1
        Ticket ticket6 = new Ticket("SPB", "Minsk", 700, 9, 15);
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);
        sorting.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket4, ticket2, ticket3, ticket1};
        Ticket[] actual = sorting.searchAndSortBy("LA", "NY", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortingTicketsComparatorIfOne() {
        AviaSouls sorting = new AviaSouls();
        Ticket ticket1 = new Ticket("LA", "NY", 300, 9, 15); //6
        Ticket ticket2 = new Ticket("LA", "NY", 400, 10, 14); //4
        Ticket ticket3 = new Ticket("LA", "NY", 100, 11, 15); //4
        Ticket ticket4 = new Ticket("LA", "NY", 300, 8, 10); //2
        Ticket ticket5 = new Ticket("LA", "NY", 500, 13, 14); //1
        Ticket ticket6 = new Ticket("SPB", "Minsk", 700, 9, 15);
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);
        sorting.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6};
        Ticket[] actual = sorting.searchAndSortBy("SPB", "Minsk", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortingTicketsComparatorIfNone() {
        AviaSouls sorting = new AviaSouls();
        Ticket ticket1 = new Ticket("LA", "NY", 300, 9, 15); //6
        Ticket ticket2 = new Ticket("LA", "NY", 400, 10, 14); //4
        Ticket ticket3 = new Ticket("LA", "NY", 100, 11, 15); //4
        Ticket ticket4 = new Ticket("LA", "NY", 300, 8, 10); //2
        Ticket ticket5 = new Ticket("LA", "NY", 500, 13, 14); //1
        Ticket ticket6 = new Ticket("SPB", "Minsk", 700, 9, 15);
        sorting.add(ticket1);
        sorting.add(ticket2);
        sorting.add(ticket3);
        sorting.add(ticket4);
        sorting.add(ticket5);
        sorting.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = sorting.searchAndSortBy("LA", "Minsk", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

}