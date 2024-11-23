package com.example.itogprak.Controller;







import com.example.itogprak.Model.Warehouse;
import com.example.itogprak.Repositories.CustomerRepositoryWarehouse;
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
@RequestMapping("/warehouse")
public class WarehouseController {


    private CustomerRepositoryWarehouse customerRepository;
  //  private CustomerRepositoryFM customerRepositoryFM;

    @Autowired
    public WarehouseController(CustomerRepositoryWarehouse customerRepository) {
        this.customerRepository = customerRepository;
    }


//    @GetMapping()
//    public String index(Model model){
//        model.addAttribute("animals", customerRepository.findByName());
//        return "/index";
//    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("warehouse", customerRepository.findAll());
        return "WarehouseIndex";
    }

//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model){
//        model.addAttribute("animal", _animalDAO.show(id));
//        return "/show";
//    }
    //
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        Warehouse warehouse = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("warehouse", warehouse);
        return "WarehouseShow";
    }

    @GetMapping("/new")
    public String newWarehouse(Model model){
        model.addAttribute("warehouse", new Warehouse());
        return "WarehouseNew";
    }

//    @PostMapping
//    public String create(@ModelAttribute("animal")Animal animal){
//        _animalDAO.save(animal);
//        return "redirect:/animal";
//    }
    @PostMapping
    public String create(@Valid Warehouse warehouse, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "WarehouseNew";
        }
        customerRepository.save(warehouse);
        model.addAttribute("warehouse", customerRepository.findAll());
        return "redirect:/warehouse";
    }
//    @GetMapping("/{id}/edit")
//    public String edit(Model model,@PathVariable("id")int id){
//        model.addAttribute("animal", _animalDAO.show(id));
//        return "edit";
//    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model){
        Warehouse warehouse = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("warehouse", warehouse);
        return "WarehouseEdit";
    }

//    @PostMapping("/{id}/edit")
//    public String update(@ModelAttribute("animal")Animal animal, @PathVariable("id")int id){
//        _animalDAO.update(id, animal);
//        return "redirect:/animal";
//    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable("id") long id, @Valid Warehouse warehouse, BindingResult result, Model model){
        if (result.hasErrors()) {
            warehouse.setId(id);
            return "/{id}/edit";
        }

        customerRepository.save(warehouse);
        model.addAttribute("warehouse", customerRepository.findAll());
        return "redirect:/warehouse";
    }

//    @PostMapping("/{id}/delete")
//    public String delete(@PathVariable("id") int id){
//        _animalDAO.delete(id);
//        System.out.println("сделал");
//        return "redirect:/animal";
//    }
    @PostMapping("/{id}/delete")
        public String deleteUser(@PathVariable("id") long id, Model model) {
        Warehouse warehouse = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerRepository.delete(warehouse);
        model.addAttribute("warehouse", customerRepository.findAll());
        return "redirect:/warehouse";
}

//    @GetMapping("/flymonster")
//    String indexFM(){
//        return "flymonster";
//    }
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


