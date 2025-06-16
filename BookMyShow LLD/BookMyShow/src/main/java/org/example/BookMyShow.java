package org.example;

import org.example.Services.BookingService;

/**
 * Hello world!
 *
 */
public class BookMyShow
{
    public static void main( String[] args )
    {
        BookingService bookingService = BookingService.getInstance();
        bookingService.initialize();
        bookingService.startBookingSession();
        bookingService.startBookingSession();
    }
}
