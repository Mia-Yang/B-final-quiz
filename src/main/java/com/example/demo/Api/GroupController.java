// GTB：- 包名应该小写
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
    // GTB: - 字段应该使用private权限
    GroupService groupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/auto-grouping")
    @ResponseStatus(HttpStatus.OK)
    public List<Group> autoGrouping() {
        return groupService.autoGrouping();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    // GTB: - 违反Restful, Patch接口要修改新字段应该通过RequestBody传递，并用对象来接收
    public void renameGroup(@PathVariable Long id, @RequestParam String name) {
        groupService.renameGroup(id,name);
    }
}
