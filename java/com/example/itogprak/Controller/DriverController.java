package com.example.itogprak.Controller;


import com.example.itogprak.Model.Driver;
import com.example.itogprak.Repositories.CustomerRepositoryDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/driver")
public class DriverController {


    private CustomerRepositoryDriver customerRepository;
  //  private CustomerRepositoryFM customerRepositoryFM;

    @Autowired
    public DriverController(CustomerRepositoryDriver customerRepository) {
        this.customerRepository = customerRepository;
    }



    @GetMapping()
    public String index(Model model){
        model.addAttribute("driver", customerRepository.findAll());
        return "DriverIndex";
    }


    //
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        Driver driver = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("driver", driver);
        return "DriverShow";
    }

    @GetMapping("/new")
    public String newDriver(Model model){
        model.addAttribute("driver", new Driver());
        return "DriverNew";
    }


    @PostMapping
    public String create(@Valid Driver driver, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "DriverNew";
        }
        customerRepository.save(driver);
        model.addAttribute("driver", customerRepository.findAll());
        return "redirect:/driver";
    }
//    @GetMapping("/{id}/edit")
//    public String edit(Model model,@PathVariable("id")int id){
//        model.addAttribute("animal", _animalDAO.show(id));
//        return "edit";
//    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model){
        Driver driver = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("driver", driver);
        return "DriverEdit";
    }

//    @PostMapping("/{id}/edit")
//    public String update(@ModelAttribute("animal")Animal animal, @PathVariable("id")int id){
//        _animalDAO.update(id, animal);
//        return "redirect:/animal";
//    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable("id") long id, @Valid Driver driver, BindingResult result, Model model){
        if (result.hasErrors()) {
            driver.setId(id);
            return "/{id}/edit";
        }

        customerRepository.save(driver);
        model.addAttribute("driver", customerRepository.findAll());
        return "redirect:/driver";
    }

//    @PostMapping("/{id}/delete")
//    public String delete(@PathVariable("id") int id){
//        _animalDAO.delete(id);
//        System.out.println("сделал");
//        return "redirect:/animal";
//    }
    @PostMapping("/{id}/delete")
        public String deleteUser(@PathVariable("id") long id, Model model) {
        Driver driver = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerRepository.delete(driver);
        model.addAttribute("driver", customerRepository.findAll());
        return "redirect:/driver";
}


//    @GetMapping("/monster")
//    String indexM(){
//        return "monster";
//    }
//    @GetMapping("/heroes")
//    String indexH(){
//        return "heroes";
//    }
//    @GetMapping("/watermonster")
//    String indeW(){
//        return "watermonster";
//    }

}

//jdbc:postgresql://localhost:5432/Pract


