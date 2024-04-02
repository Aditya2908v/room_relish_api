package com.example.room_relish_api.Service;

import com.example.room_relish_api.model.Hotel;
import com.example.room_relish_api.model.Room;
import com.example.room_relish_api.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> getHotel(String id) {
        return hotelRepository.findById(id);
    }

    @Override
    public void saveRoom(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getHotelsByCity(String cityName)
    {
        return hotelRepository.findByLocationCityNameIgnoreCase(cityName);
    }
}
