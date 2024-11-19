package com.example.booking_service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper mapper;

    public BookingService(BookingRepository bookingRepository, BookingMapper mapper) {
        this.bookingRepository = bookingRepository;
        this.mapper = mapper;
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = mapper.toBooking(bookingDTO);
        Booking savedBooking = bookingRepository.save(booking);
        return mapper.toBookingDTO(savedBooking);
    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(mapper::toBookingDTO)
                .toList();
    }

    public BookingDTO getBookingById(UUID id) {
        return bookingRepository.findById(id)
                .map(mapper::toBookingDTO)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
