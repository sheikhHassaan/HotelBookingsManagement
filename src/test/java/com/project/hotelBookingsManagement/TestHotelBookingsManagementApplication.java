package com.project.hotelBookingsManagement;

import org.springframework.boot.SpringApplication;

public class TestHotelBookingsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.from(HotelBookingsManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
