package com.sudin.foodCourt.foodcourtapp.Repository;

import com.sudin.foodCourt.foodcourtapp.Entity.Dinner;
import com.sudin.foodCourt.foodcourtapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinnerRepository extends JpaRepository<Dinner,Integer> {
    Dinner findByUsers(Users users);
}
