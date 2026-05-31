package com.salon.repository;

import com.salon.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalonRepository extends JpaRepository<Salon, Long> {

    Salon getSalonByOwerId(Long ownerId);

    @Query("SELECT s FROM Salon s WHERE " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.address) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.city) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.phoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Salon> searchSalon(@Param("keyword") String keyword);


    @Query(
            "SELECT s FROM Salon s WHERE " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%')) AND " +
            "LOWER(s.city) LIKE LOWER(CONCAT('%', :city, '%'))"
    )
    List<Salon>  searchByCityAndName(@Param("city") String city,
                                     @Param("name") String name);

    @Query("SELECT s FROM Salon s WHERE " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%')) AND " +
            "LOWER(s.city) LIKE LOWER(CONCAT('%', :city, '%')) AND " +
            "LOWER(s.address) LIKE LOWER(CONCAT('%', :address, '%'))")
    List<Salon> searchByCityAndNameAndAddress(@Param("city") String city,
                                              @Param("name") String name,
                                              @Param("address") String address);

}
