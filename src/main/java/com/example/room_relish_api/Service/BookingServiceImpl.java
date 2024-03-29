package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.Booking;
import com.example.room_relish_api.model.Hotel;
import com.example.room_relish_api.model.Payment;
import com.example.room_relish_api.model.Room;
import com.example.room_relish_api.repository.BookingRepository;
import com.example.room_relish_api.repository.PaymentRepository;
import com.example.room_relish_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    private final HotelService hotelService;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public BookingServiceImpl(HotelService hotelService, BookingRepository bookingRepository, PaymentRepository paymentRepository) {
        this.hotelService = hotelService;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking bookRoom(Booking booking) {
        Optional<Hotel> optionalHotel = hotelService.getHotel(booking.get_hotelId());
        if(optionalHotel.isPresent()){
            Hotel hotel = optionalHotel.get();
            List<Room> availableRooms = hotel.getAvailableRooms();

            //find and book the requested room
            float totalPrice = 0.0f;
            for(Room room : availableRooms) {
                if (room.getId().equals(booking.get_roomId())) {
                    if (booking.getNumOfRooms() > room.getRoomCount()) {
                        throw new IllegalArgumentException("requested number of rooms are not available");
                    } else {
                        totalPrice += booking.getNumOfRooms() * room.getRoomRate();
                        room.setRoomCount(room.getRoomCount() - booking.getNumOfRooms());
                        hotelService.saveRoom(hotel);
                        bookingRepository.save(booking);
                    }
                    Payment payment = new Payment(booking.get_userId(), booking.get_hotelId(), totalPrice);
                    paymentRepository.save(payment);

                }
            }
        }
        return booking;
    }

}
