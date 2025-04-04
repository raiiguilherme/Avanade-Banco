package org.rai.projetoavanade.controller;


import jakarta.validation.Valid;
import org.rai.projetoavanade.domain.User;
import org.rai.projetoavanade.domain.dto.UserCreateDto;
import org.rai.projetoavanade.domain.dto.UserResponseDto;
import org.rai.projetoavanade.domain.dto.UserUpdateDto;
import org.rai.projetoavanade.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserCreateDto userCreateDto){
        User userCreated = new User(userCreateDto);
        userService.create(userCreated);

        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(userCreated, userResponseDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long id){
        var userFound = userService.findById(id);

        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(userFound, userResponseDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable Long id,@Valid @RequestBody UserUpdateDto userUpdateDto){

        var user = userService.updateCustomer(id,new User(userUpdateDto));

        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);

        return ResponseEntity.ok(userResponseDto);

    }


}
