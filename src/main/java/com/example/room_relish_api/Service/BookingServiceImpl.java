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

import java.awt.print.Book;
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
    public Payment bookRoom(Payment payment) {
        Optional<Hotel> optionalHotel = hotelService.getHotel(payment.get_hotelId());
        if(optionalHotel.isPresent()){
            Hotel hotel = optionalHotel.get();
            List<Room> availableRooms = hotel.getAvailableRooms();
            //find and book the requested room
            float totalPrice = 0.0f;
            float gst = 0.0f;
            Optional<Room> optionalRoom = availableRooms.stream()
                    .filter(p -> p.getId().equals(payment.get_roomId()))
                    .filter(p -> p.getRoomCount() > payment.getNumOfRooms()).findFirst();
            if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();
            totalPrice=payment.getNumOfRooms()*room.getRoomRate()*payment.getNumOfDays();
            gst=(totalPrice*12)/100;
            totalPrice=gst+totalPrice;
            room.setRoomCount(room.getRoomCount()-payment.getNumOfRooms());
            hotelService.saveRoom(hotel);
            payment.setGstOfTotalAmount(gst);
            payment.setTotalAmount(totalPrice);
            paymentRepository.save(payment);
            }
            else{
                throw new NullPointerException("Requested room or requested number of rooms is not available");
            }
        }
        return payment;
    }
    public Booking payRoom(Payment payment){
        Booking booking = new Booking(payment.get_hotelId(),payment.get_userId(),payment.get_roomId(),payment.getId(),payment.getNumOfRooms(),payment.getNumOfDays(),true);
        bookingRepository.save(booking);
        return booking;
    }
}
