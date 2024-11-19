package com.example.booking_service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    Booking toBooking(BookingDTO bookingDTO);
    BookingDTO toBookingDTO(Booking booking);
}
