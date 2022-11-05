package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.request.menus.MenuFoodDishesSaveRequest;
import red.softn.npedidos.request.menus.MenuRequest;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.service.MenuService;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@Getter
public class MenuController extends CrudController<MenuRequest, MenuResponse, Integer> {
    
    private final MenuService service;
    
    @GetMapping("/{id}/food-dishes")
    public ResponseEntity<?> findAllFoodDishes(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllFoodDishes(id));
    }
    
    @PostMapping("/{id}/food-dishes")
    public ResponseEntity<?> saveFoodDishes(@PathVariable Integer id, @RequestBody MenuFoodDishesSaveRequest request) {
        getService().saveFoodDishes(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @DeleteMapping("/{id}/food-dishes")
    public ResponseEntity<?> deleteFoodDishes(@PathVariable Integer id, @RequestBody MenuFoodDishesSaveRequest request) {
        getService().deleteFoodDishes(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
