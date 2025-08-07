package Controllers;

import Group.Group;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    private List<Group> groups;
    public GroupController(){
        groups = new ArrayList<>();
    }

    public Group createGroup(int groupId, String groupName, User createdByUser){
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        group.addMember(createdByUser);

        groups.add(group);
        return group;
    }

    public Group getGroup(int groupId){
        for(Group group: groups){
            if(group.getGroupId(groupId) == groupId){
                return group;
            }
        }
        System.out.println("Group not found");
        return null;
    }

    public List<Group> getGroups(){
        return groups;
    }


}
