package com.example.itogprak.Controller;





import com.example.itogprak.Model.Shop;
import com.example.itogprak.Repositories.CustomerRepositoryShop;
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
@RequestMapping("/shop")
public class ShopController {


    private CustomerRepositoryShop customerRepository;
  //  private CustomerRepositoryFM customerRepositoryFM;

    @Autowired
    public ShopController(CustomerRepositoryShop customerRepository) {
        this.customerRepository = customerRepository;
    }


//    @GetMapping()
//    public String index(Model model){
//        model.addAttribute("animals", customerRepository.findByName());
//        return "/index";
//    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("shop", customerRepository.findAll());
        return "ShopIndex";
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
        Shop shop = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("shop", shop);
        return "ShopShow";
    }

    @GetMapping("/new")
    public String newShop(Model model){
        model.addAttribute("shop", new Shop());
        return "ShopNew";
    }

//    @PostMapping
//    public String create(@ModelAttribute("animal")Animal animal){
//        _animalDAO.save(animal);
//        return "redirect:/animal";
//    }
    @PostMapping
    public String create(@Valid Shop shop, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "ShopNew";
        }
        customerRepository.save(shop);
        model.addAttribute("shop", customerRepository.findAll());
        return "redirect:/shop";
    }
//    @GetMapping("/{id}/edit")
//    public String edit(Model model,@PathVariable("id")int id){
//        model.addAttribute("animal", _animalDAO.show(id));
//        return "edit";
//    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model){
        Shop shop = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("shop", shop);
        return "ShopEdit";
    }

//    @PostMapping("/{id}/edit")
//    public String update(@ModelAttribute("animal")Animal animal, @PathVariable("id")int id){
//        _animalDAO.update(id, animal);
//        return "redirect:/animal";
//    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable("id") long id, @Valid Shop shop, BindingResult result, Model model){
        if (result.hasErrors()) {
            shop.setId(id);
            return "/{id}/edit";
        }

        customerRepository.save(shop);
        model.addAttribute("shop", customerRepository.findAll());
        return "redirect:/shop";
    }

//    @PostMapping("/{id}/delete")
//    public String delete(@PathVariable("id") int id){
//        _animalDAO.delete(id);
//        System.out.println("сделал");
//        return "redirect:/animal";
//    }
    @PostMapping("/{id}/delete")
        public String deleteUser(@PathVariable("id") long id, Model model) {
        Shop shop = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        customerRepository.delete(shop);
        model.addAttribute("shop", customerRepository.findAll());
        return "redirect:/shop";
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


