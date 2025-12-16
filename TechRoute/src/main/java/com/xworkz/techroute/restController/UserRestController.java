package com.xworkz.techroute.restController;

import com.xworkz.techroute.dto.ProductMasterDTO;
import com.xworkz.techroute.dto.PurchaseDto;
import com.xworkz.techroute.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
@Slf4j
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService){
        log.info("hellooo");
        this.userService=userService;
    }

    @PostMapping("add-product")
    public ResponseEntity<String> addProductGroup(String productGroupName){
        boolean result = userService.validateAndAddGroupName(productGroupName);
        if(result){
        return ResponseEntity.status(HttpStatus.CREATED).body("product group added");
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body("couldn't add ");
    }

    @GetMapping("fetch-products")
    public List<String> fetchProduct(){
       return userService.fetchProducts();
    }

    @GetMapping("/fetch-debitors")
    public List<String> findAllDebitors(){
        return userService.fetchDebitors();
    }

    @GetMapping("fetch-creditors")
    public List<String> findAllCreditors(){
        return userService.fetchCreditors();
    }

    @GetMapping("fetch-allProductInGroupName")
    public List<ProductMasterDTO> fetchAllInProductGroup(String productGroupName){
        return userService.fetchProductsByGroup(productGroupName);
    }


@PostMapping("purchaseAll")
public ResponseEntity<String> purchaseAll(@RequestBody List<PurchaseDto> purchaseDtos , BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("no okay");
    }
    userService.saveOrders(purchaseDtos);
    return ResponseEntity.status(HttpStatus.CONFLICT).body("no okay");
}

}
