package com.sudin.foodCourt.foodcourtapp.Repository;

import com.sudin.foodCourt.foodcourtapp.Entity.Entry;
import com.sudin.foodCourt.foodcourtapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry,Integer> {
Entry findByUsers(Users users);
}
