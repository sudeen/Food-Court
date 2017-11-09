package com.sudin.foodCourt.foodcourtapp.Repository;

import com.sudin.foodCourt.foodcourtapp.Entity.Lunch;
import com.sudin.foodCourt.foodcourtapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LunchRepository extends JpaRepository<Lunch,Integer> {
    Lunch findByUsers(Users users);
}
