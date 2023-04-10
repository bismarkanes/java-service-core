package com.service.core.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.service.core.repository.UserRepository;
import com.service.core.utils.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.service.core.model.User;
import com.service.core.http.HttpResponse;

@RestController
@RequestMapping("/api")
class UserController {
    @Autowired
    private UserRepository ur;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Map<String, String> params) {
        String search = params.get("search");
        if (search == null) {
            search = "";
        }

        String page = params.get("page");
        Integer nPage = 1;
        if (page != null) {
            try {
                nPage = Integer.parseInt(page);
            } catch (Throwable e) {
                // should be http error response
                System.out.println("Error " + e.getMessage());
                e.printStackTrace();
            }
        }

        String limit = params.get("limit");
        Integer nLimit = 10;
        if (limit != null) {
            try {
                nLimit = Integer.parseInt(limit);
            } catch (Throwable e) {
                // should be http error response
                System.out.println("Error " + e.getMessage());
                e.printStackTrace();
            }
        }

        List<User> user = ur.findCustomUsers(search, Pagination.GetOffset(nPage, nLimit), nLimit);

        Integer count = ur.findCountCustomUsers(search);

        HttpResponse hr = HttpResponse.transformResponse(nPage, nLimit, count);

        hr.setData(user);

        return new ResponseEntity<>(hr, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUsers(@RequestBody User userParam) {
        User u = new User();
        u.setName(userParam.getName());
        u.setAddress(userParam.getAddress());

        u = ur.save(u);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable Integer id, @RequestBody User userParam) {
        Optional<User> u = ur.findById(id);
        if (u.isPresent()) {
            User user = u.get();
            user.setName(userParam.getName());
            user.setAddress(userParam.getAddress());
            user = ur.save(user);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        ur.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
