package com.sudin.foodCourt.foodcourtapp.Controller;

import com.sudin.foodCourt.foodcourtapp.Entity.Dinner;
import com.sudin.foodCourt.foodcourtapp.Entity.Entry;
import com.sudin.foodCourt.foodcourtapp.Entity.Lunch;
import com.sudin.foodCourt.foodcourtapp.Entity.Users;
import com.sudin.foodCourt.foodcourtapp.Repository.DinnerRepository;
import com.sudin.foodCourt.foodcourtapp.Repository.EntryRepository;
import com.sudin.foodCourt.foodcourtapp.Repository.LunchRepository;
import com.sudin.foodCourt.foodcourtapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EntryController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private LunchRepository lunchRepository;

    @Autowired
    private DinnerRepository dinnerRepository;

    @GetMapping(value = "/users/entry")
    public String viewUsersEntry(Model model) {
        return "entryform";
    }

    @PostMapping(value = "/save/entry")
    public String saveEntry(@RequestParam("userid") long userid, RedirectAttributes redirectAttributes) {
        String success = "";
        String error = "";
        Users user = userRepository.findById(userid);

        if (user != null) {
            Entry checkEntry = entryRepository.findByUsers(user);
            if (checkEntry == null) {

                Entry entry = new Entry(user);
                entryRepository.save(entry);
                success = "Entry of " +user.getFirstName()+ " " +user.getLastName()+" successful";
                redirectAttributes.addFlashAttribute("success", success);
            } else {
                error = "Entry of " +user.getFirstName()+ " " +user.getLastName()+" already done";
                redirectAttributes.addFlashAttribute("error", error);
            }
        } else {
            System.out.println("no user found");
            error = "User not registered";
            redirectAttributes.addFlashAttribute("error", error);
        }


        return "redirect:/users/entry";
    }

    @GetMapping(value = "users/lunch")
    public String viewUsersLunch(Model model) {

        return "lunchform";
    }

    @PostMapping(value = "/save/lunch")
    public String saveLunch(@RequestParam("userid") long userid, RedirectAttributes redirectAttributes) {
        String success = "";
        String error = "";
        Users user = userRepository.findById(userid);
        Entry entry = entryRepository.findByUsers(user);
        if (user != null) {
            Lunch checkLunch = lunchRepository.findByUsers(user);
            if (checkLunch == null) {
                if (entry != null) {
                    Lunch lunch = new Lunch(user);
                    lunchRepository.save(lunch);
                    success = "Lunch of " +user.getFirstName()+ " " +user.getLastName()+" successful";
                    redirectAttributes.addFlashAttribute("success", success);
                } else {
                    System.out.println("entry not completed");
                    redirectAttributes.addFlashAttribute("error", "Entry of " +user.getFirstName()+ " " +user.getLastName()+ " not done yet");
                }
            } else {
                error = user.getFirstName()+ " " +user.getLastName()+ "has already taken Lunch";
                redirectAttributes.addFlashAttribute("error", error);
            }
        } else {
            System.out.println("no user found");
            error = "User not registered";
            redirectAttributes.addFlashAttribute("error", error);
        }

        return "redirect:/users/lunch";
    }

    @GetMapping(value = "users/dinner")
    public String viewUsersDinner(Model model) {

        return "dinnerform";
    }

    @PostMapping(value = "/save/dinner")
    public String saveDinner(@RequestParam("userid") long userid, RedirectAttributes redirectAttributes) {
        String success = "";
        String error = "";
        Users user = userRepository.findById(userid);
        Entry entry = entryRepository.findByUsers(user);
        if (user != null) {
            Dinner checkDinner = dinnerRepository.findByUsers(user);
            if (checkDinner == null) {
                if (entry != null) {
                    Dinner dinner = new Dinner(user);
                    dinnerRepository.save(dinner);
                    success = "Dinner of " +user.getFirstName()+ " " +user.getLastName()+" successful";
                    redirectAttributes.addFlashAttribute("success", success);
                } else {
                    redirectAttributes.addFlashAttribute("error", "Entry of " +user.getFirstName()+ " " +user.getLastName()+ " not done yet");
                }
            } else {
                error = user.getFirstName()+ " " +user.getLastName()+ " has already taken Dinner";
                redirectAttributes.addFlashAttribute("error", error);
            }
        } else {
            System.out.println("no user found");
            error = "User isn't registered";
            redirectAttributes.addFlashAttribute("error", error);
        }

        return "redirect:/users/dinner";
    }
}
