package com.example.demo.Api;

import com.example.demo.domain.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void renameGroup(@PathVariable Long id, @RequestParam String name) {
        groupService.renameGroup(id,name);
    }

}
